import {createApp} from 'vue'
import App from './App.vue'
import router, {setupRouter} from '@/router'

// element-plus
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'


const setupAll = async () => {
    const app = createApp(App)
    setupRouter(app)
    await router.isReady()
    app.use(ElementPlus)
    app.mount('#app')
}
setupAll().then()