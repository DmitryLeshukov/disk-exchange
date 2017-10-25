package com.leshukov.disk.controller.rest;

import com.leshukov.disk.dto.DiskDto;
import com.leshukov.disk.service.DiskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author dleshukov@alvioneurope.ru
 */
@RestController
@RequestMapping("/api/disk")
public class DiskRestController {

    @Autowired
    private DiskService diskService;

    @GetMapping("/free")
    public List<DiskDto> findAllFreeDisks() {
        return diskService.findAllFreeDisks();
    }

    @GetMapping("/hold/me")
    public List<DiskDto> findAllHoldByMeDisks(Principal principal) {
        return diskService.findAllHoldByMeDisks(principal.getName());
    }

    @GetMapping("/hold/other")
    public List<DiskDto> findAllHoldByOthersDisks(Principal principal) {
        return diskService.findAllHoldByOthersDisks(principal.getName());
    }

    @GetMapping("/pick/{diskId}")
    public void pickDisk(@PathVariable Long diskId, Principal principal) {
        diskService.pickDisk(diskId, principal.getName());
    }

    @GetMapping("/return/{diskId}")
    public void returnDisk(@PathVariable Long diskId, Principal principal){
        diskService.returnDisk(diskId, principal.getName());
    }

    @PostMapping
    public ResponseEntity createDisk(@Valid @RequestBody DiskDto diskDto, Errors errors, Principal principal) {
        if(errors.hasErrors()){
            List<String> errorsList = errors.getAllErrors().stream().map(error -> error.getDefaultMessage()).collect(Collectors.toList());
            return ResponseEntity.badRequest().body(errorsList);
        }
        return ResponseEntity.ok().body(diskService.create(diskDto, principal.getName()));
    }
}
