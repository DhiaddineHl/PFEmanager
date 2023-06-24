package com.dhia.pfemanager.pfemanager.activity.topicActivity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ActivityAddingRequest {

    private String title;
    private String description;
    private String duration;


}
