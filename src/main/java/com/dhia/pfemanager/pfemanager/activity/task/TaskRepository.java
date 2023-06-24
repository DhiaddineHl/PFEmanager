package com.dhia.pfemanager.pfemanager.activity.task;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task,Integer> {


    List<Task> findTasksByInternId(Integer internId);


}
