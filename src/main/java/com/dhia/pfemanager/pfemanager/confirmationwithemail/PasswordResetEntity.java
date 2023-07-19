package com.dhia.pfemanager.pfemanager.confirmationwithemail;


import com.dhia.pfemanager.pfemanager.user.appUser.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;


@NoArgsConstructor
@Data
@Entity
public class PasswordResetEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String token;

    @OneToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    private LocalDateTime creationDate;

    public PasswordResetEntity(User user) {
        this.user = user;
        this.creationDate = LocalDateTime.now();
        this.token = UUID.randomUUID().toString();
    }
}
