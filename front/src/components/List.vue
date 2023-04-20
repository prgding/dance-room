<template>
    <div id="table-div">
        <el-table :data="filterTableData" size="large">
            <el-table-column label="id" prop="id"/>
            <el-table-column label="教室名称" prop="name"/>
            <el-table-column label="面积（单位：㎡）" prop="area"/>
            <el-table-column label="状态（0：可用，1：被占用）" prop="status"/>
            <el-table-column align="right">
                <template #header>
                    <el-input v-model="search" size="default" placeholder="搜索教室名称..."/>
                </template>
                <template #default="scope">
                    <el-button size="small" @click="handleEdit(scope.$index, scope.row)"
                    >修改
                    </el-button>

                    <el-button
                            size="small"
                            type="primary"
                            @click="handleDetail(scope.$index, scope.row)"
                    >详情
                    </el-button>

                    <el-popconfirm title="确定删除吗？"
                                   @confirm="handleDelete(scope.$index, scope.row)"
                                   confirm-button-text="确定"
                                   cancel-button-text="取消">
                        <template #reference>
                            <el-button
                                    size="small"
                                    type="danger"
                            >删除
                            </el-button>
                        </template>
                    </el-popconfirm>
                </template>
            </el-table-column>
        </el-table>
    </div>
    <Button/>
</template>

<script lang="ts" setup>
import {computed, ref} from 'vue'
import axios from "axios";
import Button from "@/components/Button.vue";
import {useRouter} from 'vue-router'

const router = useRouter()

axios.get('http://localhost:8080/findAll').then((res) => {
    tableData.value = res.data;
})

interface User {
    id: number
    name: string
    area: number
    status: number
}

const search = ref('')
const tableData = ref<User[]>([])

const filterTableData = computed(() =>
    tableData.value.filter(
        (data: User) =>
            !search.value ||
            data.name.toLowerCase().includes(search.value.toLowerCase())
    )
)
const handleEdit = (index: number, row: User) => {
    router.push(`/edit/${row.id}`)
}
const handleDetail = (index: number, row: User) => {
    router.push(`/detail/${row.id}`)
}
const handleDelete = (index: number, row: User) => {
    axios.get(`http://localhost:8080/del?id=${row.id}`).then(res => {
        axios.get('http://localhost:8080/findAll').then((res) => {
            tableData.value = res.data;
        })
    }).catch(err => {
        alert('删除失败，错误码: ' + err)
    })
}


</script>
<style scoped>
#table-div {
    padding: 0 10px;
}
</style>
