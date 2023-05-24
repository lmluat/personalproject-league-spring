package com.project.vcs.rest;

import com.project.vcs.dto.PlayerDetailDTO;
import com.project.vcs.entity.PlayerDetail;
import com.project.vcs.service.PlayerDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequiredArgsConstructor
public class PlayerDetailResource implements PlayerDetailAPI {
    private final PlayerDetailService playerDetailService;
    @Override
    public ResponseEntity<List<PlayerDetail>> getAllPlayerDetail() {
        return ResponseEntity.ok(playerDetailService.getAllPlay());
    }

    @Override
    public ResponseEntity<PlayerDetail> createPlayerDetail(Long id, PlayerDetailDTO playerDetailDTO) {
        return ResponseEntity.ok(playerDetailService.createPlayerDetail(playerDetailDTO, id));
    }
}
