package com.dhia.pfemanager.pfemanager.activity.task;


import com.dhia.pfemanager.pfemanager.activity.todo.Todo;
import com.dhia.pfemanager.pfemanager.activity.topicActivity.Activity;
import com.dhia.pfemanager.pfemanager.user.supervisor.Supervisor;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "task")
public class Task extends Todo {

    @ManyToOne
    @JoinColumn(name = "supervisor_id")
    private Supervisor assigner;


}
