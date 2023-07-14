package com.dhia.pfemanager.pfemanager.topic;


import com.dhia.pfemanager.pfemanager.activity.topicActivity.ActivityAddingRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @DeleteMapping("/delete/{id}")
    public void deleteTopic(
            @PathVariable("id") Integer id
    ){
        topicService.deleteTopicById(id);
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

    @GetMapping("/byIntern/{internId}")
    public ResponseEntity<Optional<TopicDTO>>getTopicsByIntern(
            @PathVariable("internId") Integer internId
    ){
        return ResponseEntity.ok(topicService.getTopicsByIntern(internId));
    }

    @PutMapping("/assign/{topicId}/to/intern=/{internId}")
    public void assignTopicToIntern(
            @PathVariable("internId") Integer internId,
            @PathVariable("topicId") Integer topicId
    ){
        topicService.assignTopicToIntern(internId,topicId);
    }


}
