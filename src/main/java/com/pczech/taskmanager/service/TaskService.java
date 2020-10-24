package com.pczech.taskmanager.service;

import com.pczech.taskmanager.domain.Goal;
import com.pczech.taskmanager.domain.SubTask;
import com.pczech.taskmanager.domain.Task;

import java.util.List;

public interface TaskService {
    Task save(Task task);

    List<Task> findAll();

    Task findById(long id);

    Task modify(long id, Task task);

    void delete(long id);

    Task addGoal(long taskId, Goal goal);

    Task addTask(long taskId, SubTask subTask);
}
