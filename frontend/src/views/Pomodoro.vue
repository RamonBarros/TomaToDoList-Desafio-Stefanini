<template>
    <div class="main">
        <Header/>
        <div class="content col">
            <div id="nav">
                
            </div>
            <pomodoro-timer/>
        </div>
    </div>
</template>
<script>
import Header from '@/components/Header.vue'
import PomodoroTimer from '@/components/PomodoroTimer.vue'
export default {
    components: {
        Header,
        PomodoroTimer
    },
    data() {
        return {

        }
    },

}
</script>
<style></style>