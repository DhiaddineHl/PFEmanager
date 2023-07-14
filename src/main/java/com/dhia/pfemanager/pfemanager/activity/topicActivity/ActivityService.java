package com.dhia.pfemanager.pfemanager.activity.topicActivity;


import com.dhia.pfemanager.pfemanager.exceptions.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ActivityService {

    private final ActivityRepository activityRepository;
    public void deleteActivityById(Integer activityId) {
        if (!activityRepository.existsById(activityId)){
            throw new EntityNotFoundException("This activity doesn't exist");
        }
        activityRepository.deleteById(activityId);
    }
}
