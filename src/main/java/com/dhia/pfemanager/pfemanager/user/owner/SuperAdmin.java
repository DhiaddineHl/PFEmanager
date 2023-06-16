package com.dhia.pfemanager.pfemanager.user.owner;


import com.dhia.pfemanager.pfemanager.user.User;
import com.dhia.pfemanager.pfemanager.user.UserRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;


@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "owner")
public class SuperAdmin extends User {

    private UserRole role = UserRole.SUPER_ADMIN;


}
