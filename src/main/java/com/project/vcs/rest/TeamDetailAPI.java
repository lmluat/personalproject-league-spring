package com.project.vcs.rest;

import com.project.vcs.dto.TeamDetailDTO;
import com.project.vcs.entity.TeamDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@PreAuthorize("hasAnyRole('USER','ADMIN')")
@RequestMapping(value = "/api")
public interface TeamDetailAPI {
    @GetMapping("/teamdetails")
    ResponseEntity<List<TeamDetail>> getAllTeamDetail();
    @PostMapping("/teamdetails/{tournamentid}")
    ResponseEntity<TeamDetail> createTeamDetail(@PathVariable("tournamentid") Long id, @RequestBody TeamDetailDTO teamDetailDTO);
}
