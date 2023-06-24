package com.dhia.pfemanager.pfemanager.activity.task;

import com.dhia.pfemanager.pfemanager.comment.CommentDTO;

import java.util.Date;
import java.util.List;

public record TaskDTO (
        Integer id,
        String title,
        String description,
        Date deadline,
        String assignerName,
        List<CommentDTO> comments
) {
}
