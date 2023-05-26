package com.project.vcs.rest.impl;

import com.project.vcs.dto.TeamDetailDTO;
//import com.project.vcs.dto.custom.TeamDetailCustomDTO;
import com.project.vcs.dto.custom.TeamDetailCustomDTO;
import com.project.vcs.entity.TeamDetail;
import com.project.vcs.rest.TeamDetailAPI;
import com.project.vcs.service.TeamDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TeamDetailResource implements TeamDetailAPI {
    private final TeamDetailService teamDetailService;
    @Override
    public ResponseEntity<List<TeamDetailCustomDTO>> getAllTeamDetail() {
        return ResponseEntity.ok(teamDetailService.getAllTeamDetail());
    }

    @Override
    public ResponseEntity<TeamDetail> createTeamDetail(Long id,TeamDetailDTO teamDetailDTO) {
        return ResponseEntity.ok(teamDetailService.createTeamDetail(id,teamDetailDTO));
    }

}
