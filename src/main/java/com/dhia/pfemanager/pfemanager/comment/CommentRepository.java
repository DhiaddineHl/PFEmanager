package com.dhia.pfemanager.pfemanager.comment;

import com.dhia.pfemanager.pfemanager.activity.todo.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
}
