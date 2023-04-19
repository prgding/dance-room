<template>
    <el-row class="mb-4">
        <el-button size="default"
                   type="success"
                   @click="handleDetail()"
        >新增</el-button>
    </el-row>
</template>

<script lang="ts" setup>
const handleDetail = () => {
    alert("new")
}
</script>

<style>
.mb-4 {
    padding-top: 15px;
    padding-left: 10px;
}
</style>
