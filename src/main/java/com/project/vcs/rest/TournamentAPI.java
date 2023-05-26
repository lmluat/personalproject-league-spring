package com.project.vcs.rest;

import com.project.vcs.dto.TournamentDTO;
import com.project.vcs.entity.Tournament;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;
@RequestMapping(value = "/api/tournaments")
public interface TournamentAPI {
    @GetMapping
    ResponseEntity<List<TournamentDTO>> getAllTournament();
    @PostMapping("/id")
    ResponseEntity<Tournament> createTournament(@RequestBody TournamentDTO tournamentDTO);
    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteById(@PathVariable("id") Long id);

}
