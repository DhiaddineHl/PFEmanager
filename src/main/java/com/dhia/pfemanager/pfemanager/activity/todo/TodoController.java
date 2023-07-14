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
    public void addTodoToJournal(
            @RequestBody TodoCreationRequest request
    ){
        todoService.addTodoToJournal(request);
    }

    @DeleteMapping("/delete/{todoId}")
    public void deleteTodo(
            @PathVariable("todoId") Integer todoId
    ){
        todoService.deleteTodoById(todoId);
    }

    @GetMapping("/byIntern/{internId}")
    public ResponseEntity<List<TodoDTO>> getTodosByIntern(
            @PathVariable("internId") Integer internId
    ){
        return ResponseEntity.ok(todoService.getTodosByIntern(internId));
    }

}
