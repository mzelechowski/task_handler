package com.malarska.taskshandler.repositories;


import com.malarska.taskshandler.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TasksRepository extends JpaRepository<Task, Integer> {
}
