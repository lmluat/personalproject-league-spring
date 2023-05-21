package com.project.vcs.rest;

import com.project.vcs.entity.TeamDetail;
import com.project.vcs.service.TeamDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TeamDetailResource implements TeamDetailAPI{
    private final TeamDetailService teamDetailService;
    @Override
    public ResponseEntity<List<TeamDetail>> getAllTeamDetail() {
        return ResponseEntity.ok(teamDetailService.getAllTeamDetail());
    }
}
