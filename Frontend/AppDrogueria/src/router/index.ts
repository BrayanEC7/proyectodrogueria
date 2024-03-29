import { createRouter, createWebHistory } from 'vue-router'
import IndexView from '../views/IndexView.vue'
import PersonasView from '../views/PersonasView.vue'
import ProductosView from '../views/ProductosView.vue'
import PresentacionesView from '../views/PresentacionesView.vue'
import UsuariosView from '../views/UsuariosView.vue'
import MenusView from '../views/MenusView.vue'
import LoginView from '../views/LoginView1.vue'
import ProveedoresView from '../views/ProveedoresView.vue'
import CategoriasView from '../views/CategoriasView.vue'
import MarcasView from '../views/MarcasView.vue'
import EmpleadosView from '../views/EmpleadosView.vue'
import ClientesView from '../views/ClientesView.vue'
import FacturacionesView from '../views/FacturacionesView.vue'
import PedidosView from '../views/PedidosView.vue'
import ModelosView from '../views/ModelosView.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: IndexView
    },
    {
      path: '/personas',
      name: 'personas',
      component: PersonasView
    },
    {
      path: '/productos',
      name: 'productos',
      component: ProductosView
    },
    {
      path: '/usuarios',
      name: 'usuarios',
      component: UsuariosView
    },
    {
      path: '/menus',
      name: 'menus',
      component: MenusView
    },
    {
      path: '/login',
      name: 'login',
      component: LoginView
    },
    {
      path: '/presentaciones',
      name: 'presentaciones',
      component: PresentacionesView
    },
    {
      path: '/marcas',
      name: 'marcas',
      component: MarcasView
    },
    {
      path: '/proveedores',
      name: 'proveedores',
      component: ProveedoresView
    },
    {
      path: '/categorias',
      name: 'categorias',
      component: CategoriasView
    },
    {
      path: '/empleados',
      name: 'empleados',
      component: EmpleadosView
    },
    {
      path: '/clientes',
      name: 'clientes',
      component: ClientesView
    },
    {
      path: '/facturaciones',
      name: 'facturaciones',
      component: FacturacionesView
    },
    {
      path: '/pedidos',
      name: 'pedidos',
      component: PedidosView
    },
    {
      path: '/modelos',
      name: 'modelos',
      component: ModelosView
    },
  ]
})

export default router