package com.dhia.pfemanager.pfemanager.user.enterprise;


import com.dhia.pfemanager.pfemanager.user.appUser.User;
import com.dhia.pfemanager.pfemanager.user.intern.Intern;
import com.dhia.pfemanager.pfemanager.user.owner.SuperAdmin;
import com.dhia.pfemanager.pfemanager.user.supervisor.Supervisor;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Enterprise extends User {

    private String field;
    private boolean isBlocked;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "super_admin_id")
    private SuperAdmin applicationOwner;

    @Override
    public boolean isEnabled() {
        return !this.isBlocked;
    }

}
