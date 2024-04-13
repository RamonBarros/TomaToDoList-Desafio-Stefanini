# Documentação da API ToDoList

## Introdução

Bem-vindo à documentação da API ToDoList. Esta API permite o gerenciamento de tarefas em uma lista de tarefas (to-do list).

## Recursos Disponíveis

A API oferece os seguintes recursos:

1. **Criar uma nova tarefa**
2. **Atualizar uma ou várias tarefas**
3. **Obter todas as tarefas**
4. **Obter uma tarefa específica por ID**
5. **Excluir uma tarefa por ID**

## Endpoints

### Criar uma nova tarefa

- **URL:** `/tarefas`
- **Método HTTP:** POST
- **Descrição:** Cria uma nova tarefa na lista de tarefas.
- **Corpo da solicitação:** Deve ser um objeto JSON contendo os campos `title`, `description` e `status`.
- **Exemplo de corpo da solicitação:**
```json
{
    "title": "Título da Tarefa",
    "description": "Descrição da Tarefa",
    "status": "toDo"
}
```

### Atualizar uma ou várias tarefas

*   **URL:** `/tarefas/update` (Para atualizar várias tarefas)
*   **Método HTTP:** PUT
*   **Descrição:** Atualiza uma ou várias tarefas existentes na lista de tarefas.
*   **Corpo da solicitação:** Deve ser um array JSON contendo objetos com os campos `id`, `title`, `description` e `status`.
*   **Exemplo de corpo da solicitação:**

jsonCopy code
```json
[
{
"id": 1,
"title": "Novo Título",
"description": "Nova Descrição",
 "status": "doing"
},
{
"id": 2,
"title": "Outro Título",
"description": "Outra Descrição",
"status": "done"
}
```

### Atualizar uma tarefa específica por ID

*   **URL:** `/tarefas/update/{taskId}`
*   **Método HTTP:** PUT
*   **Descrição:** Atualiza uma tarefa específica na lista de tarefas pelo seu ID.
*   **Parâmetros de URL:** `{taskId}` - ID da tarefa a ser atualizada.
*   **Corpo da solicitação:** Deve ser um objeto JSON contendo os campos  `id`, `title`, `description` e `status`.

### Obter todas as tarefas

*   **URL:** `/tarefas`
*   **Método HTTP:** GET
*   **Descrição:** Retorna todas as tarefas da lista de tarefas.

### Obter uma tarefa específica por ID

*   **URL:** `/tarefas/{taskId}`
*   **Método HTTP:** GET
*   **Descrição:** Retorna uma tarefa específica da lista de tarefas pelo seu ID.
*   **Parâmetros de URL:** `{taskId}` - ID da tarefa a ser obtida.

### Excluir uma tarefa por ID

*   **URL:** `/tarefas/{taskId}`
*   **Método HTTP:** DELETE
*   **Descrição:** Exclui uma tarefa específica da lista de tarefas pelo seu ID.
*   **Parâmetros de URL:** `{taskId}` - ID da tarefa a ser excluída.

Status de Resposta
------------------

*   **200 OK:** A solicitação foi bem-sucedida.
*   **400 Bad Request:** O corpo da solicitação é inválido ou está faltando informações obrigatórias.
*   **404 Not Found:** A tarefa solicitada não foi encontrada.
------------------------------------------------------------------------------------------------------

Instruções de Instalação
========================

Este guia fornece instruções passo a passo para configurar e executar o projeto em sua máquina local.

Pré-requisitos
--------------

Antes de iniciar, verifique se você possui as seguintes ferramentas instaladas em sua máquina:

*   Node.js e npm (para o frontend Vue.js)
*   Java Development Kit (JDK) (para o backend Spring Boot) - Testado e Desenvolvido no JDK Versão 17
*   Maven (para gerenciamento de dependências Java)
*   Docker Desktop (para o PostgreSQL)

Configuração do Backend
-----------------------

Siga as etapas abaixo para configurar e executar o backend (Spring Boot):

1.  Abra o projeto backend (Spring Boot) em sua IDE de escolha.
    
2.  Instale as dependências do Maven:
** No mesmo diretório do arquivo "pom.xml"
** Execute
`mvn clean package`ou `mvn clean install`
    
3.  Execute o projeto Spring Boot.

Configuração do Banco de Dados
------------------------------

Siga as etapas abaixo para configurar e executar o banco de dados PostgreSQL com Docker:

1.  Abra um terminal e navegue até database-docker.
    
2.  Inicie o contêiner Docker PostgreSQL:
    
    `docker-compose up -d`
    
3.  Verifique se o contêiner PostgreSQL está em execução:
     
    `docker ps`
    
Configuração do Frontend
------------------------

Siga as etapas abaixo para configurar e executar o frontend (Vue.js):

1.  Abra um novo terminal e navegue até o diretório `frontend` do projeto.
    
2.  Instale as dependências do FrontEnd:

    `npm install`
    
4.  Inicie o servidor de desenvolvimento Vue.js:
    
    `npm run serve`

    Acesso à Aplicação
-----------------------

Após concluir as etapas acima, você pode acessar a aplicação nos seguintes URLs:

*   **Frontend Vue.js:** [http://localhost:8080](http://localhost:8080)
*   **Backend Spring Boot:** [http://localhost:8081](http://localhost:8081)
*   **Banco de Dados PostgreSQL:** Porta padrão `5432`

    Se Tudo Der Certo o Projeto terá esta cara:
----------------------
![Imagem do Exemplo](https://lh3.googleusercontent.com/drive-viewer/AKGpihYeu7KSmP1QvKfOXiPzaL6_jaZYWvULtsRgXmQf4y54B6g6U4j_Qbqy7gDCrLdHL4MO_ebv4pQYHp-fzedJQ_-5l94VJVT4Bl0=s1600-v0)
![Imagem do Exemplo](https://lh3.googleusercontent.com/drive-viewer/AKGpiha7_2XROFKXRF5nzHH4MtLohSPmIqw3QYfbsVPqq8QaEjSLJq8wpIg-MC84RrgPMT_QCU2UsKFXcC24XPEAUZftNh62zNJrMsc=s1600-v0)
![Imagem do Exemplo](https://lh3.googleusercontent.com/drive-viewer/AKGpihZogfDaxxG0YKq3GZX3fzIF5NPfsosJtijhWEckuz2BH0fqzSZBkL54-r6gUmnIuitb7VxO__0jgj8hvdlrDP3EOj8Fes5h00w=s1600-rw-v1)
![Imagem do Exemplo](https://lh3.googleusercontent.com/drive-viewer/AKGpihZduXKU56T5GZ34zR5sOGBJYZFWXHI30HFsWSKJt8TB47pBvLzMhJYjNNIdeMcyYjTgnPyzDRso-AMaUC3Z8nu3CBEdsgdT7Q=s1600-rw-v1)


