package com.dhia.pfemanager.pfemanager.topic;


import com.dhia.pfemanager.pfemanager.activity.topicActivity.Activity;
import com.dhia.pfemanager.pfemanager.activity.topicActivity.ActivityAddingRequest;
import com.dhia.pfemanager.pfemanager.activity.topicActivity.ActivityRepository;
import com.dhia.pfemanager.pfemanager.user.enterprise.Enterprise;
import com.dhia.pfemanager.pfemanager.user.enterprise.EnterpriseRepository;
import com.dhia.pfemanager.pfemanager.user.intern.Intern;
import com.dhia.pfemanager.pfemanager.user.intern.InternRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TopicService {

    private final TopicRepository topicRepository;
    private final ActivityRepository activityRepository;
    private final EnterpriseRepository enterpriseRepository;
    private final TopicDTOMapper topicDTOMapper;
    private final InternRepository internRepository;


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

    public void assignTopicToIntern(Integer internId, Integer topicId) {
        Intern intern = internRepository.findInternById(internId);
        Topic topic = topicRepository.findTopicById(topicId);

        intern.setInternshipTopic(topic);
        topic.setIntern(intern);
        topic.setAvailable(false);

        topicRepository.save(topic);

    }

    public Optional<TopicDTO> getTopicsByIntern(Integer internId) {
        return topicRepository.findTopicByInternId(internId)
                .map(topicDTOMapper);

    }
}
