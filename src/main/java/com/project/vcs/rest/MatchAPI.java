package com.project.vcs.rest;

import com.project.vcs.dto.MatchDTO;
//import com.project.vcs.dto.custom.MatchCustomDTO;
import com.project.vcs.dto.custom.MatchScheduleDTO;
import com.project.vcs.dto.custom.MatchUpdateDTO;
import com.project.vcs.entity.Match;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import java.util.List;
@RequestMapping(value = "/api/matches")
public interface MatchAPI {
    @GetMapping
    ResponseEntity<List<MatchDTO>> getAllMatch();
    @PostMapping("/{tournamentid}/{casterid}")
    ResponseEntity<MatchScheduleDTO> createMatch(@PathVariable("tournamentid") Long tournamentId,
                                      @PathVariable("casterid") Long casterId,
                                      @RequestBody MatchScheduleDTO matchScheduleDTO);
    @PutMapping("/{tournamentid}/{matchid}/{casterid}")
    ResponseEntity<MatchDTO> updateMatch(@PathVariable("tournamentid") Long tournamentId,
                                               @PathVariable("matchid") Long matchId,
                                               @PathVariable("casterid") Long casterId,
                                               @RequestBody MatchDTO matchDTO);
    @DeleteMapping("/{matchid}")
    ResponseEntity<Void> deleteMatch(@PathVariable("matchid") long matchId);
}
