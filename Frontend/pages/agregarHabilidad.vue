<template>
  <div class="container">
    <h1>Requisitos existentes</h1>
    <ul class="item-list">
      <li v-for="(habilidad, index) in habilidades" :key="index">
        ID: {{ habilidad.id }} - Nombre: {{ habilidad.nombre }}.
      </li>
    </ul>
    <h1>Agregar Requisitos</h1>
    <form @submit.prevent="handleSubmitForm">
      <div class="form-item">
        <label>ID Emergencia</label>
        <input
          type="numer"
          id="id_emergencia"
          v-model="eme_habi.id_emergencia"
        />
      </div>

      <div class="form-item">
        <label>ID Habilidad</label>
        <input type="numer" id="id_habilidad" v-model="eme_habi.id_habilidad" />
      </div>

      <div>
        <button type="submit" class="main">Agregar</button>
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
      eme_habi: {
        id_emergencia: "",
        id_habilidad: "",
      },
      habilidades: [],
    };
  },
  //duda agregar los elementos de array para crear las tablas intermedias, .then o .post, como hacerlo ciclico
  methods: {
    handleSubmitForm() {
      let apiURL = "http://localhost:8080/emergencia_habilidad/create";
      axios
        .post(apiURL, {
          id_emergencia: this.eme_habi.id_emergencia,
          id_habilidad: this.eme_habi.id_habilidad,
        })
        .then((res) => {
          this.respuesta = res.data;
          alert(this.respuesta);
        })
        .catch((error) => {
          alert(error);
          console.log(error);
        });
    },
    getData: async function () {
      try {
        let response = await this.$axios.get("/habilidades");
        this.habilidades = response.data;
        console.log(response);
      } catch (error) {
        console.log("error", error);
      }
    },
  },
  created: function () {
    this.getData();
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