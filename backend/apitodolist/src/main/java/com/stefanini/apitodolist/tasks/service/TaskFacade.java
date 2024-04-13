package com.stefanini.apitodolist.tasks.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stefanini.apitodolist.tasks.DTO.TaskDTO;
import com.stefanini.apitodolist.tasks.model.Task;
import com.stefanini.apitodolist.tasks.repository.TaskRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TaskFacade {
    @Autowired
    private TaskRepository repository;

    public TaskDTO create(TaskDTO taskDTO) {
        Task task = new Task();
        task.setDescription(taskDTO.getDescription());
        task.setTitle(taskDTO.getTitle());
        task.setStatus(taskDTO.getStatus());
        repository.save(task);
        taskDTO.setId(task.getId());
        return taskDTO;
    }

    public TaskDTO updateById(TaskDTO taskDTO, Long taskId) {
        Task taskDatabase = repository.getReferenceById(taskId);
        taskDatabase.setTitle(taskDTO.getTitle());
        taskDatabase.setDescription(taskDTO.getDescription());
        taskDatabase.setStatus(taskDTO.getStatus());
        repository.save(taskDatabase);
        return taskDTO;
    }

    public List<TaskDTO> update(List<TaskDTO> taskDTOs) {
        List<TaskDTO> updatedTasks = new ArrayList<>();
        for (TaskDTO taskDTO : taskDTOs) {
            Long taskId = taskDTO.getId();
            Task taskDatabase = repository.getReferenceById(taskId);
            if (taskDatabase != null) {
                taskDatabase.setTitle(taskDTO.getTitle());
                taskDatabase.setDescription(taskDTO.getDescription());
                taskDatabase.setStatus(taskDTO.getStatus());
                repository.save(taskDatabase);
                updatedTasks.add(taskDTO);
            }
        }
        return updatedTasks;
    }
    

    private TaskDTO converter (Task task) {
        TaskDTO result = new TaskDTO();
        result.setId(task.getId());
        result.setTitle(task.getTitle());
        result.setDescription(task.getDescription());
        result.setStatus(task.getStatus());
        return result;
    }

    public List<TaskDTO> getAll () {
        return repository
                .findAll()
                .stream()
                .map(this::converter).collect(Collectors.toList());
    }

    public Optional<TaskDTO> getById(Long taskId) {
        Optional<Task> optionalTask = repository.findById(taskId);
        return optionalTask.map(this::converter);
    }

    public String delete (Long taskId) {
        repository.deleteById(taskId);
        return "DELETED";
    }

}
