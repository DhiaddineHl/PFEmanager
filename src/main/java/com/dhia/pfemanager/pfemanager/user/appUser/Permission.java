package com.dhia.pfemanager.pfemanager.user.appUser;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Permission {


    ENTERPRISE_READ("enterprise:read"),
    ENTERPRISE_CREATE("enterprise:create"),
    ENTERPRISE_UPDATE("enterprise:update"),
    ENTERPRISE_DELETE("enterprise:delete"),

    INTERN_READ("intern:read"),
    INTERN_CREATE("intern:create"),
    INTERN_UPDATE("intern:update"),
    INTERN_DELETE("intern:delete"),


    SUPERVISOR_READ("supervisor:read"),
    SUPERVISOR_CREATE("supervisor:create"),
    SUPERVISOR_UPDATE("supervisor:update"),
    SUPERVISOR_DELETE("supervisor:delete"),


    SUPER_ADMIN_READ("superAdmin:read"),
    SUPER_ADMIN_CREATE("superAdmin:create"),
    SUPER_ADMIN_UPDATE("superAdmin:update"),
    SUPER_ADMIN_DELETE("superAdmin:delete")
    ;
    @Getter
    private final String permission;
}
