package com.dhia.pfemanager.pfemanager.user.enterprise;


import com.dhia.pfemanager.pfemanager.user.User;
import com.dhia.pfemanager.pfemanager.user.UserRole;
import com.dhia.pfemanager.pfemanager.user.intern.Intern;
import com.dhia.pfemanager.pfemanager.user.owner.SuperAdmin;
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
@Table(name = "enterprise")
public class Enterprise extends User {

    private String field;
    @OneToMany(mappedBy = "enterprise")
    private List<Intern> internList;
    @OneToMany(mappedBy = "enterprise")
    private List<Supervisor> supervisorList;

    @ManyToOne
    @JoinColumn(name = "superAdmin_id")
    private SuperAdmin applicationOwner;

}
