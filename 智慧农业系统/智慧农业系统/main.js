// main.js
import Vue from 'vue'
import uView from '@/uni_modules/uview-ui'
Vue.use(uView)
import './uni.promisify.adaptor'
import App from './App'
import store from './store' // 引入 Vuex store

Vue.config.productionTip = false 

App.mpType = 'app'
const app = new Vue({
  ...App,
  store, // 将 store 添加到 Vue 实例中
})

app.$mount()