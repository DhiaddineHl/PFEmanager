package com.dhia.pfemanager.pfemanager.comment;


import com.dhia.pfemanager.pfemanager.activity.todo.Todo;
import com.dhia.pfemanager.pfemanager.activity.todo.TodoRepository;
import com.dhia.pfemanager.pfemanager.user.supervisor.Supervisor;
import com.dhia.pfemanager.pfemanager.user.supervisor.SupervisorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final SupervisorRepository supervisorRepository;
    private final TodoRepository todoRepository;
    private final CommentRepository commentRepository;
    public void addCommentToTodo(Integer todoId, CommentAddingRequest request) {
        Supervisor supervisor = supervisorRepository.findSupervisorById(request.commenterId);
        Todo todo = todoRepository.findTodoById(todoId);
        var comment = Comment.builder()
                .description(request.description)
                .commenter(supervisor)
                .commentedTodo(todo)
                .build();
        commentRepository.save(comment);
        todo.getCommentList().add(comment);


    }
}
