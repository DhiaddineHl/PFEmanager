package com.dhia.pfemanager.pfemanager.user.supervisor;


import com.dhia.pfemanager.pfemanager.user.intern.InternDTO;
import org.springframework.stereotype.Service;

import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class SupervisorDTOMapper implements Function<Supervisor, SupervisorDTO> {

    @Override
    public SupervisorDTO apply(Supervisor supervisor) {
        return
                new SupervisorDTO(
                        supervisor.getId(),
                        supervisor.getName(),
                        supervisor.getEmail(),
                        supervisor.getPhone(),
                        supervisor.getSpeciality(),
                        supervisor.getInternList().stream().map(intern -> intern.getName()).collect(Collectors.toList()),
                        supervisor.getTopicList().stream().map(topic -> topic.getTitle()).collect(Collectors.toList())
                )

                ;
    }
}
