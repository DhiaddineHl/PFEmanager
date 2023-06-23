package com.dhia.pfemanager.pfemanager.user.supervisor;

import com.dhia.pfemanager.pfemanager.user.intern.Intern;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.List;

public interface SupervisorRepository extends JpaRepository<Supervisor, Integer> {


    @Query("""
        select s from Supervisor s join Enterprise e on s.enterprise.id = e.id
        where e.id = :enterpriseId
        """)
    List<Supervisor> findSupervisorsByEnterpriseId(Integer enterpriseId);

    Supervisor findByEmail(String email);

    Supervisor findSupervisorById(Integer id);


}
