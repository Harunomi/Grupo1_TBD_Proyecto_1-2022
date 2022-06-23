<template>
  <div class="container">
    <h1>Buscador de Voluntarios</h1>
    <form @submit.prevent="handleSubmitForm">
      <div class="form-item">
        <label>Seleccione la emergencia a buscar voluntarios</label>
        <select v-model="nuevaBusqueda.id">
          <option disabled value="">Emergencias</option>
          <option
            v-for="(emergencia, index) in emergencias"
            :key="index"
            :value="emergencia.id"
          >
            {{ emergencia.titulo }}
          </option>
        </select>
      </div>
      <div class="form-item">
        <label>Ingrese cantidad de voluntarios a buscar</label>
        <input
          type="number"
          id="numeroVoluntarios"
          min="1"
          v-model="nuevaBusqueda.cantidad"
        />
      </div>
      <div>
        <button type="submit" class="main">Buscar</button>
      </div>
    </form>
    <h1>Resultado de la busqueda de voluntarios</h1>
    <div id="mapid"></div>
  </div>
</template>

<script>
//Importaciones
import "leaflet/dist/leaflet"; //librería leaflet
import "leaflet/dist/leaflet.css"; //css leaflet
var icon = require("leaflet/dist/images/marker-icon.png"); //ícono de marcadores
//Se crea objeto ícono con el marcador
var LeafIcon = L.Icon.extend({
  options: { iconSize: [25, 41], iconAnchor: [12, 41], popupAnchor: [-3, -41] },
});
var myIcon = new LeafIcon({ iconUrl: icon });
//librería axios
import axios from "axios";
export default {
  data: function () {
    return {
      selected: null,
      points: [], //colección de puntos cargados de la BD
      emergencias: [],
      numeroVoluntarios: "",
      mymap: null,
      voluntarios: [],
      nuevaBusqueda: {
        id: null,
        cantidad: null,
      },
    };
  },
  computed: {
    point() {
      // función computada para representar el punto seleccionado
      if (this.latitude && this.longitude) {
        let lat = this.latitude.toFixed(3);
        let lon = this.longitude.toFixed(3);
        return `(${lat}, ${lon})`;
      } else {
        return "";
      }
    },
  },
  methods: {
    handleSubmitForm() {
      this.clearMarkers(this.mymap);
      //Se agregan los puntos mediante llamada al servicio
      this.getPoints(this.mymap);
    },
    getData: async function () {
      try {
        let response = await this.$axios.get("/emergencias/");
        this.emergencias = response.data;
        console.log(response);
      } catch (error) {
        console.log("Error al obtener las emergencias", error);
      }
    },
    clearMarkers: function () {
      //eliminar marcadores

      this.points.forEach((p) => {
        this.mymap.removeLayer(p);
      });
      this.points = [];
    },
    async createPoint() {
      //Crear un nuevo punto
      this.message = "";
      let newPoint = {
        name: this.name,
        latitude: this.latitude,
        longitude: this.longitude,
      };

      try {
        let response = await axios.post(
          "/obtenerVoluntariosCercanos",
          newPoint
        );
        console.log("response", response.data);
        let id = response.data.id;
        this.message = `${this.name} fue creado con éxito con id: ${id}`;
        this.name = "";
        this.clearMarkers(this.mymap);
        this.getPoints(this.mymap);
      } catch (error) {
        console.log("error", error);
        this.message = "Ocurrió un error";
      }
    },
    async getPoints(map) {
      try {
        //se llama el servicio
        let response = await this.$axios
          .post("/obtenerVoluntariosCercanos", {
            id: this.nuevaBusqueda.id,
            cantidad: this.nuevaBusqueda.cantidad,
          })
          .then((res) => {
            this.respuesta = res.data;
            //.post dentro de aqui
          })
          .catch((error) => {
            alert(error);
            console.log(error);
          });
        let dataPoints = this.respuesta;
        //Se itera por los puntos
        dataPoints.forEach((point) => {
          //Se crea un marcador por cada punto
          let p = [point.latitude, point.longitude];
          let marker = L.marker(p, { icon: myIcon }) //se define el ícono del marcador
            .bindPopup(point.nombre); //Se agrega un popup con el nombre

          //Se agrega a la lista
          this.points.push(marker);
        });
        //Los puntos de la lista se agregan al mapa
        this.points.forEach((p) => {
          p.addTo(map);
        });
      } catch (error) {
        console.log("error", error);
      }
    },
  },
  mounted: function () {
    let _this = this;
    //Se asigna el mapa al elemento con id="mapid"
    this.mymap = L.map("mapid").setView([-33.456, -70.648], 10);
    //Se definen los mapas de bits de OSM
    L.tileLayer("http://{s}.tile.osm.org/{z}/{x}/{y}.png", {
      attribution:
        '&copy; <a href="http://osm.org/copyright">OpenStreetMap</a> contributors',
      maxZoom: 20,
    }).addTo(this.mymap);
    //Evento click obtiene lat y long actual
    this.mymap.on("click", function (e) {
      _this.latitude = e.latlng.lat;
      _this.longitude = e.latlng.lng;
    });
  },
  created: function () {
    this.getData();
  },
};
</script>

<style>
.home {
  display: flex;
  flex-direction: column;
  align-items: center;
}
/* Estilos necesarios para definir el objeto de mapa */
#mapid {
  height: 400px;
  width: 600px;
}
</style>