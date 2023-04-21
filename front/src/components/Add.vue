<template>
    <h2>新增舞蹈房间</h2>
    <div id="add-form">
        <el-form
                label-width="100px"
                :model="formLabelAlign"
                style="max-width: 460px"
                size="large">

            <el-form-item label="教室名称">
                <div class="mt-4" style="width: 100%">
                    <el-input
                            v-model="formLabelAlign.name"
                            placeholder="房间号"
                            class="input-with-select"
                    >
                        <template #prepend>
                            <el-select v-model="select" placeholder="选择楼层" style="width: 115px">
                                <el-option label="1楼" value="1楼"/>
                                <el-option label="2楼" value="2楼"/>
                                <el-option label="3楼" value="3楼"/>
                                <el-option label="4楼" value="4楼"/>
                                <el-option label="5楼" value="5楼"/>
                                <el-option label="6楼" value="6楼"/>
                            </el-select>
                        </template>
                    </el-input>
                </div>
            </el-form-item>

            <el-form-item label="面积">
                <el-input v-model="formLabelAlign.area" placeholder="单位：㎡"/>
            </el-form-item>

            <el-form-item label="状态">
                <el-select v-model="formLabelAlign.status" class="m-2" placeholder="当前是否可用" size="large" style="width: 100%;">
                    <el-option
                            v-for="item in options"
                            :key="item.value"
                            :label="item.label"
                            :value="item.value"
                    />
                </el-select>
            </el-form-item>
        </el-form>
    </div>
    <br>
    <el-button type="primary" @click="handleAdd()">确定</el-button>
    <el-button @click="toMain()">返回</el-button>
</template>

<script lang="ts" setup>
import {reactive, ref} from 'vue'
import {ElButton} from "element-plus";
import {useRouter} from 'vue-router'
import axios from "axios";
import conf from '@/config'
const url = conf.url

const options = [
    {
        value: '0',
        label: '可用',
    },
    {
        value: '1',
        label: '占用',
    }
]

const router = useRouter()
const labelPosition = ref('right')
const handleAdd = () => {
    axios.post(`${url}/add`, {
        name: select.value + formLabelAlign.name,
        area: formLabelAlign.area,
        status: formLabelAlign.status
    }).then(res => {
        if (res.status === 200) {
            toMain()
        }
    }).catch(err => {
        alert('添加失败，错误码: ' + err)
    })
}

function toMain() {
    router.push('/')
}

const formLabelAlign = reactive({
    name: '',
    area: '',
    status: '',
})

const select = ref('')
</script>
<style scoped>
#add-form {
    padding-top: 30px;

    width: 500px;
    margin: auto;
}

.input-with-select {
    background-color: var(--el-fill-color-blank);
}
</style>
