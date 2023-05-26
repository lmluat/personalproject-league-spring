package com.project.vcs.rest.impl;

import com.project.vcs.dto.TournamentDTO;
import com.project.vcs.entity.Tournament;
import com.project.vcs.rest.TournamentAPI;
import com.project.vcs.service.TournamentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TournamentResource implements TournamentAPI {
    private final TournamentService tournamentService;

    @Override
    public ResponseEntity<List<TournamentDTO>> getAllTournament() {
        return ResponseEntity.ok(tournamentService.getAllTournament());
    }

    @Override
    public ResponseEntity<Tournament> createTournament(TournamentDTO tournamentDTO) {
        return ResponseEntity.ok(tournamentService.createTournament(tournamentDTO));
    }

    @Override
    public ResponseEntity<Void> deleteById(Long id) {
        tournamentService.deleteTournament(id);
        return ResponseEntity.noContent().build();
    }
}
