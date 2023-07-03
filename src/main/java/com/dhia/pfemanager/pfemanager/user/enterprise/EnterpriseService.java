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


    public void blockEnterprise(Integer enterpriseId) throws IllegalAccessException {
        var enterprise = enterpriseRepository.findEnterpriseById(enterpriseId);
        if (enterprise.isBlocked()){
           throw new IllegalAccessException("Enterprise is already blocked");
        }
        else{
            enterprise.setBlocked(true);
            enterpriseRepository.save(enterprise);
        }
    }

    public void enableEnterprise(Integer id) throws IllegalAccessException {
        Enterprise enterprise = enterpriseRepository.findEnterpriseById(id);
        if (!enterprise.isBlocked()){
            throw new IllegalAccessException("This enterprise is already enabled");
        }
        else{
            enterprise.setBlocked(false);
            enterpriseRepository.save(enterprise);
        }

    }
}
