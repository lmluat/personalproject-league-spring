package com.project.vcs.rest;

import com.project.vcs.dto.TeamDTO;
import com.project.vcs.entity.Team;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
@RequestMapping(value = "/api")
public interface TeamAPI {
    @GetMapping("/teams")
    ResponseEntity<List<Team>> getAllTeam();
    @PostMapping("/teams/id")
    ResponseEntity<Team> createTeam(@RequestBody TeamDTO teamDTO);
}
