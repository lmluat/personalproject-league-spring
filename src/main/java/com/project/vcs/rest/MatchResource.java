package com.project.vcs.rest;

import com.project.vcs.dto.MatchDTO;
import com.project.vcs.entity.Match;
import com.project.vcs.repository.MatchRepository;
import com.project.vcs.service.MatchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MatchResource implements MatchAPI {
    private final MatchService matchService;

    @Override
    public ResponseEntity<List<Match>> getAllMatch() {
        return ResponseEntity.ok(matchService.getAllMatch());
    }

    @Override
    public ResponseEntity<Match> createMatch(Long tournamentId, Long casterId, MatchDTO matchDTO) {
        return ResponseEntity.ok(matchService.createMatch(matchDTO, tournamentId, casterId));
    }
}
