package com.dhia.pfemanager.pfemanager.comment;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/comments")
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/add/toTodo/{todoId}")
    public void addCommentToTodo(
        @RequestBody CommentAddingRequest request,
        @PathVariable("todoId") Integer todoId
    ){
        commentService.addCommentToTodo(todoId, request);
    }

}
