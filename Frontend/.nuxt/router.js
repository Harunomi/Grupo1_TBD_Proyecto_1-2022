import Vue from 'vue'
import Router from 'vue-router'
import { normalizeURL, decode } from 'ufo'
import { interopDefault } from './utils'
import scrollBehavior from './router.scrollBehavior.js'

const _05163515 = () => interopDefault(import('..\\pages\\acerca-de.vue' /* webpackChunkName: "pages/acerca-de" */))
const _3a359147 = () => interopDefault(import('..\\pages\\agregarHabilidad.vue' /* webpackChunkName: "pages/agregarHabilidad" */))
const _2271488c = () => interopDefault(import('..\\pages\\borrar.vue' /* webpackChunkName: "pages/borrar" */))
const _4b504398 = () => interopDefault(import('..\\pages\\buscarVoluntarios.vue' /* webpackChunkName: "pages/buscarVoluntarios" */))
const _617cc037 = () => interopDefault(import('..\\pages\\lista.vue' /* webpackChunkName: "pages/lista" */))
const _f7d71bc4 = () => interopDefault(import('..\\pages\\modificar.vue' /* webpackChunkName: "pages/modificar" */))
const _50607ee0 = () => interopDefault(import('..\\pages\\mostrarVoluntarios.vue' /* webpackChunkName: "pages/mostrarVoluntarios" */))
const _efa9152a = () => interopDefault(import('..\\pages\\nuevo.vue' /* webpackChunkName: "pages/nuevo" */))
const _2ec8baac = () => interopDefault(import('..\\pages\\nuevoVoluntario.vue' /* webpackChunkName: "pages/nuevoVoluntario" */))
const _7a434606 = () => interopDefault(import('..\\pages\\index.vue' /* webpackChunkName: "pages/index" */))

const emptyFn = () => {}

Vue.use(Router)

export const routerOptions = {
  mode: 'history',
  base: '/',
  linkActiveClass: 'nuxt-link-active',
  linkExactActiveClass: 'nuxt-link-exact-active',
  scrollBehavior,

  routes: [{
    path: "/acerca-de",
    component: _05163515,
    name: "acerca-de"
  }, {
    path: "/agregarHabilidad",
    component: _3a359147,
    name: "agregarHabilidad"
  }, {
    path: "/borrar",
    component: _2271488c,
    name: "borrar"
  }, {
    path: "/buscarVoluntarios",
    component: _4b504398,
    name: "buscarVoluntarios"
  }, {
    path: "/lista",
    component: _617cc037,
    name: "lista"
  }, {
    path: "/modificar",
    component: _f7d71bc4,
    name: "modificar"
  }, {
    path: "/mostrarVoluntarios",
    component: _50607ee0,
    name: "mostrarVoluntarios"
  }, {
    path: "/nuevo",
    component: _efa9152a,
    name: "nuevo"
  }, {
    path: "/nuevoVoluntario",
    component: _2ec8baac,
    name: "nuevoVoluntario"
  }, {
    path: "/",
    component: _7a434606,
    name: "index"
  }],

  fallback: false
}

export function createRouter (ssrContext, config) {
  const base = (config._app && config._app.basePath) || routerOptions.base
  const router = new Router({ ...routerOptions, base  })

  // TODO: remove in Nuxt 3
  const originalPush = router.push
  router.push = function push (location, onComplete = emptyFn, onAbort) {
    return originalPush.call(this, location, onComplete, onAbort)
  }

  const resolve = router.resolve.bind(router)
  router.resolve = (to, current, append) => {
    if (typeof to === 'string') {
      to = normalizeURL(to)
    }
    return resolve(to, current, append)
  }

  return router
}
