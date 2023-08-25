package com.dhia.pfemanager.pfemanager.topic;

import com.dhia.pfemanager.pfemanager.activity.topicActivity.ActivityDTOMapper;
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
                        topic.getIntern() == null ? "No intern assigned to yet" : topic.getIntern().getName(),
                        topic.getSupervisor() == null ? "No supervisor assigned to yet" : topic.getSupervisor().getName(),
                         topic.getActivities()
                                .stream()
                                .map(activityDTOMapper)
                                .collect(Collectors.toList())
                );
    }
}
