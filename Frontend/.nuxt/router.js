import Vue from 'vue'
import Router from 'vue-router'
import { normalizeURL, decode } from 'ufo'
import { interopDefault } from './utils'
import scrollBehavior from './router.scrollBehavior.js'

const _0be03c74 = () => interopDefault(import('..\\pages\\acerca-de.vue' /* webpackChunkName: "pages/acerca-de" */))
const _70c2ae8a = () => interopDefault(import('..\\pages\\borrar.vue' /* webpackChunkName: "pages/borrar" */))
const _57f74f16 = () => interopDefault(import('..\\pages\\lista.vue' /* webpackChunkName: "pages/lista" */))
const _ea430d06 = () => interopDefault(import('..\\pages\\modificar.vue' /* webpackChunkName: "pages/modificar" */))
const _7ea6044a = () => interopDefault(import('..\\pages\\nuevo.vue' /* webpackChunkName: "pages/nuevo" */))
const _70bdd4e5 = () => interopDefault(import('..\\pages\\index.vue' /* webpackChunkName: "pages/index" */))

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
    component: _0be03c74,
    name: "acerca-de"
  }, {
    path: "/borrar",
    component: _70c2ae8a,
    name: "borrar"
  }, {
    path: "/lista",
    component: _57f74f16,
    name: "lista"
  }, {
    path: "/modificar",
    component: _ea430d06,
    name: "modificar"
  }, {
    path: "/nuevo",
    component: _7ea6044a,
    name: "nuevo"
  }, {
    path: "/",
    component: _70bdd4e5,
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
