package com.dhia.pfemanager.pfemanager.activity.todo;

import com.dhia.pfemanager.pfemanager.comment.CommentDTO;

import java.util.Date;
import java.util.List;

public record TodoDTO(
        Integer id,
        String title,
        String description,
        Date deadline,
        List<CommentDTO> comments
) {
}
