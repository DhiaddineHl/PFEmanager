package com.dhia.pfemanager.pfemanager.user.enterprise;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface EnterpriseRepository extends JpaRepository<Enterprise, Integer> {


    @Query("""
        select e from Enterprise e where e.email = :email
""")
    Enterprise findEnterpriseByEmail(String email);
}
