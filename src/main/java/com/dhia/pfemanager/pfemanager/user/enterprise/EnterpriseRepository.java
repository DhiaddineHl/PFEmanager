package com.dhia.pfemanager.pfemanager.user.enterprise;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface EnterpriseRepository extends JpaRepository<Enterprise, Integer> {


//    @Query("""
//        select e from Enterprise e where e.email = :email
//""")
//    Enterprise findEnterpriseByEmail(String email);

    Enterprise findEnterpriseById(Integer id);

    Enterprise findEnterpriseByEmail(String email);

    boolean existsEnterpriseByEmail(String email);


}
