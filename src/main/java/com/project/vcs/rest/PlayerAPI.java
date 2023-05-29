package com.project.vcs.rest;

import com.project.vcs.dto.PlayerDTO;
import com.project.vcs.entity.Player;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping(value = "/api/players")
public interface PlayerAPI {
    @GetMapping
    ResponseEntity<List<Player>> getAllPlayer();
    @PostMapping("/id")
    ResponseEntity<Player> createPlayer(@RequestBody PlayerDTO playerDTO);
    @DeleteMapping("/{id}")
    ResponseEntity<Void> deletePlayer(@PathVariable("id") Long id);
    @PutMapping("/{playerid}")
    ResponseEntity<PlayerDTO> updatePlayer(@PathVariable("playerid") Long playerId,
                                           @RequestBody PlayerDTO playerDTO);
}
