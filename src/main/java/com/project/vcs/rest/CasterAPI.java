package com.project.vcs.rest;

import com.project.vcs.dto.CasterDTO;
import com.project.vcs.entity.Caster;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@PreAuthorize("hasRole('ROLE_ADMIN')")
@RequestMapping(value = "/api")
public interface CasterAPI {
    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("/casters")
    ResponseEntity<List<CasterDTO>> getAllCaster();
    @PostMapping("/casters/id")
    ResponseEntity<Caster> createCaster(@RequestBody CasterDTO casterDTO);
    @PutMapping("/casters/{id}")
    ResponseEntity<CasterDTO> updateCaster(@PathVariable("id") Long casterId,
                                           @RequestBody CasterDTO casterDTO);
    @DeleteMapping("/casters/{id}")
    ResponseEntity<Void> deleteCaster(@PathVariable("id") Long id);
}
