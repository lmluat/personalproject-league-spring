package com.project.vcs.rest;

import com.project.vcs.entity.Tournament;
import com.project.vcs.service.TournamentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TournamentResource implements TournamentAPI{
    private final TournamentService tournamentService;

    @Override
    public ResponseEntity<List<Tournament>> getAllDepartment() {
        return ResponseEntity.ok(tournamentService.getAllTournament());
    }
}
