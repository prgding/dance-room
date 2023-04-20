<template>
    <h2>舞蹈房间详情</h2>
    <div id="add-form">
        <el-form
            label-width="100px"
            :model="formLabelAlign"
            style="max-width: 460px"
            size="large"
        >
            <el-form-item label="id">
                <el-input v-model="formLabelAlign.id"/>
            </el-form-item>
            <el-form-item label="教室名称">
                <el-input v-model="formLabelAlign.name"/>
            </el-form-item>
            <el-form-item label="面积">
                <el-input v-model="formLabelAlign.area"/>
            </el-form-item>
            <el-form-item label="状态">
                <el-input v-model="formLabelAlign.status"/>
            </el-form-item>
        </el-form>
    </div>
    <br>
    <el-button @click="toMain()">返回</el-button>
</template>

<script setup>
import {reactive, ref} from 'vue'
import {useRoute, useRouter} from 'vue-router'
import axios from "axios";
const route = useRoute()
const id = route.params.id

axios.get(`http://localhost:8080/danceroom/findOne?id=${id}`).then(res => {
    formLabelAlign.name = res.data.name
    formLabelAlign.area = res.data.area
    formLabelAlign.status = res.data.status
}).catch(err => {
    alert('添加失败，错误码: ' + err)
})

const router = useRouter()
const labelPosition = ref('right')

function toMain() {
    router.push('/')
}

const formLabelAlign = reactive({
    id: id,
    name: '',
    area: '',
    status: '',
})
</script>

<style scoped>
#add-form {
    padding-top: 30px;
    width: 500px;
    margin: auto;
}
</style>
