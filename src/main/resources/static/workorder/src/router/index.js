import VueRouter from "vue-router";
import LoginFrom from "@/components/user/LoginFrom";
import HelloWord from "@/components/manager/HelloWord";
import ErrorPage from "@/components/error/ErrorPage";


export default new VueRouter({
    mode: 'hash',
    routes: [
        {
            path: '/',
            component: LoginFrom
        },
        {
            path: '/login',
            component: LoginFrom
        }
        ,
        {
            path: '/HelloWord',
            component: HelloWord
        }
        ,
        {
            path: '/error',
            component: ErrorPage
        }
    ]
})
