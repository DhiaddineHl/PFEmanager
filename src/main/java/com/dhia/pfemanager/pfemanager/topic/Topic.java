package com.dhia.pfemanager.pfemanager.topic;


import com.dhia.pfemanager.pfemanager.activity.topicActivity.Activity;
import com.dhia.pfemanager.pfemanager.user.enterprise.Enterprise;
import com.dhia.pfemanager.pfemanager.user.intern.Intern;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "topic")
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String title;
    private String description;
    private String duration;
    private String field;
    private boolean isAvailable = true;

    @OneToMany(mappedBy = "topic")
    private List<Activity> activities;

    @ManyToOne
    @JoinColumn(name = "enterprise_id")
    private Enterprise enterprise;

    @OneToOne
    @JoinColumn(name = "intern_id")
    private Intern intern;

}
