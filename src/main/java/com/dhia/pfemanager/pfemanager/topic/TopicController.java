package com.dhia.pfemanager.pfemanager.topic;


import com.dhia.pfemanager.pfemanager.activity.ActivityAddingRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/topics")
public class TopicController {

    private final TopicService topicService;

    @PostMapping("/create")
    public void createTopic(
            @RequestBody TopicCreationRequest request
    ){
        topicService.createTopic(request);
    }

    @PostMapping("/addActivity/{topicId}")
    public void addActivityToTopic(
            @PathVariable("topicId") Integer topicId,
            @RequestBody ActivityAddingRequest request
    ){
        topicService.addActivity(topicId, request);
    }

    @GetMapping("/byEnterprise/{enterpriseId}")
    public ResponseEntity<List<TopicDTO>>getTopicsByEnterprise(
            @PathVariable("enterpriseId") Integer enterpriseId
    ){
        return ResponseEntity.ok(topicService.getTopicsByEnterprise(enterpriseId));
    }

    @PutMapping("/assign/{topicId}/to/intern=/{internId}")
    public void assignTopicToIntern(
            @PathVariable("internId") Integer internId,
            @PathVariable("topicId") Integer topicId
    ){
        topicService.assignTopicToIntern(internId,topicId);
    }

}
