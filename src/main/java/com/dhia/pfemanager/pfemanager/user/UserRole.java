package com.dhia.pfemanager.pfemanager.user;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public enum UserRole {

    SUPER_ADMIN(null),
    ENTERPRISE(
            Set.of(
                    Permission.ENTERPRISE_READ,
                    Permission.INTERN_READ
            )
    ),
    INTERN(
            Set.of(
                    Permission.INTERN_READ
            )
    ),
    SUPERVISOR(null);

    @Getter
    private final Set<Permission> permissions;

    public List<SimpleGrantedAuthority> getAuthorities(){
        var authorities = getPermissions()
                .stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toList());
        authorities.add(new  SimpleGrantedAuthority("ROLE_" + this.name()));
        return authorities;
    }



}
