package com.dhia.pfemanager.pfemanager.user.enterprise;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EnterpriseService {

    private final EnterpriseRepository enterpriseRepository;
    private final EnterpriseDTOMapper enterpriseDTOMapper;

    public List<EnterpriseDTO> getAllEnterprises(){
        return enterpriseRepository.findAll()
                .stream()
                .map(enterpriseDTOMapper)
                .collect(Collectors.toList());
    }

    public Optional<EnterpriseDTO> getEnterpriseById(Integer id){
        return enterpriseRepository.findById(id)
                .map(enterpriseDTOMapper);
    }

}
