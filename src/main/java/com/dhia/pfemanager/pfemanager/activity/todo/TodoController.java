package com.dhia.pfemanager.pfemanager.activity.todo;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/todos")
public class TodoController {

    private final TodoService todoService;

    @PostMapping("/add")
    public void createTopic(
            @RequestBody TodoCreationRequest request
    ){
        todoService.addTodoToJournal(request);
    }

    @GetMapping("/byIntern/{internId}")
    public ResponseEntity<List<TodoDTO>> getTodosByIntern(
            @PathVariable("internId") Integer internId
    ){
        return ResponseEntity.ok(todoService.getTodosByIntern(internId));
    }

}
