import VueRouter from "vue-router";
import CardSwiping from "@/components/CardSwiping";
import CheckData from "@/components/CheckData";
import CheckSpeech from "@/components/CheckSpeech";


export default new VueRouter({
    mode: 'hash',
    routes: [
        {
            path: '/',
            component: CheckData
        },
        {
            path: '/CardSwiping',
            component: CardSwiping
        },
        {
            path: '/CheckSpeech',
            component: CheckSpeech
        }
        ,
        {
            path: '/CheckData',
            component: CheckData
        }
    ]
})
