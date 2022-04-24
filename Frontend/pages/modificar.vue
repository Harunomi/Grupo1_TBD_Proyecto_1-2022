<template>
  <div class="container">
    <h1>Editar libro</h1>
    <form @submit.prevent="handleSubmitForm">
      <div class="form-item">
        <label>ID</label>
        <input type="number" id="id" v-model="newBook.id" />
      </div>
      <div class="form-item">
        <label>Titulo</label>
        <input type="text" id="titulo" v-model="newBook.titulo" />
      </div>
      <div class="form-item">
        <label>Autor</label>
        <input type="text" id="autor" v-model="newBook.autor" />
      </div>
      <div class="form-item">
        <label>Editorial</label>
        <input type="text" id="editorial" v-model="newBook.editorial" />
      </div>
      <div class="form-item">
        <label>Paginas</label>
        <input type="number" id="paginas" v-model="newBook.paginas" />
      </div>
      <div class="form-item">
        <label>Precio</label>
        <input type="number" id="precio" v-model="newBook.precio" />
      </div>
      <div class="form-item">
        <label>volumen</label>
        <input type="number" id="volumen" v-model="newBook.volumen" />
      </div>
      <div>
        <button @click.prevent="deleteBook(newBook.id)" type="submit" class="main">Modificar</button>
      </div>
    </form>
  </div>
</template>



<script>
import axios from "axios";

export default {
  data() {
    return {
      message: "",
      newBook: {
        id: "",
        titulo: "",
        autor: "",
        editorial: "",
        paginas: "",
        precio: "",
        volumen: "",
      },
    };
  },
  methods: {
    deleteBook(id) {
            console.log(id);
            axios.delete("http://localhost:8080/books/delete/" + id).then(res => {
            console.log(res);
                });
      let apiURL = "http://localhost:8080/books/updateBook";
      axios.post(apiURL, {
          id: this.newBook.id,
          titulo: this.newBook.titulo,
          autor: this.newBook.autor,
          editorial: this.newBook.editorial,
          paginas: this.newBook.paginas,
          precio: this.newBook.precio,
          volumen: this.newBook.volumen,
        })
        .then((res) => {
          this.respuesta = res.data;
          alert(this.respuesta);
        })
        .catch((error) => {
          alert(error);
          console.log(error);
        });
            }
  },
  //Función que se ejecuta al cargar el componente
  /*created: function () {
    this.getData();
  },*/
};
</script>

<style lang="scss" scoped>
</style>