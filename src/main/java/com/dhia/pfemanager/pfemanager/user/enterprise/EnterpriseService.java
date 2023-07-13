package com.dhia.pfemanager.pfemanager.user.enterprise;


import com.dhia.pfemanager.pfemanager.exceptions.EnterpriseBlockedException;
import com.dhia.pfemanager.pfemanager.exceptions.EnterpriseEnabledException;
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


    public void blockEnterprise(Integer enterpriseId) throws EnterpriseBlockedException {
        var enterprise = enterpriseRepository.findEnterpriseById(enterpriseId);
        if (enterprise.isBlocked()){
           throw new EnterpriseBlockedException("This enterprise is already Blocked");
        }
        else{
            enterprise.setBlocked(true);
            enterpriseRepository.save(enterprise);
        }
    }

    public void enableEnterprise(Integer id) throws EnterpriseEnabledException {
        Enterprise enterprise = enterpriseRepository.findEnterpriseById(id);
        if (!enterprise.isBlocked()){
            throw new EnterpriseEnabledException("This enterprise is already enabled");
        }
        else{
            enterprise.setBlocked(false);
            enterpriseRepository.save(enterprise);
        }

    }

    public void deleteEnterpriseById(Integer enterpriseId) {
        enterpriseRepository.deleteById(enterpriseId);
    }
}
