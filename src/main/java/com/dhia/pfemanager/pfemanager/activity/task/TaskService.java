package com.dhia.pfemanager.pfemanager.activity.task;


import com.dhia.pfemanager.pfemanager.user.intern.Intern;
import com.dhia.pfemanager.pfemanager.user.intern.InternRepository;
import com.dhia.pfemanager.pfemanager.user.supervisor.Supervisor;
import com.dhia.pfemanager.pfemanager.user.supervisor.SupervisorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final InternRepository internRepository;
    private final SupervisorRepository supervisorRepository;
    private final TaskRepository taskRepository;
    private final TaskDTOMapper taskDTOMapper;

    public void assignTaskToIntern(Integer internId, TaskAssigningRequest request) {
        Intern intern = internRepository.findInternById(internId);
        Supervisor supervisor = supervisorRepository.findSupervisorById(request.assignerId);
        var task = Task.builder()
                .title(request.title)
                .description(request.description)
                .duration(request.duration)
                .deadline(request.deadline)
                .assigner(supervisor)
                .intern(intern)
                .build();
        taskRepository.save(task);
        intern.getInternshipJournal().add(task);
    }

    public List<TaskDTO> getTasksByIntern(Integer internId) {
        return taskRepository.findTasksByInternId(internId)
                .stream()
                .map(taskDTOMapper)
                .collect(Collectors.toList());
    }
}
