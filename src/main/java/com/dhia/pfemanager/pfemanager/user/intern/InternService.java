package com.dhia.pfemanager.pfemanager.user.intern;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class InternService {

    private final InternRepository internRepository;
    private final InternDTOMapper internDTOMapper;


    public List<InternDTO> getAllInterns(){
        return internRepository.findAll()
                .stream()
                .map(internDTOMapper)
                .collect(Collectors.toList());

    }

    public Optional<InternDTO> getInternById(Integer id){
        return internRepository.findById(id)
                .map(internDTOMapper);
    }


    public List<InternDTO> getInternsByEnterpriseId(Integer enterpriseId) {
        return internRepository.findInternsByEnterpriseId(enterpriseId)
                .stream()
                .map(internDTOMapper)
                .collect(Collectors.toList());
    }

    public List<InternDTO> getInternsBySupervisor(Integer supervisorId) {
        return internRepository.findInternsBySupervisorId(supervisorId)
                .stream()
                .map(internDTOMapper)
                .collect(Collectors.toList());
    }
}
