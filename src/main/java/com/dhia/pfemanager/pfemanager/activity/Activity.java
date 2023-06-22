package com.dhia.pfemanager.pfemanager.activity;


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
    private String fileURL;
    private Date deadline;
    private String duration;

    @OneToMany(mappedBy = "commentedActivity")
    private List<Comment> commentList;

    @ManyToOne
    @JoinColumn(name = "intern_id")
    private Intern intern;

    @ManyToOne
    @JoinColumn(name = "topic_id")
    private Topic topic;

}
