package com.stefanini.apitodolist.tasks.DTO;

import jakarta.validation.constraints.NotNull;

// import javax.validation.constraints.NotNull;

// import javax.validation.constraints.NotNull;


public class TaskDTO {


    private Long id;

    @NotNull(message = "Por Favor Informe Um titulo da Tarefa")
    private String title;

    @NotNull(message = "Por Favor Informe Uma Descrição da Tarefa")
    private String description;

    @NotNull(message = "Por Favor a Situação da Tarefa")
    private String status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
