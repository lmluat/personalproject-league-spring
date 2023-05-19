package com.project.vcs.rest;

import com.project.vcs.entity.Team;
import com.project.vcs.service.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TeamResource implements TeamAPI {
    private final TeamService teamService;

    @Override
    public ResponseEntity<List<Team>> getAllTeam() {
        return ResponseEntity.ok(teamService.getAllTeam());
    }
}
