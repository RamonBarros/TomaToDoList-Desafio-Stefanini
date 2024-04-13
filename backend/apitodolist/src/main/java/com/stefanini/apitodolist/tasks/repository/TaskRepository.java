package com.stefanini.apitodolist.tasks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stefanini.apitodolist.tasks.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
}
