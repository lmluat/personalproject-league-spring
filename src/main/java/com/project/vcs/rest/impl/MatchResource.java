package com.project.vcs.rest.impl;

import com.project.vcs.dto.MatchDTO;
//import com.project.vcs.dto.custom.MatchCustomDTO;
import com.project.vcs.dto.custom.MatchScheduleDTO;
import com.project.vcs.dto.custom.MatchUpdateDTO;
import com.project.vcs.entity.Match;
import com.project.vcs.repository.MatchRepository;
import com.project.vcs.rest.MatchAPI;
import com.project.vcs.service.MatchDetailService;
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
    public ResponseEntity<List<MatchDTO>> getAllMatch() {
        return ResponseEntity.ok(matchService.getAllMatch());
    }

    @Override
    public ResponseEntity<MatchScheduleDTO> createMatch(Long tournamentId, Long casterId, MatchScheduleDTO matchScheduleDTO) {
        return ResponseEntity.ok(matchService.createMatch(matchScheduleDTO, tournamentId, casterId));
    }

    @Override
    public ResponseEntity<MatchDTO> updateMatch(Long tournamentId, Long matchId, Long casterId, MatchDTO matchDTO) {
        return ResponseEntity.ok(matchService.updateMatch(matchDTO, matchId, tournamentId, casterId));
    }

    @Override
    public ResponseEntity<Void> deleteMatch(long matchId) {
        matchService.deleteMatch(matchId);
        return ResponseEntity.noContent().build();
    }
}
