package com.dhia.pfemanager.pfemanager.topic;


import com.dhia.pfemanager.pfemanager.activity.Activity;
import com.dhia.pfemanager.pfemanager.user.enterprise.Enterprise;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;
import java.util.Set;

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

    @OneToMany(mappedBy = "topic")
    private List<Activity> activities;

    @ManyToOne
    @JoinColumn(name = "enterprise_id")
    private Enterprise enterprise;

}
