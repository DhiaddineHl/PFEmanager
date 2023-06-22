package com.dhia.pfemanager.pfemanager.user.supervisor;


import com.dhia.pfemanager.pfemanager.user.intern.Intern;
import com.dhia.pfemanager.pfemanager.user.intern.InternDTO;
import com.dhia.pfemanager.pfemanager.user.intern.InternRepository;
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
    private final InternRepository internRepository;

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

    public void assignSupervisorToIntern(String supervisorEmail, String internEmail) {
        Supervisor supervisor = supervisorRepository.findByEmail(supervisorEmail);
        Intern intern = internRepository.findByEmail(internEmail);
        //add intern to supervisor internList
        supervisor.getInternList().add(intern);
        supervisorRepository.save(supervisor);
        //add supervisor to intern supervisorList
        intern.getSupervisors().add(supervisor);
        internRepository.save(intern);

    }

    public void assignSupervisorToInternById(Integer supervisorId, Integer internId) {
        Supervisor supervisor = supervisorRepository.findSupervisorById(supervisorId);
        Intern intern = internRepository.findInternById(internId);
        //add intern to supervisor internList
        supervisor.getInternList().add(intern);
        supervisorRepository.save(supervisor);
        //add supervisor to intern supervisorsList
        intern.getSupervisors().add(supervisor);
        internRepository.save(intern);
    }


}
