<template>
  <div class="container">
    <h1>Agregar Nueva Emergencia</h1>
    <form @submit.prevent="handleSubmitForm">
      <div class="form-item">
        <label>Titulo</label>
        <input type="text" id="titulo" v-model="newEmergencia.titulo" />
      </div>
      <div class="form-item">
        <label>Ubicacion</label>
        <input
          type="text"
          id="ubicacion_emergencia"
          v-model="newEmergencia.ubicacion_emergencia"
        />
      </div>
      <div class="form-item">
        <label>Maximo de Voluntarios</label>
        <input
          type="numer"
          id="maximo_voluntarios"
          v-model="newEmergencia.maximo_voluntarios"
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
      <div>
        <button type="submit" class="main">Crear</button>
      </div>
      <div class="info">
        <h2>Objeto</h2>
        <code>{{ newEmergencia}}</code>
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
      newEmergencia: {
        titulo: "",
        ubicacion_emergencia: "",
        maximo_voluntarios: "",
        descripcion: "",
      },
    };
  },
  methods: {
    handleSubmitForm() {
      let apiURL = "http://localhost:8080/emergencias/create";
      axios
        .post(apiURL, {
          titulo: this.newEmergencia.titulo,
          ubicacion_emergencia: this.newEmergencia.ubicacion_emergencia,
          maximo_voluntarios: this.newEmergencia.maximo_voluntarios,
          descripcion: this.newEmergencia.descripcion,
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