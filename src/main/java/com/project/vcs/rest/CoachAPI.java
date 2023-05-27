package com.project.vcs.rest;

import com.project.vcs.dto.CoachDTO;
import com.project.vcs.entity.Coach;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/api/coaches")
public interface CoachAPI {
    @GetMapping
    ResponseEntity<List<Coach>> getAllCoach();
    @PostMapping("/id")
    ResponseEntity<CoachDTO> createCoach(@RequestBody CoachDTO coachDTO);
    @PutMapping("/{id}")
    ResponseEntity<CoachDTO> updateCoach(@PathVariable("id") Long id,
                                         @RequestBody CoachDTO coachDTO);
}
