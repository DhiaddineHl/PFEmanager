package com.dhia.pfemanager.pfemanager.user.supervisor;


import com.dhia.pfemanager.pfemanager.user.intern.InternDTO;
import com.dhia.pfemanager.pfemanager.user.intern.InternService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/supervisor")
@Slf4j
public class SupervisorController {

    private final SupervisorService supervisorService;

    @GetMapping("/all")
    public ResponseEntity<List<SupervisorDTO>> getAllSupervisors(){
        List<SupervisorDTO> supervisors = supervisorService.getAllSupervisors();
        return ResponseEntity.ok(supervisors);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Optional<SupervisorDTO>> getSupervisorById(@PathVariable("id") Integer id){
        Optional<SupervisorDTO> supervisor = supervisorService.getSupervisorById(id);
        return ResponseEntity.ok(supervisor);
    }

    @GetMapping("/byEnterprise/{enterpriseId}")
    public ResponseEntity<List<SupervisorDTO>> getSupervisorsByEnterprise(@PathVariable("enterpriseId") Integer enterpriseId){
        List<SupervisorDTO> supervisorsByEnterprise = supervisorService.getSupervisorsByEnterpriseId(enterpriseId);
        return ResponseEntity.ok(supervisorsByEnterprise);
    }

    @PutMapping("/assign")
    public void assignSupervisorToIntern(
            @RequestBody AssignSupervisorToInternRequest request
    ){
        supervisorService.assignSupervisorToIntern(
                request.getSupervisorEmail(), request.getInternEmail()
        );
    }

    @PutMapping("/assign/{supervisorId}/to/{internId}")
    public void assignSupervisorToInternById(
            @PathVariable("supervisorId") Integer supervisorId,
            @PathVariable("internId") Integer internId
    ){
        supervisorService.assignSupervisorToInternById(supervisorId, internId);
    }



}
