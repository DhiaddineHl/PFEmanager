package com.dhia.pfemanager.pfemanager.topic;

import com.dhia.pfemanager.pfemanager.activity.ActivityDTOMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.function.Function;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class TopicDTOMapper implements Function<Topic, TopicDTO> {

    private final ActivityDTOMapper activityDTOMapper;

    @Override
    public TopicDTO apply(Topic topic) {
        return
                new TopicDTO(
                        topic.getId(),
                        topic.getTitle(),
                        topic.getDescription(),
                        topic.getDuration(),
                        topic.isAvailable(),
                        topic.getActivities()
                                .stream()
                                .map(activityDTOMapper)
                                .collect(Collectors.toList())
                );
    }
}
