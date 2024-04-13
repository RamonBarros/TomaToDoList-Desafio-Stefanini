<template>
    <div class="nav col">
        <div class="image-container">
            <img id="login-icon" alt="Vue logo" src="@/assets/Logo.svg">
        </div>
        <div class="row ">
            <div class="links-container row">
                <router-link class="link row" to="/">
                    <img src="@/assets/task-icon.svg" alt="Icon">
                    <span class="router-link-text">Tarefas</span>
                </router-link>
                <span class="separator">|</span>
                <router-link class="link row" to="/pomodoro">
                    <img src="@/assets/tomato-icon.svg" alt="Tomato">
                    <span class="router-link-text">Pomodoro</span>
                </router-link>
            </div>
        </div>
    </div>
</template>
<script>
export default {

}
</script>
<style scoped>

.nav {
    background-color: #C15B5B;
    width: 100vw;
    height: 15rem;
    margin: 0;
    padding: 0;
}

.image-container {
    margin: 1rem 0rem 1rem 0rem;
}

.image-container img {
    width: 30rem;
    height: 10rem;
}

.links-container {
    margin: 0rem 0rem 0rem 10rem;
    align-items: center;
    width: fit-content;
}

.link {
    text-decoration: none;
    color: #fff;
    font-size: 2rem;
    align-items: center;
    padding: 1.0rem 1rem 1rem 0rem;
    height: 2.8rem;
    border-radius: 15px 15px 0px 0px;
}

.link img{
    padding: 0rem 0rem 0rem 1rem;
}

.router-link-active{
    background-color: #BA4949;
}

.link:hover{
    background-color: #BA4949;
}

.separator {
    color: #fff;
    font-size: 2rem;
    margin: 0 0.5rem;
}

.router-link-text {
    margin-left: 0.5rem;
}

#logout-button{
    margin: 0rem 2rem 0rem auto;
    border-radius: 15px 15px 0px 0px;
    width:10rem;
    font-size: 2rem;
    color: #fff;
    background-color: #BA4949;
    border: none;
}

.logout-button:hover{
    background-color: #BA4949;
}


</style>