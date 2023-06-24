package com.dhia.pfemanager.pfemanager.activity.todo;

import com.dhia.pfemanager.pfemanager.activity.topicActivity.Activity;
import com.dhia.pfemanager.pfemanager.comment.Comment;
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
@Table(name = "todo")
public class Todo extends Activity {

    private Date deadline;

    @OneToMany(mappedBy = "commentedTodo")
    private List<Comment> commentList;

    @ManyToOne
    @JoinColumn(name = "intern_id")
    private Intern intern;

}
