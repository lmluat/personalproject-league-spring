package com.project.vcs.rest;

import com.project.vcs.dto.CoachDTO;
import com.project.vcs.entity.Coach;
import org.springframework.http.ResponseEntity;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@PreAuthorize("hasRole('ROLE_ADMIN')")
@RequestMapping(value = "/api/coaches")
public interface CoachAPI {
    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping
    ResponseEntity<List<Coach>> getAllCoach();
    @PostMapping("/id")
    ResponseEntity<CoachDTO> createCoach(@RequestBody CoachDTO coachDTO);
    @PutMapping("/{id}")
    ResponseEntity<CoachDTO> updateCoach(@PathVariable("id") Long id,
                                         @RequestBody CoachDTO coachDTO);
}
