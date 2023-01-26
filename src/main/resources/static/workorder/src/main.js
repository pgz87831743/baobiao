import Vue from 'vue'
import App from './App.vue'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import './css/info.css';
import axios from 'axios'
import echarts from 'echarts'
import 'layui/dist/css/layui.css'
import 'ant-design-vue/dist/antd.css';
import VueRoute from 'vue-router';
import Router from "@/router";
axios.defaults.baseURL = "http://43.163.232.134:8081/"
Vue.config.productionTip = false
//把axios挂载到vue上，并起一个叫$http的名字
Vue.prototype.$http = axios
Vue.prototype.$echarts = echarts
Vue.use(ElementUI);
Vue.use(VueRoute);
new Vue({
    render: h => h(App),
    router:Router
}).$mount('#app')

