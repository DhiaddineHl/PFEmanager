package com.dhia.pfemanager.pfemanager.activity;


import com.dhia.pfemanager.pfemanager.comment.Comment;
import com.dhia.pfemanager.pfemanager.user.intern.Intern;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Date;
import java.util.List;

@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "activity")
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String title;
    private String description;
    private String fileURL;

    @OneToMany(mappedBy = "commentedActivity")
    private List<Comment> commentList;

    private Date deadline;

    @ManyToOne
    @JoinColumn(name = "intern_id")
    private Intern intern;

}
