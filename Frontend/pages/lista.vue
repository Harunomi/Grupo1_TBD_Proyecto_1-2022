<template>
  <div class="container">
    <h1>Emergencias Activas</h1>
    <ul class="item-list">
      <li v-for="(emergencia, index) in emergencias" :key="index">
        ID: {{ emergencia.id }} - Titulo: {{ emergencia.titulo }}. Ubicacion:
        {{ emergencia.ubicacion_emergencia }}. Maximo Voluntarios:
        {{ emergencia.maximo_voluntarios }}. Voluntarios:
        {{ emergencia.voluntarios }}. Descripción: {{ emergencia.descripcion }}
      </li>
    </ul>
    <div v-if="emergencias.length == 0" class="empty-list">
      <em>No hay emergencias activas en el momento.</em>
    </div>
  </div>
</template>
<script>
export default {
  //Función que contiene los datos del componente
  data() {
    return {
      //Lista de emergencias a mostrar
      emergencias: [],
    };
  },
  methods: {
    //Función asíncrona para consultar los datos
    getData: async function () {
      try {
        let response = await this.$axios.get("/emergencias");
        this.emergencias = response.data;
        console.log(response);
      } catch (error) {
        console.log("error", error);
      }
    },
  },
  //Función que se ejecuta al cargar el componente
  created: function () {
    this.getData();
  },
};
</script>