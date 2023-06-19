package com.dhia.pfemanager.pfemanager.user.enterprise;

public record EnterpriseDTO(
        Integer id,
        String name,
        String email,
        String phone,
        String field,
        boolean isBlocked
) {
}
