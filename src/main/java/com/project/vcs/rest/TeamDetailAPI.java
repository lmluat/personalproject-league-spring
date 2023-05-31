package com.project.vcs.rest;

import com.project.vcs.dto.TeamDetailDTO;
//import com.project.vcs.dto.custom.TeamDetailCustomDTO;
import com.project.vcs.dto.custom.TeamDetailCustomDTO;
import com.project.vcs.dto.custom.TeamStatsDTO;
import com.project.vcs.entity.TeamDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@PreAuthorize("hasRole('ROLE_ADMIN')")
@RequestMapping(value = "/api/teamdetails")
public interface TeamDetailAPI {
    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping
    ResponseEntity<List<TeamDetailCustomDTO>> getAllTeamDetail();
    @PostMapping("/{tournamentid}")
    ResponseEntity<TeamDetail> createTeamDetail(@PathVariable("tournamentid") Long id, @RequestBody TeamDetailDTO teamDetailDTO);
    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("/team/teamstats")
    ResponseEntity<TeamStatsDTO> getWinningRateInTournament(@RequestParam("teamname") String teamName,
                                                            @RequestParam("tournamentname") String tournamentName);
    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("/teamstats")
    ResponseEntity<List<TeamStatsDTO>> getListTeamStats(@RequestParam("tournamentname") String tournamentName);
}
