package com.dhia.pfemanager.pfemanager.activity.task;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/tasks")
public class TaskController {

    private final TaskService taskService;

    @PostMapping("/assign/to/{internId}")
    public void assignTaskToIntern(
        @PathVariable("internId") Integer internId,
        @RequestBody TaskAssigningRequest request
    ){
        taskService.assignTaskToIntern(internId, request);
    }

    @GetMapping("/byIntern/{internId}")
    public ResponseEntity<List<TaskDTO>> getTasksByIntern(
            @PathVariable("internId") Integer internId
    ){
        return ResponseEntity.ok(taskService.getTasksByIntern(internId));
    }

}
