package com.dhia.pfemanager.pfemanager.user.intern;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/intern")
@Slf4j
public class InternController {

    private final InternService internService;

    @GetMapping("/all")
    public ResponseEntity<List<InternDTO>> getAllInterns(){
        List<InternDTO> interns = internService.getAllInterns();
        return ResponseEntity.ok(interns);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<InternDTO>> getInternById(@PathVariable("id") Integer id){
        Optional<InternDTO> intern = internService.getInternById(id);
        return ResponseEntity.ok(intern);
    }

    @GetMapping("/byEnterprise/{enterpriseId}")
    public ResponseEntity<List<InternDTO>> getInternsByEnterprise(@PathVariable("enterpriseId") Integer enterpriseId){
        List<InternDTO> internsByEnterprise = internService.getInternsByEnterpriseId(enterpriseId);
        return ResponseEntity.ok(internsByEnterprise);
    }

    @GetMapping("/bySupervisor/{supervisorId}")
    public ResponseEntity<List<InternDTO>>getInternsBySupervisor(
            @PathVariable("supervisorId") Integer supervisorId
    ){
        return ResponseEntity.ok(internService.getInternsBySupervisor(
                supervisorId
        ));
    }

}
