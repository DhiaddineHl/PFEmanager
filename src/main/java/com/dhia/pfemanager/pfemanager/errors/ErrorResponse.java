package com.dhia.pfemanager.pfemanager.errors;


import lombok.Data;

import java.util.Date;

@Data
public class ErrorResponse {

    private Integer statusCode;
    private String errorMessage;
    private Date timestamps;

}
