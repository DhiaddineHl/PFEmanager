package com.dhia.pfemanager.pfemanager.user.owner;


import com.dhia.pfemanager.pfemanager.user.enterprise.Enterprise;
import com.dhia.pfemanager.pfemanager.user.enterprise.EnterpriseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SuperAdminService {
    private final EnterpriseRepository enterpriseRepository;


    public List<Enterprise> getAllEnterprises(){
        return enterpriseRepository.findAll();
    }

}
