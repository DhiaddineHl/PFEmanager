package com.dhia.pfemanager.pfemanager.user.intern;

import org.springframework.stereotype.Service;

import java.util.function.Function;


@Service
public class InternDTOMapper implements Function<Intern, InternDTO> {
    @Override
    public InternDTO apply(Intern intern) {
        return
                new InternDTO(
                        intern.getId(),
                        intern.getName(),
                        intern.getEmail(),
                        intern.getPhone(),
                        intern.getSpeciality(),
                        intern.getInternshipTopic() != null ? intern.getInternshipTopic().getTitle() : "No topic assigned",
                        intern.getSupervisor() != null ? intern.getSupervisor().getName() : "No supervisor assigned yet",
                        intern.getRating() != null ? intern.getRating() : 0
                )

                ;
    }
}
