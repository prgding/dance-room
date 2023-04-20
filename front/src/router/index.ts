import type {App} from 'vue'
import {createRouter, createWebHashHistory} from 'vue-router'
import List from "@/components/List.vue";
import Add from "@/components/Add.vue";
import Edit from "@/components/Edit.vue";
import Detail from "@/components/Detail.vue";

const router = createRouter({
    history: createWebHashHistory(),
    routes: [
        {
            path: '/',
            component: List
        },
        {
            path: '/add',
            component: Add
        },
        {
            path: '/edit/:id',
            component: Edit,
            props: true
        },
        {
            path: '/detail/:id',
            component: Detail,
        }
    ],
})

export const setupRouter = (app: App<Element>) => {
    app.use(router)
}

export default router