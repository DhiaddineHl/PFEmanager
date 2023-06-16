package com.dhia.pfemanager.pfemanager.user.owner;


import com.dhia.pfemanager.pfemanager.user.User;
import com.dhia.pfemanager.pfemanager.user.UserRole;
import com.dhia.pfemanager.pfemanager.user.enterprise.Enterprise;
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
@Table(name = "owner")
public class SuperAdmin extends User {

    @OneToMany(mappedBy = "applicationOwner")
    private List<Enterprise> clients;


}
