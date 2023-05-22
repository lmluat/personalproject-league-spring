package com.project.vcs.rest;

import com.project.vcs.dto.PlayerDTO;
import com.project.vcs.entity.Player;
import com.project.vcs.service.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PlayerResource implements PlayerAPI{
    private final PlayerService playerService;

    @Override
    public ResponseEntity<List<Player>> getAllPlayer() {
        return ResponseEntity.ok(playerService.getAllPlayer());
    }

    @Override
    public ResponseEntity<Player> createPlayer(PlayerDTO playerDTO) {
        return ResponseEntity.ok(playerService.createPlayer(playerDTO));
    }

    @Override
    public ResponseEntity<Void> deletePlayer(Long id) {
        playerService.deletePlayer(id);
        return ResponseEntity.noContent().build();
    }
}
