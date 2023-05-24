package com.project.vcs.rest;

import com.project.vcs.dto.CoachDTO;
import com.project.vcs.entity.Coach;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
@PreAuthorize("hasAnyRole('USER','ADMIN')")
@RequestMapping(value = "/api")
public interface CoachAPI {
    @GetMapping("/coachs")
    ResponseEntity<List<Coach>> getAllCoach();
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/coachs/id")
    ResponseEntity<Coach> createCoach(@RequestBody CoachDTO coachDTO);
}
