import Vue from 'vue'
import Router from 'vue-router'
import { normalizeURL, decode } from 'ufo'
import { interopDefault } from './utils'
import scrollBehavior from './router.scrollBehavior.js'

<<<<<<< Updated upstream
const _11170f6c = () => interopDefault(import('..\\pages\\acerca-de.vue' /* webpackChunkName: "pages/acerca-de" */))
const _12b978c3 = () => interopDefault(import('..\\pages\\borrar.vue' /* webpackChunkName: "pages/borrar" */))
const _748343e4 = () => interopDefault(import('..\\pages\\lista.vue' /* webpackChunkName: "pages/lista" */))
const _dfd56716 = () => interopDefault(import('..\\pages\\modificar.vue' /* webpackChunkName: "pages/modificar" */))
const _2725d97c = () => interopDefault(import('..\\pages\\nuevo.vue' /* webpackChunkName: "pages/nuevo" */))
const _42f63846 = () => interopDefault(import('..\\pages\\index.vue' /* webpackChunkName: "pages/index" */))
=======
const _44262769 = () => interopDefault(import('..\\pages\\acerca-de.vue' /* webpackChunkName: "pages/acerca-de" */))
const _4ebeac34 = () => interopDefault(import('..\\pages\\borrar.vue' /* webpackChunkName: "pages/borrar" */))
const _152a06ea = () => interopDefault(import('..\\pages\\lista.vue' /* webpackChunkName: "pages/lista" */))
const _79b7371c = () => interopDefault(import('..\\pages\\modificar.vue' /* webpackChunkName: "pages/modificar" */))
const _1c19b1bf = () => interopDefault(import('..\\pages\\nuevo.vue' /* webpackChunkName: "pages/nuevo" */))
const _0e31825a = () => interopDefault(import('..\\pages\\index.vue' /* webpackChunkName: "pages/index" */))
>>>>>>> Stashed changes

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
<<<<<<< Updated upstream
    component: _11170f6c,
    name: "acerca-de"
  }, {
    path: "/borrar",
    component: _12b978c3,
    name: "borrar"
  }, {
    path: "/lista",
    component: _748343e4,
    name: "lista"
  }, {
    path: "/modificar",
    component: _dfd56716,
    name: "modificar"
  }, {
    path: "/nuevo",
    component: _2725d97c,
    name: "nuevo"
  }, {
    path: "/",
    component: _42f63846,
=======
    component: _44262769,
    name: "acerca-de"
  }, {
    path: "/borrar",
    component: _4ebeac34,
    name: "borrar"
  }, {
    path: "/lista",
    component: _152a06ea,
    name: "lista"
  }, {
    path: "/modificar",
    component: _79b7371c,
    name: "modificar"
  }, {
    path: "/nuevo",
    component: _1c19b1bf,
    name: "nuevo"
  }, {
    path: "/",
    component: _0e31825a,
>>>>>>> Stashed changes
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
