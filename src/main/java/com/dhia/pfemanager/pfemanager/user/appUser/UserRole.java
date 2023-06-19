package com.dhia.pfemanager.pfemanager.user.appUser;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public enum UserRole {

    SUPER_ADMIN(
            Set.of(
                    Permission.SUPER_ADMIN_READ,
                    Permission.SUPER_ADMIN_CREATE,
                    Permission.SUPER_ADMIN_UPDATE,
                    Permission.SUPER_ADMIN_DELETE
            )
    ),
    ENTERPRISE(
            Set.of(

                    Permission.ENTERPRISE_READ,
                    Permission.ENTERPRISE_CREATE,
                    Permission.ENTERPRISE_UPDATE,
                    Permission.ENTERPRISE_DELETE,


                    Permission.INTERN_READ,
                    Permission.INTERN_CREATE,
                    Permission.INTERN_UPDATE,
                    Permission.INTERN_DELETE,


                    Permission.SUPERVISOR_READ,
                    Permission.SUPERVISOR_CREATE,
                    Permission.SUPERVISOR_UPDATE,
                    Permission.SUPERVISOR_DELETE

            )
    ),
    INTERN(
            Set.of(
                    Permission.INTERN_READ,
                    Permission.INTERN_CREATE,
                    Permission.INTERN_UPDATE,
                    Permission.INTERN_DELETE
            )
    ),
    SUPERVISOR(

            Set.of(
                    Permission.SUPERVISOR_READ,
                    Permission.SUPERVISOR_CREATE,
                    Permission.SUPERVISOR_UPDATE,
                    Permission.SUPERVISOR_DELETE
            )

    );

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
