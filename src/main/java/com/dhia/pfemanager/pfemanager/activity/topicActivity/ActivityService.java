package com.dhia.pfemanager.pfemanager.activity.topicActivity;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ActivityService {

    private final ActivityRepository activityRepository;
    public void deleteActivityById(Integer activityId) {
        activityRepository.deleteById(activityId);
    }
}
