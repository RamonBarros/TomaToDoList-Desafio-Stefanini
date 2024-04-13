<template>
    <router-view/>
</template>

<style>

:root {
  --cor-primaria: #BA4949; 
  --cor-secundaria: #C15B5B; /* Definindo uma variável para a cor secundária */
}

body{
  background-color: var(--cor-primaria);
  width: 100%;
  height: 100%;
  overflow: hidden;
  margin: 0;
  padding: 0;
}

*{
  box-sizing: border-box;
}

.col{
  display: flex;
  flex-direction: column;
}

.row{
  display: flex;
  flex-direction: row;
}

#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #fff;
  padding: 0;
  margin: 0;
  display: flex;
  justify-content: flex-start;
  align-items: center;
  flex-direction: column;
  background-color: var(--cor-primaria);
  height: 100vh;
}

.main{
  display: flex;
  align-items: center;
  flex-direction: column;
  height: 100%;
}

.content{
  background-color: var(--cor-secundaria);
  justify-content: center;
  align-items: center;
  width: 70vw;
  height: 50vh;
  margin-top: 5rem;
  border-radius: 15px;
}
</style>
