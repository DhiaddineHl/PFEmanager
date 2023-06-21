package com.dhia.pfemanager.pfemanager.user.supervisor;


import com.dhia.pfemanager.pfemanager.user.intern.InternDTO;
import org.springframework.stereotype.Service;

import java.util.function.Function;

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
                        supervisor.getSpeciality()
                )

                ;
    }
}
