<template>
  <div class="main">
    <Header/>
    <div class="content">
      <task-list/>
    </div>
  </div>
</template>

<script>
import Header from '@/components/Header.vue'
import TaskList from '@/components/TaskList.vue'

export default {
  name: 'Home',
  components: {
    Header,
    TaskList
  },
  methods:{
    
  }
}
</script>

<style>




</style>
