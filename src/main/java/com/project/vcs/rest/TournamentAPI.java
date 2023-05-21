package com.project.vcs.rest;

import com.project.vcs.entity.Tournament;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping(value = "/api")
public interface TournamentAPI {
    @GetMapping("/tournament")
    ResponseEntity<List<Tournament>> getAllDepartment();


}
