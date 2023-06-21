package com.dhia.pfemanager.pfemanager.user.supervisor;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SupervisorService {

    private final SupervisorRepository supervisorRepository;
    private final SupervisorDTOMapper supervisorDTOMapper;

    public List<SupervisorDTO> getAllSupervisors() {
        return supervisorRepository.findAll()
                .stream()
                .map(supervisorDTOMapper)
                .collect(Collectors.toList());
    }

    public Optional<SupervisorDTO> getSupervisorById(Integer id) {
        return supervisorRepository.findById(id)
                .map(supervisorDTOMapper);
    }

    public List<SupervisorDTO> getSupervisorsByEnterpriseId(Integer enterpriseId) {
        return supervisorRepository.findSupervisorsByEnterpriseId(enterpriseId)
                .stream()
                .map(supervisorDTOMapper)
                .collect(Collectors.toList());
    }
}
