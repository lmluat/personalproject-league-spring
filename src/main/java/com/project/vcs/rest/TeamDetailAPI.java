package com.project.vcs.rest;

import com.project.vcs.dto.TeamDetailDTO;
//import com.project.vcs.dto.custom.TeamDetailCustomDTO;
import com.project.vcs.dto.custom.TeamDetailCustomDTO;
import com.project.vcs.dto.custom.TeamStatsDTO;
import com.project.vcs.entity.TeamDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping(value = "/api/teamdetails")
public interface TeamDetailAPI {
    @GetMapping
    ResponseEntity<List<TeamDetailCustomDTO>> getAllTeamDetail();
    @PostMapping("/{tournamentid}")
    ResponseEntity<TeamDetail> createTeamDetail(@PathVariable("tournamentid") Long id, @RequestBody TeamDetailDTO teamDetailDTO);
    @GetMapping("/team/teamstats")
    ResponseEntity<TeamStatsDTO> getWinningRateInTournament(@RequestParam("teamname") String teamName,
                                                            @RequestParam("tournamentname") String tournamentName);
    @GetMapping("/teamstats")
    ResponseEntity<List<TeamStatsDTO>> getListTeamStats(@RequestParam("tournamentname") String tournamentName);
}
