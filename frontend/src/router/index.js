import { createRouter, createWebHistory } from 'vue-router'
import Home from '../views/Home.vue'
import Pomodoro from '../views/Pomodoro.vue'

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path:'/pomodoro',
    name:'pomodoro',
    component: Pomodoro
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
