package com.dhia.pfemanager.pfemanager.activity.todo;

import com.dhia.pfemanager.pfemanager.comment.CommentDTOMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.function.Function;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class TodoDTOMapper implements Function<Todo,TodoDTO> {

    private final CommentDTOMapper commentDTOMapper;

    @Override
    public TodoDTO apply(Todo todo) {
        return new TodoDTO(
                todo.getId(),
                todo.getTitle(),
                todo.getDescription(),
                todo.getDeadline(),
                todo.getCommentList()
                        .stream()
                        .map(commentDTOMapper)
                        .collect(Collectors.toList())
        );
    }
}
