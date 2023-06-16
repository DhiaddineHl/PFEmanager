package com.dhia.pfemanager.pfemanager.user.intern;

import com.dhia.pfemanager.pfemanager.user.User;
import com.dhia.pfemanager.pfemanager.user.UserRole;
import com.dhia.pfemanager.pfemanager.user.enterprise.Enterprise;
import com.dhia.pfemanager.pfemanager.user.supervisor.Supervisor;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "intern")
public class Intern extends User {


    @ManyToOne
    @JoinColumn(name = "enterprise_name")
    private Enterprise enterprise;

    @ManyToMany
    @JoinTable(
            name = "supervisors",
            joinColumns = @JoinColumn(name = "supervisor_id"),
            inverseJoinColumns = @JoinColumn(name = "intern_id")
    )
    private List<Supervisor> supervisors;

}
