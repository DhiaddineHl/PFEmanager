package com.dhia.pfemanager.pfemanager.topic;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class TopicCreationRequest {
    private String title;
    private String description;
    private String duration;
    private String field;
    private Integer enterpriseId;
}
