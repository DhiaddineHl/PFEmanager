package com.dhia.pfemanager.pfemanager.activity.todo;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
public class TodoCreationRequest {

    private String title;
    private String description;
    private String duration;
    private Date deadline;
    private Integer internId;

}
