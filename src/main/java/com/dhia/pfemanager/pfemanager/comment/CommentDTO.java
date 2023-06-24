package com.dhia.pfemanager.pfemanager.comment;

import com.dhia.pfemanager.pfemanager.user.supervisor.SupervisorDTO;

public record CommentDTO(
        Integer id,
        String description,
        String commenterName
) {
}
