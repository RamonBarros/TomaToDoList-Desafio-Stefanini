<template>
  <div class="main">
    <div id="nav">
      <span class="nav-timer-link" :class="{ 'selected': selected === 'pomodoro' }" @click="pomodoro">Pomodoro</span>
      <span class="nav-timer-link" :class="{ 'selected': selected === 'shortBreak' }" @click="shortBreak">Pausa
        Curta</span>
      <span class="nav-timer-link" :class="{ 'selected': selected === 'longBreak' }" @click="longBreak">Pausa Longa</span>
    </div>
    <h1>{{ title }}</h1>
    <p id="timer">{{ time.minutes }}:{{ time.seconds < 10 ? '0' : '' }}{{ time.seconds }}</p>
        <div class="row">
          <button class="control-button" @click="startTimer" :disabled="interval !== null">Iniciar</button>
          <button class="control-button" @click="stopTimer">Parar</button>
          <button class="control-button" @click="resetTimer">Reiniciar</button>
        </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      time: {
        minutes: 30,
        seconds: 0,
      },
      interval: null,
      audio: null,
      selected: "pomodoro",
      title: "Hora de Focar Na Tarefa!!"
    };
  },
  methods: {
    startTimer() {
      this.interval = setInterval(() => {
        if (this.time.seconds === 0) {
          this.time.seconds = 59;
          this.time.minutes--;
        } else {
          this.time.seconds--;
        }
        if (this.time.minutes === 0 && this.time.seconds === 0) {
          clearInterval(this.interval);
          this.interval = null;
          this.playAudio();
          //Toca o Aviso que o Temporizador Zerou
        }
      }, 1000);
    },
    stopTimer() {
      clearInterval(this.interval);
      this.interval = null;
    },
    resetTimer() {


      switch (this.selected) {
        case "pomodoro":
          this.time = {
            minutes: 30,
            seconds: 0
          }
          
          break;
        case "shortBreak":
          this.time = {
            minutes: 5,
            seconds: 0
          }
          
          break;
        case "longBreak":
          this.time = {
            minutes: 10,
            seconds: 0
          }
          
          break;

      }
    },
    playAudio() {
      this.audio = new Audio(require('@/assets/audio/ring-bell.mp3'));
      this.audio.play();

      this.audioTimeout = setTimeout(() => {
        this.audio.pause();
      }, 10000);
    },
    pomodoro() {
      this.selected = "pomodoro"
      this.time = {
        minutes: 30,
        seconds: 0,
      }
      this.title = "Hora de Focar Na Tarefa!!"
    },
    shortBreak() {
      this.selected = "shortBreak"
      this.time = {
        minutes: 5,
        seconds: 0,
      }
      this.title = "Hora do Descanso Curto!!"
    },
    longBreak() {
      this.selected = "longBreak"
      this.time = {
        minutes: 10,
        seconds: 0,
      }
      this.title = "Hora do Descanso Longo!!"
    }
  },
};
</script>

<style scoped>
.control-button {
  color: #fff;
  background-color: var(--cor-primaria);
  border: none;
  font-size: 2rem;
  border-radius: 15px;
  padding: 0.1rem 0.6rem 0.1rem 0.6rem;
  margin: 0.2rem 0.2rem 0.2rem 0.2rem;
  cursor: pointer;
}

.nav-timer-link {
  cursor: pointer;
  padding: 1rem 1rem 0.5rem 1rem;
  border-radius: 0px 0px 10px 10px;
  font-size: 1.5rem;
}

.nav-timer-link:hover {
  background-color: var(--cor-primaria);
}

.nav-timer-link.selected {
  background-color: var(--cor-primaria);
}

#timer {
  font-size: 6rem;
  margin: 4rem;
}
</style>
