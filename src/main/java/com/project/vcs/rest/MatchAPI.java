package com.project.vcs.rest;

import com.project.vcs.dto.MatchDTO;
//import com.project.vcs.dto.custom.MatchCustomDTO;
import com.project.vcs.dto.custom.MatchScheduleDTO;
import com.project.vcs.entity.Match;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import java.util.List;
@RequestMapping(value = "/api")
public interface MatchAPI {
    @GetMapping("/matches")
    ResponseEntity<List<MatchDTO>> getAllMatch();
    @PostMapping("/matches/{tournamentid}/{casterid}")
    ResponseEntity<MatchScheduleDTO> createMatch(@PathVariable("tournamentid") Long tournamentId,
                                      @PathVariable("casterid") Long casterId,
                                      @RequestBody MatchScheduleDTO matchScheduleDTO);
}
