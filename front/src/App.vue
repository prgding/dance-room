<template>
    <h1>Dance Classroom Management System</h1>
    <div class="mycompo">
        <Table/>
        <Button/>
    </div>

</template>

<script lang="ts">


import {Options, Vue} from 'vue-class-component';
import Table from "@/components/Table.vue";
import Button from "@/components/Button.vue";

@Options({
    components: {
        Button,
        Table,
    },
})
export default class App extends Vue {
}

</script>

<style>
#app {
    font-family: Avenir, Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    text-align: center;
    color: #2c3e50;
    margin-top: 60px;
}

.mycompo {
    padding: 10px 50px
}
</style>
