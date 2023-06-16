package com.dhia.pfemanager.pfemanager.user;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Permission {


    ENTERPRISE_READ("enterprise:read"),
    INTERN_READ("intern:read")
    ;
    @Getter
    private final String permission;
}
