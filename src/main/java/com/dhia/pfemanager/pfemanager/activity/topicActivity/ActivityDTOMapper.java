package com.dhia.pfemanager.pfemanager.activity.topicActivity;

import com.dhia.pfemanager.pfemanager.activity.topicActivity.Activity;
import com.dhia.pfemanager.pfemanager.activity.topicActivity.ActivityDTO;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class ActivityDTOMapper implements Function<Activity, ActivityDTO> {
    @Override
    public ActivityDTO apply(Activity activity) {
        return
                new ActivityDTO(
                        activity.getId(),
                        activity.getTitle(),
                        activity.getDescription(),
                        activity.getDuration()
                );
    }
}
