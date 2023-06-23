package com.dhia.pfemanager.pfemanager.topic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.List;

public interface TopicRepository extends JpaRepository<Topic,Integer> {

    Topic findTopicById(Integer id);

    @Query("""
        select t from Topic t where t.enterprise.id =:enterpriseId
""")
    List<Topic> findTopicsByEnterpriseId(Integer enterpriseId);

    Optional<Topic> findTopicByInternId(Integer internID);

}
