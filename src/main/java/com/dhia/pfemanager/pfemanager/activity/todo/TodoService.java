package com.dhia.pfemanager.pfemanager.activity.todo;


import com.dhia.pfemanager.pfemanager.user.intern.Intern;
import com.dhia.pfemanager.pfemanager.user.intern.InternRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final InternRepository internRepository;
    private final TodoRepository todoRepository;
    private final TodoDTOMapper todoDTOMapper;


    public void addTodoToJournal(TodoCreationRequest request) {
        Intern intern = internRepository.findInternById(request.getInternId());
        var todo = Todo.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .duration(request.getDuration())
                .deadline(request.getDeadline())
                .intern(intern)
                .build();
        todoRepository.save(todo);

        intern.getInternshipJournal().add(todo);
    }

    public List<TodoDTO> getTodosByIntern(Integer internId) {
        return todoRepository.findTodosByInternId(internId)
                .stream()
                .map(todoDTOMapper)
                .collect(Collectors.toList());
    }
}
