<template>
  <div class="container">
    <h1>Agregar Nueva Emergencia</h1>
    <form @submit.prevent="handleSubmitForm">
      <div class="form-item">
        <label>Titulo</label>
        <input type="text" id="titulo" v-model="newEmergencia.titulo" />
      </div>
      <div class="form-item">
        <label>Maximo de Voluntarios</label>
        <input
          type="number"
          min="1"
          v-model="newEmergencia.maximoVoluntarios"
        />
      </div>
      <div class="form-item">
        <label>Descripción</label>
        <input
          type="text"
          id="descripcion"
          v-model="newEmergencia.descripcion"
        />
      </div>
      <div class="form-item">
        <label>Requisitos</label>
        <input type="text" id="array" v-model="newEmergencia.array" />
      </div>
      <div class="form-item">
        <div>Coordenadas: {{ point }}</div>
        <div>{{ message }}</div>
        <div id="mapid"></div>
      </div>
      <div>
        <button type="submit" class="main">Crear</button>
      </div>
      <div class="info">
        <h2>Objeto</h2>
        <code>{{ newEmergencia }}</code>
        <p class="message">
          {{ message }}
        </p>
      </div>
      <h1>Requisitos existentes</h1>
      <ul class="item-list">
        <li v-for="(habilidad, index) in habilidades" :key="index">
          ID: {{ habilidad.id }} - Nombre: {{ habilidad.nombre }}.
        </li>
      </ul>
    </form>
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
  name: "Home",
  data: function () {
    return {
      latitude: null, //Datos de nuevo punto
      longitude: null,
      name: "",
      points: [], //colección de puntos cargados de la BD
      message: "",
      mymap: null, //objeto de mapa(DIV)
      newEmergencia: {
        titulo: "",
        maximoVoluntarios: "",
        descripcion: "",
      },
      habilidades: [],
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
      let apiURL = "http://localhost:8080/emergencias/create";
      axios
        .post(apiURL, {
          titulo: this.newEmergencia.titulo,
          maximo_voluntarios: this.newEmergencia.maximoVoluntarios,
          descripcion: this.newEmergencia.descripcion,
          latitude: this.latitude,
          longitude: this.longitude,
        })
        .then((res) => {
          this.respuesta = res.data;
          alert(this.respuesta);
          //.post dentro de aqui
        })
        .catch((error) => {
          alert(error);
          console.log(error);
        });
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
        let response = await axios.post("http://localhost:3000/", newPoint);
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
        let response = await axios.get("http://localhost:3000/");
        let dataPoints = response.data;
        //Se itera por los puntos
        dataPoints.forEach((point) => {
          //Se crea un marcador por cada punto
          let p = [point.latitude, point.longitude];
          let marker = L.marker(p, { icon: myIcon }) //se define el ícono del marcador
            .bindPopup(point.name); //Se agrega un popup con el nombre

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
    this.mymap = L.map("mapid").setView([-33.456, -70.648], 7);
    //Se definen los mapas de bits de OSM
    L.tileLayer("http://{s}.tile.osm.org/{z}/{x}/{y}.png", {
      attribution:
        '&copy; <a href="http://osm.org/copyright">OpenStreetMap</a> contributors',
      maxZoom: 18,
    }).addTo(this.mymap);
    //Evento click obtiene lat y long actual
    this.mymap.on("click", function (e) {
      _this.latitude = e.latlng.lat;
      _this.longitude = e.latlng.lng;
    });
    //Se agregan los puntos mediante llamada al servicio
    this.getPoints(this.mymap);
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