<template>
    <h2>修改舞蹈房间信息</h2>
    <div id="add-form">
        <el-form
                label-width="100px"
                :model="formLabelAlign"
                style="max-width: 460px"
                size="large"
        >
            <el-form-item label="id">
                <el-input disabled v-model="formLabelAlign.id"/>
                （主键自增，不支持修改）
            </el-form-item>
            <el-form-item label="教室名称">
                <el-input v-model="formLabelAlign.name"/>
            </el-form-item>
            <el-form-item label="面积（㎡）">
                <el-input v-model="formLabelAlign.area"/>
            </el-form-item>
            <el-form-item label="状态">
                <el-input v-model="formLabelAlign.status"/>（0：可用，1：占用）
            </el-form-item>
        </el-form>
    </div>
    <br>
    <el-button type="primary" @click="handleUpdate()">提交更改</el-button>
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
const handleUpdate = () => {
    axios.post('http://localhost:8080/danceroom/update', formLabelAlign).then(res => {
        toMain()
    }).catch(err => {
        alert('修改失败，错误码: ' + err)
    })
}

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
