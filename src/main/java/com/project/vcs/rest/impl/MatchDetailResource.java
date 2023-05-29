package com.project.vcs.rest.impl;

import com.project.vcs.dto.MatchDetailDTO;
//import com.project.vcs.dto.custom.MatchDetailCustomDTO;
import com.project.vcs.dto.custom.MatchScheduleTournamentDTO;
import com.project.vcs.rest.MatchDetailAPI;
import com.project.vcs.service.MatchDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class MatchDetailResource implements MatchDetailAPI {
        private final MatchDetailService matchDetailService;
    @Override
    public ResponseEntity<List<MatchDetailDTO>> getAllMatchDetail() {
        return ResponseEntity.ok(matchDetailService.getAllMatchDetail());
    }

    @Override
    public ResponseEntity<MatchDetailDTO> createMatchDetail(Long id, MatchDetailDTO matchDetailDTO) {
        return ResponseEntity.ok(matchDetailService.createMatchDetail(matchDetailDTO, id));
    }

    @Override
    public ResponseEntity<MatchDetailDTO> updateMatchDetail(Long matchDetailId, MatchDetailDTO matchDetailDTO) {
        return ResponseEntity.ok(matchDetailService.updateMatchDetail(matchDetailDTO,matchDetailId));
    }

    @Override
    public ResponseEntity<List<MatchScheduleTournamentDTO>> getMatchScheduleByTournament(Long tournamentId) {
        return ResponseEntity.ok(matchDetailService.getMatchScheduleByTournament(tournamentId));
    }

    @Override
    public ResponseEntity<List<MatchScheduleTournamentDTO>> getMatchScheduleFromStartDateToEndDate(LocalDate startDate, LocalDate endDate) {
        return ResponseEntity.ok(matchDetailService.getMatchScheduleFromStartDateToEndDate(startDate,endDate));
    }
}
