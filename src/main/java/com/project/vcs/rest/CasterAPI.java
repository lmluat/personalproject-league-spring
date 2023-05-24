package com.project.vcs.rest;

import com.project.vcs.dto.CasterDTO;
import com.project.vcs.entity.Caster;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
@PreAuthorize("hasAnyRole('USER','ADMIN')")
@RequestMapping(value = "/api")
public interface CasterAPI {
    @GetMapping("/casters")
    ResponseEntity<List<CasterDTO>> getAllCaster();
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/casters/id")
    ResponseEntity<Caster> createCaster(@RequestBody CasterDTO casterDTO);
}
