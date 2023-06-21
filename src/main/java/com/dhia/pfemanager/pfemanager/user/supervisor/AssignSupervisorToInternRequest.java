package com.dhia.pfemanager.pfemanager.user.supervisor;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AssignSupervisorToInternRequest {

    private String supervisorEmail;
    private String internEmail;

}
