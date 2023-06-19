package com.dhia.pfemanager.pfemanager.user.enterprise;


import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class EnterpriseDTOMapper implements Function<Enterprise, EnterpriseDTO> {
    @Override
    public EnterpriseDTO apply(Enterprise enterprise) {
        return
                new EnterpriseDTO(
                        enterprise.getId(),
                        enterprise.getName(),
                        enterprise.getEmail(),
                        enterprise.getPhone(),
                        enterprise.getField(),
                        enterprise.isBlocked()
                );
    }
}
