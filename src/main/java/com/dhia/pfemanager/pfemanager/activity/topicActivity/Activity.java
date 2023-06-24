package com.dhia.pfemanager.pfemanager.activity.topicActivity;


import com.dhia.pfemanager.pfemanager.comment.Comment;
import com.dhia.pfemanager.pfemanager.topic.Topic;
import com.dhia.pfemanager.pfemanager.user.intern.Intern;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Date;
import java.util.List;

@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "activity")
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String title;
    private String description;
    private String duration;

    @ManyToOne
    @JoinColumn(name = "topic_id")
    private Topic topic;

}
