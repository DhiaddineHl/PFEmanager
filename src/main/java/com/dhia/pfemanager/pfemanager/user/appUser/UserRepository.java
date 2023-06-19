package com.dhia.pfemanager.pfemanager.user.appUser;

import com.dhia.pfemanager.pfemanager.user.appUser.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findUserByEmail(String email);


    User findUserById(Integer id);
}
