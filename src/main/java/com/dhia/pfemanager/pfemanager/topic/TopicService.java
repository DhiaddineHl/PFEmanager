package com.dhia.pfemanager.pfemanager.topic;


import com.dhia.pfemanager.pfemanager.activity.Activity;
import com.dhia.pfemanager.pfemanager.activity.ActivityAddingRequest;
import com.dhia.pfemanager.pfemanager.activity.ActivityRepository;
import com.dhia.pfemanager.pfemanager.user.enterprise.Enterprise;
import com.dhia.pfemanager.pfemanager.user.enterprise.EnterpriseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TopicService {

    private final TopicRepository topicRepository;
    private final ActivityRepository activityRepository;
    private final EnterpriseRepository enterpriseRepository;
    private final TopicDTOMapper topicDTOMapper;
    public void createTopic(TopicCreationRequest request) {
        Enterprise enterprise = enterpriseRepository.findEnterpriseById(request.getEnterpriseId());
        var topic = Topic.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .duration(request.getDuration())
                .field(request.getField())
                .enterprise(enterprise)
                .build();
        topicRepository.save(topic);

    }

    public void addActivity(Integer topicId, ActivityAddingRequest request) {
        Topic topic = topicRepository.findTopicById(topicId);
        var activity = Activity.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .duration(request.getDuration())
                .topic(topic)
                .build();
        activityRepository.save(activity);
        topic.getActivities().add(activity);
    }

    public List<TopicDTO> getTopicsByEnterprise(Integer enterpriseId) {
        return topicRepository.findTopicsByEnterpriseId(enterpriseId)
                .stream()
                .map(topicDTOMapper)
                .collect(Collectors.toList());
    }
}
