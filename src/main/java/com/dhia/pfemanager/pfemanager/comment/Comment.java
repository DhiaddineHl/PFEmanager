package com.dhia.pfemanager.pfemanager.comment;

import com.dhia.pfemanager.pfemanager.activity.topicActivity.Activity;
import com.dhia.pfemanager.pfemanager.user.supervisor.Supervisor;
import com.dhia.pfemanager.pfemanager.user.supervisor.SupervisorDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String description;
    @ManyToOne
    @JoinColumn(name = "todo_id")
    private Activity commentedTodo;

    @ManyToOne
    @JoinColumn(name = "supervisor_id")
    private Supervisor commenter;


}
