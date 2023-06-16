package com.dhia.pfemanager.pfemanager.authentication.requests;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EnterpriseRegisterRequest {

    private String name;
    private String email;
    private String password;
    private String phone;
    private String field;

}
