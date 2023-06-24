package com.dhia.pfemanager.pfemanager.activity.todo;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/todos")
public class TodoController {

    @PostMapping("/create")
    public void createTopic(TodoCreationRequest request){

    }

    @GetMapping("/byIntern/{internId}")
    public List<TodoDTO> getTodosByIntern(
            @PathVariable("internId") Integer internId
    ){
        return null;
    }



}
