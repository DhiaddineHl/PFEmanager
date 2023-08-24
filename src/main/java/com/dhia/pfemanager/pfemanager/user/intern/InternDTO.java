package com.dhia.pfemanager.pfemanager.user.intern;

import com.dhia.pfemanager.pfemanager.topic.Topic;
import com.dhia.pfemanager.pfemanager.topic.TopicDTO;

public record InternDTO(
        Integer id,
        String name,
        String email,
        String phone,
        String speciality,
        String topicTitle,
        String supervisor
) {
}
