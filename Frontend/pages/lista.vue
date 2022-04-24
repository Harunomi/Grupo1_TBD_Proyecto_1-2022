<template>
  <div class="container">
    <h1>Todos los libros</h1>
    <ul class="item-list">
      <li v-for="(libro, index) in libros" :key="index">
        <!-- <img :src="'https://loremflickr.com/160/120/book?lock='+i"/>-->
        <!-- {{index}} -  -->
        ID: {{ libro.id }} - Titulo: {{ libro.titulo }}. Autor: {{ libro.autor }}.
        Editorial: {{ libro.editorial }}. Páginas: {{ libro.paginas }}. Precio:
        {{ libro.precio }}. Volumen: {{ libro.volumen }}
      </li>
    </ul>
    <div v-if="libros.length == 0" class="empty-list">
      <em>No se existen libros guardados aún.</em>
    </div>
  </div>
</template>
<script>
export default {
  //Función que contiene los datos del componente
  data() {
    return {
      //Lista de libros a mostrar
      libros: [],
    };
  },
  methods: {
    //Función asíncrona para consultar los datos
    getData: async function () {
      try {
        let response = await this.$axios.get("/books");
        this.libros = response.data;
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