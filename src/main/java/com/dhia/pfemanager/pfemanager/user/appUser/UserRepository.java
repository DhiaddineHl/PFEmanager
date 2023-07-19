package com.dhia.pfemanager.pfemanager.user.appUser;

import com.dhia.pfemanager.pfemanager.user.appUser.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findUserByEmail(String email);

    @Query("""
    select u from User u where u.email = :email
""")
    User findUserByEmailAddress(String email);

    boolean existsByEmail(String email);

    User findUserById(Integer id);
}
