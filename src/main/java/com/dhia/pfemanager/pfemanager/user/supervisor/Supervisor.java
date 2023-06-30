package com.dhia.pfemanager.pfemanager.user.supervisor;

import com.dhia.pfemanager.pfemanager.user.appUser.User;
import com.dhia.pfemanager.pfemanager.user.enterprise.Enterprise;
import com.dhia.pfemanager.pfemanager.user.intern.Intern;
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
public class Supervisor extends User {

    private String type;

    @ManyToOne
    @JoinColumn(name = "enterprise_id")
    private Enterprise enterprise;

    @ManyToMany(mappedBy = "supervisors")
    private List<Intern> internList;


}
