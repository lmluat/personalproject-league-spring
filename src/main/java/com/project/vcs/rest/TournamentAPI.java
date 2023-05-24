package com.project.vcs.rest;

import com.project.vcs.dto.TournamentDTO;
import com.project.vcs.entity.Tournament;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;
@PreAuthorize("hasAnyRole('USER','ADMIN')")
@RequestMapping(value = "/api/tournaments")
public interface TournamentAPI {
    @GetMapping
    ResponseEntity<List<Tournament>> getAllTournament();
    @PostMapping("/id")
    ResponseEntity<Tournament> createTournament(@RequestBody TournamentDTO tournamentDTO);
    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteById(@PathVariable("id") Long id);

}
