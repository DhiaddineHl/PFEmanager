package com.dhia.pfemanager.pfemanager.authentication.requests;


import com.dhia.pfemanager.pfemanager.user.enterprise.Enterprise;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SupervisorRegisterRequest {

    private String name;
    private String email;
    private String password;
    private String phone;
    private String speciality;
    private String type;
    private String enterpriseEmail;

}
