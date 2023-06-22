package com.dhia.pfemanager.pfemanager.user.intern;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface InternRepository extends JpaRepository<Intern, Integer> {

    @Query("""
        select i from Intern i join Enterprise e on i.enterprise.id = e.id
        where e.id = :enterpriseId
        """)
    List<Intern> findInternsByEnterpriseId(Integer enterpriseId);

    Intern findByEmail(String internEmail);
}
