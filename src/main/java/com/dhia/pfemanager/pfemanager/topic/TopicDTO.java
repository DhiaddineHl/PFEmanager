package com.dhia.pfemanager.pfemanager.topic;

import com.dhia.pfemanager.pfemanager.activity.topicActivity.ActivityDTO;

import java.util.List;

public record TopicDTO(
        Integer id,
        String title,
        String description,
        String duration,
        boolean isAvailable,
        String internName,
        String supervisorName,
        List<ActivityDTO> activities

) {
}
