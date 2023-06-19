package com.dhia.pfemanager.pfemanager.user.owner;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SuperAdminRepository extends JpaRepository<SuperAdmin, Integer> {

//    @Query("""
//    select u from User u where u.role = "SUPER_ADMIN"
//""")
//    List<User> loadAdmin();

    SuperAdmin getSuperAdminById(Integer id);

}
