<template>
    <el-row class="mb-4">
        <el-button size="default"
                   type="success"
                   @click="handleDetail()"
        >新增</el-button>
    </el-row>
</template>

<script lang="ts" setup>
import { useRouter } from 'vue-router'
const router = useRouter()
const handleDetail = () => {
    // 路由跳转到 /add
    router.push('/add')
}
</script>

<style>
.mb-4 {
    padding-top: 30px;
    padding-left: 20px;
}
</style>
