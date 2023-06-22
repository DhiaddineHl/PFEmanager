package com.dhia.pfemanager.pfemanager.activity;

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
