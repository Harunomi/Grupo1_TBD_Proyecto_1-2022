<template>
  <div class="container">
    <h1>Agregar un libro</h1>
    <form @submit.prevent="handleSubmitForm">
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
        <button type="submit" class="main">Crear</button>
      </div>
      <div class="info">
        <h2>Objeto</h2>
        <code>{{ newBook }}</code>
        <p class="message">
          {{ message }}
        </p>
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
        titulo: '',
        autor: '',
        editorial: '',
        paginas: '',
        precio: '',
        volumen: ''
      },
    };
  },
  methods: {
    /*
    send: async function () {
      this.message = "";
      //validaciones de formulario
      if (this.newBook.nombre == "") {
        this.message = "Debes ingresar un nombre";
        return false;
      }
      //envío de datos del formulario
      try {
        var result = await this.$axios.post("/books", this.newBook);
        let book = result.data;
        //mensaje de exito
        this.message = `Se creó un nuevo libro con id: ${book.id}`;
        this.newBook = {};
      } catch (error) {
        //mensaje de error
        console.log("error", error);
        this.message = "Ocurrió un error";
      }
    },
    */
    handleSubmitForm() {
                let apiURL = 'http://localhost:8080/books/create';
                axios.post(apiURL, {
                    titulo : this.newBook.titulo,
                    autor : this.newBook.autor,
                    editorial : this.newBook.editorial,
                    paginas : this.newBook.paginas,
                    precio : this.newBook.precio,
                    volumen : this.newBook.volumen
                    }).then(res => {
                    this.respuesta = res.data;
                    alert(this.respuesta);
        
                }).catch(error => {
                    alert(error)
                    console.log(error)
                });
            },
  },
};
</script>
<style>
code {
  padding: 0.5rem 1rem;
  color: white;
  background: #444;
  font-size: 1rem;
  width: 100%;
  display: inline-block;
}
p.message {
  border: solid 1px rgba(0, 0, 0, 0.25);
  padding: 0.5rem 1rem;
  font-weight: bold;
}
</style>