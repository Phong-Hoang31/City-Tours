import Vue from 'vue'
import App from './App.vue'
import router from './router/index'
import store from './store/index'
import axios from 'axios'
import vuetify from './plugins/vuetify'


Vue.config.productionTip = false

axios.defaults.baseURL = process.env.VUE_APP_REMOTE_API;

new Vue({
  router,
  store,
  vuetify,
  filters(formatTime, value) {
    if (value) {
      const parts = value.split(":");
      return +parts[0] + "h " + +parts[1] + "m";
    } else {
      return "unknown"
    }
  }
  render: h => h(App)
}).$mount('#app')
