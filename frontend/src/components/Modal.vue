<template>
  <div v-if="show" class="modal">

    <div class="modal-content">
      <div class="modal-header">
        <input class="modal-title-input" placeholder="Titulo Da Tarefa" v-model="task.title">
        <span class="close" @click="close()">&times;</span>
      </div>
      <div class="modal-body">
        <span id="modal-description-title">Descrição</span>
        <textarea class="text-box" v-model="task.description" placeholder="Descrição da Tarefa"></textarea>
        <button id="save-button" @click="saveChanges">Salvar</button>
      </div>
    </div>

  </div>
</template>

<script>
import axios from 'axios';
export default {
  props: {
    show: {
      type: Boolean,
      required: true
    },
    task: {
      type: Object,
      required: true
    },
    create: {
      Boolean,
      required: true
    }
  },
  methods: {
    close() {
      console.log("Closed")
      this.$emit('close');
    },
    async saveChanges() {
      console.log(this.task, this.create)
      if (this.create) {
        try {
          const url = `http://localhost:8080/tarefas`
          await axios.post(url, this.task)
          this.$emit('save-changes', this.task);
        } catch (error) {
          console.error(error.errorMessage)
        }

      }else{
        try {
          const url = `http://localhost:8080/tarefas/update/` + this.task.id
          await axios.put(url, this.task)
          this.$emit('save-changes', this.task);
        } catch (error) {
          console.error(error.errorMessage)
        }
      }
    },
    teste() {
      console.log("Teste")
    }
  }
}
</script>

<style scoped>
.modal {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  display: flex;
  align-items: center;
  justify-content: center;

}

.modal-content {
  background-color: var(--cor-primaria);
  padding: 20px;
  border-radius: 15px;
  height: 25rem;
  width: 50rem;
  box-shadow: 1px 1px 47px -3px rgba(0, 0, 0, 0.75);
  border: 1px solid;
}

.modal-header {
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.close {
  cursor: pointer;
  font-size: 4rem;
}

.modal-body {
  margin-top: 1rem;
}

.modal-title-input {
  border: 1px solid;
  border-radius: 15px;
  color: #fff;
  background-color: var(--cor-secundaria);
  font-size: 1.5rem;
  padding: 0.5rem;
}

#modal-description-title {
  font-size: 1rem;
}

.text-box {
  background-color: var(--cor-secundaria);
  width: 100%;
  height: 10rem;
  border-radius: 15px;
  border: 1px solid;
  padding: 1rem;
  margin-top: 1rem;
  color: #fff;
}

#save-button {
  border-radius: 15px;
  border: none;
  background-color: #148C3C;
  color: #fff;
  width: 5rem;
  height: 2rem;
  margin-top: 1rem;
  cursor: pointer;
}
</style>