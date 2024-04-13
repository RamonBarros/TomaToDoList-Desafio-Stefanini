<template>
  <div class="row">
    <div class="col-task col">
      <h3 class="col-task-title">A Fazer</h3>
      <draggable class="list-task" :list="toDo" group="taks" @change="log" itemKey="title">
        <template #item="{ element, index }">
          <div class="row list-task-item">
            <div class="list-task-item-text">
              {{ element.title }}
            </div>
            <div class="list-task-icon-container row">
              <img src="@/assets/eye-icon.svg" class="list-task-item-icon" alt="View-Icon" @click="openModal(element)">
              <span class="list-task-item-icon" @click="deleteTask(element)">X</span>
            </div>
          </div>
        </template>
      </draggable>
      <button class="add-task-button" @click="add(1)">+ Adicionar Nova Tarefa</button>
    </div>

    <div class="col-task col">
      <h3 class="col-task-title">Em Andamento</h3>
      <draggable class="list-task" :list="doing" group="taks" @change="log" itemKey="title">
        <template #item="{ element, index }">
          <div class="row list-task-item">
            <div class="list-task-item-text ">
              {{ element.title }}
            </div>
            <div class="list-task-icon-container row">
              <img src="@/assets/eye-icon.svg" class="list-task-item-icon" alt="View-Icon" @click="openModal(element)">
              <span class="list-task-item-icon" @click="deleteTask(element)">X</span>
            </div>
          </div>
        </template>
      </draggable>
      <button class="add-task-button" @click="add(2)">+ Adicionar Nova Tarefa</button>
    </div>

    <div class="col-task col">
      <h3 class="col-task-title">Concluido</h3>
      <draggable class="list-task" :list="done" group="taks" @change="log" itemKey="title">
        <template #item="{ element, index }">
          <div class="row list-task-item">
            <div class="list-task-item-text">
              {{ element.title }}
            </div>
            <div class="list-task-icon-container row">
              <img src="@/assets/eye-icon.svg" class="list-task-item-icon" alt="View-Icon" @click="openModal(element)">
              <span class="list-task-item-icon" @click="deleteTask(element)">X</span>
            </div>
          </div>
        </template>
      </draggable>
      <button class="add-task-button" @click="add(3)">+ Adicionar Nova Tarefa</button>
    </div>

    <rawDisplayer class="col" :value="toDo" title="List 1" />

    <rawDisplayer class="col" :value="doing" title="List 2" />

    <rawDisplayer class="col" :value="done" title="List 3" />

    <modal :show="showModal" :task="task" :create="toCreate" @close="showModal = false" @save-changes="saveChanges">
    </modal>
  </div>
</template>
<script>
import draggable from "vuedraggable";
import modal from "@/components/Modal.vue"
import axios from "axios";

export default {
  name: "TaskList",
  components: {
    draggable,
    modal
  },
  data() {
    return {
      showModal: false,
      toCreate: false,
      task: {},
      toDo: [],
      doing: [],
      done: [],
    };
  },
  methods: {
    add(index) {
      this.toCreate = true;
      switch (index) {
        case 1:
          this.task = { title: "Adicionar Título da Tarefa", description: "Adicionar Descrição da Tarefa", status: "toDo" }
          this.showModal = true;
          break;
        case 2:
          this.task = { title: "Adicionar Título da Tarefa ", description: "Adicionar Descrição da Tarefa", status: "doing" }
          this.showModal = true;
          break;
        case 3:
          this.task = { title: "Adicionar Título da Tarefa ", description: "Adicionar Descrição da Tarefa", status: "done" }
          this.showModal = true;
          break

      }
    },
    replace: function () {
      this.list = [{ name: "Edgard" }];
    },
    clone: function (el) {
      return {
        name: el.name + " cloned"
      };
    },
    async log(evt) {
      //Atalizando os status das tarefas sempre que é detectado o evento de mudança pelo Vue-draggable
      if (evt.added != null) {
        for (let i = 0; i < this.toDo.length; i++) {
          console.log(this.toDo[i].title, this.toDo[i].status)
          this.toDo[i].status = 'toDo'
        }
        for (let j = 0; j < this.doing.length; j++) {
          console.log(this.doing[j].title, this.doing[j].status)
          this.doing[j].status = 'doing'
        }
        for (let k = 0; k < this.done.length; k++) {
          console.log(this.done[k].title, this.done[k].status)
          this.done[k].status = 'done'
        }

        let updatedTaskList = this.toDo.concat(this.doing, this.done);
        this.updateTaskList(updatedTaskList)  //Atualiza na base de dados a lista

      }

    },
    async updateTaskList(updatedTaskList) {
      const url = 'http://localhost:8080/tarefas/update'
      try {
        axios.put(url, updatedTaskList)
      } catch (error) {
        console.error(error)
      }
    },
    openModal(element) {
      this.task = {
        title: element.title,
        description: element.description,
        id: element.id,
        status: element.status
      }
      this.showModal = !this.showModal;
    },
    saveChanges(updatedTask) {

      this.getData()
      alert("Tarefa Salva!!!")
    },
    deleteTask(task) {
      const url = 'http://localhost:8080/tarefas/' + task.id

      try {
        console.log(url)
        axios.delete(url)
        alert("Tarefa Excluída!!!")
        this.getData()
      } catch (error) {
        console.error(error.errorMessage)
      }

    },

    async getData() {
      const url = 'http://localhost:8080/tarefas'
      try {
        this.toDo = []
        this.doing = []
        this.done = []
        const response = await axios.get(url);
        for (let i = 0; i < response.data.data.length; i++) {
          const task = response.data.data[i];
          if (task.status === "toDo") {
            this.toDo.push(task);
          } else if (task.status === "doing") {
            this.doing.push(task);
          } else if (task.status === "done") {
            this.done.push(task);
          }
        }

      } catch (error) {
        console.log(error)
      }
    }
  },
  mounted() {
    this.getData()
  }


};
</script>
<style scoped>
.row {
  justify-content: center;
}

.list-task-item {
  margin: 0.5rem 1rem 0rem 1rem;
  flex-wrap: nowrap;
  /* width: 25rem; */
  width: 20vw;
  background-color: var(--cor-primaria);
  border-radius: 15px;
  padding: 1rem 1rem 1rem 1rem;
  text-align: start;
  padding-left: 1rem;
  cursor: grab;
  color: #fff;
}

.list-task-icon-container {
  margin-left: auto;
}

.list-task-item-icon {
  width: 2rem;
  height: 1rem;
  font-size: 1rem;
  cursor: pointer;
}

.list-task-item-text {
  width: 15vw;
  text-overflow: ellipsis;
}

.col-task {
  margin: 0rem 0rem 0rem 1rem;
  align-items: center;
}

.col-task-title {
  color: #fff;
}

.add-task-button {
  width: 15vw;
  padding: 0.3rem 0rem 0.3rem 0rem;
  border-radius: 15px;
  border: none;
  margin-top: 0.5rem;
  background-color: var(--cor-primaria);
  color: #fff;
  cursor: pointer;
}
</style>