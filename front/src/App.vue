<template>
    <h1>aa</h1>
    <router-view></router-view>
</template>

<script lang="ts">


import {Options, Vue} from 'vue-class-component';
import {inject} from "vue";


@Options({
    components: {},
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
</style>
