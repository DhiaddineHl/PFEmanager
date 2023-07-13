package com.dhia.pfemanager.pfemanager.activity.topicActivity;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/activities")
public class ActivityController {

    private final ActivityService activityService;

    @DeleteMapping("/delete/{activityId}")
    public void deleteActivity(
            @PathVariable("activityId") Integer activityId
    ){
        activityService.deleteActivityById(activityId);
    }

}
