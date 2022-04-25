# Laboratorio TBD entrega 1 - Grupo 1 :flower_playing_cards:

## El proyecto se divide en dos carpetas principales
* Frontend: Carpeta que corresponde a la vista del proyecto desarrollada con  Vue.js y Nux.
* Backend: Carpeta que corresponde a las entidades y relaciones del Modelo Relacional y la conexión con la base de datos.

### Requisitos
* Versión de Java: 18
* Gradle 5.x o superior
* Npm
* Nodejs
* PostgreSQL 12.x

### Instalacion del proyecto
* Descargar el código fuente

# Backend: Base de datos postgreSQL	
<p align="center"><a target="_blank"><img src="https://programacion.net/files/article/20151129021117_postgresql-logo.png" width="400"></a></p>

La base del Backend del proyecto corresponde a una estructura creada por medio de SpringBoot y sus dependencias WEB y conectarla a una base de datos creada con postgreSQL.

# Backend: SpringBoot
<p align="center"><a target="_blank"><img src="https://cleventy.com/wp-content/uploads/2020/05/spring-boot.png" width="400"></a></p>

### Pasos a seguir:
* Configurar URL de conexión en la dirección `src.main.java.grupo1.demo.repositories.databaseContext` dependiendo de sus credenciales y el nombre de la BD.
* En la línea de comandos, dirigirse a la carpeta del proyecto de Backend por medio de `cd Backend`.
* Iniciar proyecto Gradle por medio del comando `gradlew bootRun` en Windows y con `./gradlew bootRun` Linux/Mac.

# Frontend: Vista 
<p align="center"><a target="_blank"><img src="https://camo.githubusercontent.com/c8edb8c44c6d5779eb077924888a4f39f134339bea41d6b242a40a6755215552/687474703a2f2f696d6775722e636f6d2f56344c746f49492e706e67" width="400"></a></p>

* En la línea de comandos, dirigirse a la carpeta del proyecto de Frontend por medio de `cd Frontend`.
* Iniciar la instalación de npm por medio del comando `npm install`
* Ejecutar el proyecto por medio de npm con la siguiente linea de comando `npm dev run`

## Anotaciones

* El enterno de trabajo se realiza de manera local, por lo que la dirección web corresponde a `localhost`
* El puerto que utiliza el Frontend corresponde al puerto `8000`
* El puerto que utiliza el Backend corresponde al puerto `8080`