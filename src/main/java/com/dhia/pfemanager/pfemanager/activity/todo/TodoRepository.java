package com.dhia.pfemanager.pfemanager.activity.todo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Integer> {

    List<Todo> findTodosByInternId(Integer id);

    Todo findTodoById(Integer todoId);

}
