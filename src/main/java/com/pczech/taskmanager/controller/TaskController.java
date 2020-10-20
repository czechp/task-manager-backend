package com.pczech.taskmanager.controller;

import com.pczech.taskmanager.domain.Task;
import com.pczech.taskmanager.domain.TaskStatus;
import com.pczech.taskmanager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@RestController()
@RequestMapping("/api/tasks")
@CrossOrigin("*")
public class TaskController {
    private TaskService taskService;

    @Autowired()
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Task save(@RequestBody @Valid Task task){
        return taskService.save(task);
    }

    @GetMapping("/status")
    public ResponseEntity<Object> getStatus() {
        List<Map<String, String>> body = new ArrayList<>();
        Arrays.stream(TaskStatus.values())
                .forEach(x -> {
                    HashMap<String, String> status = new HashMap<>();
                    status.put("status", x.toString());
                    body.add(status);
                });
        return ResponseEntity.ok(body);
    }
}
