package com.dhia.pfemanager.pfemanager.user.intern;

import com.dhia.pfemanager.pfemanager.activity.Activity;
import com.dhia.pfemanager.pfemanager.user.appUser.User;
import com.dhia.pfemanager.pfemanager.user.enterprise.Enterprise;
import com.dhia.pfemanager.pfemanager.user.supervisor.Supervisor;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.context.annotation.Lazy;

import java.util.List;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Intern extends User {


    @ManyToOne
    @JoinColumn(name = "enterprise_id")
    private Enterprise enterprise;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "supervisors",
            joinColumns = @JoinColumn(name = "supervisor_id"),
            inverseJoinColumns = @JoinColumn(name = "intern_id")
    )
    private List<Supervisor> supervisors;

    @OneToMany(mappedBy = "intern")
    private List<Activity> internshipJournal;

}
