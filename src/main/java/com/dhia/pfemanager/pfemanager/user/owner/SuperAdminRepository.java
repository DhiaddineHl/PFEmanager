package com.dhia.pfemanager.pfemanager.user.owner;

import com.dhia.pfemanager.pfemanager.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SuperAdminRepository extends JpaRepository<SuperAdmin, Integer> {

//    @Query("""
//    select u from User u where u.role = "SUPER_ADMIN"
//""")
//    List<User> loadAdmin();

}
