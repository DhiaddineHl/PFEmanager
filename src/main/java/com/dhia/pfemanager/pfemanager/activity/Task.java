package com.dhia.pfemanager.pfemanager.activity;


import com.dhia.pfemanager.pfemanager.activity.topicActivity.Activity;
import com.dhia.pfemanager.pfemanager.user.supervisor.Supervisor;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "task")
public class Task extends Activity {

    @ManyToOne
    @JoinColumn(name = "supervisor_id")
    private Supervisor assigner;


}
