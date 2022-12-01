import Vue from 'vue'
import App from './App.vue'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import axios from 'axios'
import echarts from 'echarts'

axios.defaults.baseURL = "http://localhost:8011/work/"
Vue.config.productionTip = false
//把axios挂载到vue上，并起一个叫$http的名字
Vue.prototype.$http = axios
Vue.prototype.$echarts = echarts
Vue.use(ElementUI);
new Vue({
    render: h => h(App),
}).$mount('#app')

