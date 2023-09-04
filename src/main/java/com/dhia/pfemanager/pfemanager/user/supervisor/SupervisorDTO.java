package com.dhia.pfemanager.pfemanager.user.supervisor;

import java.util.List;

public record SupervisorDTO(
        Integer id,
        String name,
        String email,
        String phone,
        String speciality,
        List<String>  interns,
        List<String> topics

) {
}
