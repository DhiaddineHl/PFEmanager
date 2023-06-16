package com.dhia.pfemanager.pfemanager.comment;

import com.dhia.pfemanager.pfemanager.activity.Activity;
import com.dhia.pfemanager.pfemanager.user.supervisor.Supervisor;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String description;
    @ManyToOne
    @JoinColumn(name = "activity_id")
    private Activity commentedActivity;


}
