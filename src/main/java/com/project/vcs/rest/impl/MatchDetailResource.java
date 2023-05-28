package com.project.vcs.rest.impl;

import com.project.vcs.dto.MatchDetailDTO;
//import com.project.vcs.dto.custom.MatchDetailCustomDTO;
import com.project.vcs.entity.MatchDetail;
import com.project.vcs.rest.MatchDetailAPI;
import com.project.vcs.service.MatchDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

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

//    @Override
//    public ResponseEntity<MatchDetailDTO> updateMatchDetail(Long matchId, int gameId, MatchDetailDTO matchDetailDTO) {
//        return ResponseEntity.ok(matchDetailService.updateMatchDetail(matchDetailDTO,matchId,gameId));
//    }
}
