package com.dhia.pfemanager.pfemanager.activity.task;

import com.dhia.pfemanager.pfemanager.comment.CommentDTOMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.function.Function;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class TaskDTOMapper implements Function<Task, TaskDTO> {

    private final CommentDTOMapper commentDTOMapper;

    @Override
    public TaskDTO apply(Task task) {
        return new TaskDTO(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getDeadline(),
                task.getAssigner().getName(),
                task.getCommentList()
                        .stream()
                        .map(commentDTOMapper)
                        .collect(Collectors.toList())
        );
    }
}
