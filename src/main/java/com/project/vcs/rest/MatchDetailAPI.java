package com.project.vcs.rest;

import com.project.vcs.dto.MatchDetailDTO;
//import com.project.vcs.dto.custom.MatchDetailCustomDTO;
import com.project.vcs.dto.custom.MatchScheduleTournamentDTO;
import com.project.vcs.entity.MatchDetail;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.time.LocalDate;
import java.util.List;
@PreAuthorize("hasRole('ROLE_ADMIN')")
@RequestMapping(value = "/api/matchdetails")
public interface MatchDetailAPI {
    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping
    ResponseEntity<List<MatchDetailDTO>> getAllMatchDetail();
    @PostMapping("/{matchid}")
    ResponseEntity<MatchDetailDTO> createMatchDetail(@PathVariable("matchid") Long id,
                                                     @Valid @RequestBody MatchDetailDTO matchDetailDTO);
    @PutMapping("/{matchdetailid}")
    ResponseEntity<MatchDetailDTO> updateMatchDetail(@PathVariable("matchdetailid") Long matchDetailId,
                                                     @RequestBody MatchDetailDTO matchDetailDTO);
    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("/{tournamentid}")
    ResponseEntity<List<MatchScheduleTournamentDTO>> getMatchScheduleByTournament(@PathVariable("tournamentid") Long tournamentId);
    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("/matchschedule")
    ResponseEntity<List<MatchScheduleTournamentDTO>> getMatchScheduleFromStartDateToEndDate(@RequestParam("startdate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
                                                                                            @RequestParam("enddate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate);
}
