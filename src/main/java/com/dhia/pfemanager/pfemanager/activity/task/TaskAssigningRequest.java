package com.dhia.pfemanager.pfemanager.activity.task;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
public class TaskAssigningRequest {

    String title ;
    String description;
    String duration;
    Date deadline;
    Integer assignerId;


}
