package com.stefanini.apitodolist.tasks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.stefanini.apitodolist.tasks.DTO.TaskDTO;
import com.stefanini.apitodolist.tasks.model.ResponseAPI;
import com.stefanini.apitodolist.tasks.service.TaskFacade;

import java.util.List;
import java.util.Optional;



@RestController
@RequestMapping(value = "/tarefas", produces = MediaType.APPLICATION_JSON_VALUE)
public class TaskAPI {

    @Autowired
    private TaskFacade taskFacade;

    @PostMapping
    @ResponseBody
    public ResponseEntity<ResponseAPI<TaskDTO>> create(@RequestBody TaskDTO taskDTO) {
        ResponseAPI<TaskDTO> response = new ResponseAPI<>();
        if(taskDTO.getTitle()==null){
            response.setError(true);
            response.setErrorMessage("Informe o Titulo");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
        if(taskDTO.getDescription()==null){
            response.setError(true);
            response.setErrorMessage("Informe a Descrição");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
        if(taskDTO.getStatus()==null){
            response.setError(true);
            response.setErrorMessage("Informe o Status");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
        response.setData(taskFacade.create(taskDTO));
        return ResponseEntity.ok().body(response);
    }

    @PutMapping("/update")
    @ResponseBody
    public ResponseEntity<ResponseAPI<List<TaskDTO>>> update(@RequestBody List<TaskDTO> taskDTOs) {
        ResponseAPI<List<TaskDTO>> response = new ResponseAPI<>();
        response.setData(taskFacade.update(taskDTOs));
        return ResponseEntity.ok().body(response);
    }

    @PutMapping("/update/{taskId}")
    @ResponseBody
    public ResponseEntity<ResponseAPI<TaskDTO>> updateById(@PathVariable("taskId") Long taskId,@RequestBody TaskDTO taskDTO) {
        ResponseAPI<TaskDTO> response = new ResponseAPI<>();
        response.setData(taskFacade.updateById(taskDTO, taskId));
        return ResponseEntity.ok().body(response);
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<ResponseAPI<List<TaskDTO>>> getAll() {
        ResponseAPI<List<TaskDTO>> response = new ResponseAPI<>();
        response.setData(taskFacade.getAll());
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/{taskId}")
    @ResponseBody
    public ResponseEntity<ResponseAPI<TaskDTO>> getById(@PathVariable("taskId") Long taskId) {
        Optional<TaskDTO> taskOptional = taskFacade.getById(taskId);
        ResponseAPI<TaskDTO> response = new ResponseAPI<>();
        if(taskOptional.isPresent()){
            response.setData(taskFacade.create(taskOptional.get()));
            return ResponseEntity.ok().body(response); 
        }else{
            response.setError(true);
            response.setErrorMessage("Tarefa Não Encontrado");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @DeleteMapping("/{taskId}")
    @ResponseBody
    public String delete(@PathVariable("taskId") Long taskId) {
        return taskFacade.delete(taskId);
    }
}
