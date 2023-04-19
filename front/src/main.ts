import {createApp} from 'vue'
import App from './App.vue'
// @ts-ignore
import {axios} from 'axios';
// element-plus
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'

const app = createApp(App)

app.use(ElementPlus, {size: 'small', zIndex: 3000})
app.mount('#app')