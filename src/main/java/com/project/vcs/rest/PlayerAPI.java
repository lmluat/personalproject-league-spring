package com.project.vcs.rest;

import com.project.vcs.dto.PlayerDTO;
import com.project.vcs.entity.Player;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/api")
public interface PlayerAPI {
    @GetMapping("/players")
    ResponseEntity<List<Player>> getAllPlayer();
    @PostMapping("/players/id")
    ResponseEntity<Player> createPlayer(@RequestBody PlayerDTO playerDTO);
    @DeleteMapping("/players/{id}")
    ResponseEntity<Void> deletePlayer(@PathVariable("id") Long id);
}
