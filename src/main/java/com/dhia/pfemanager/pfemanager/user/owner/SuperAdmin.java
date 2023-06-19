package com.dhia.pfemanager.pfemanager.user.owner;


import com.dhia.pfemanager.pfemanager.user.appUser.User;
import com.dhia.pfemanager.pfemanager.user.enterprise.Enterprise;
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
public class SuperAdmin extends User {

    private List<Enterprise> clients;


}
