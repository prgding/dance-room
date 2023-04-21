<template>
    <el-table :data="filterTableData" size="large">
        <el-table-column label="教室名称" prop="name" />
        <el-table-column label="面积" prop="area" />
        <el-table-column label="状态" prop="status" />
        <el-table-column align="right">
            <template #header>
                <el-input v-model="search" size="default" placeholder="搜索教室名称..." />
            </template>
            <template #default="scope">
                <el-button size="default" @click="handleEdit(scope.$index, scope.row)">修改</el-button>

                <el-button
                    size="default"
                    type="primary"
                    @click="handleDetail(scope.$index, scope.row)"
                >详情</el-button>

                <el-button
                    size="default"
                    type="danger"
                    @click="handleDelete(scope.$index, scope.row)"
                >删除</el-button>
            </template>
        </el-table-column>
    </el-table>
</template>

<script lang="ts" setup>
import { computed, ref } from 'vue'
import axios from "axios";
import conf from '@/config'
const url = conf.url

interface User {
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
    console.log(index, row)
}
const handleDetail = (index: number, row: User) => {
    console.log(index, row)
}
const handleDelete = (index: number, row: User) => {
    console.log(index, row)
}
axios.get(`${url}/findAll`).then((res) => {
    tableData.value = res.data;
})

</script>
