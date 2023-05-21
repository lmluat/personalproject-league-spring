package com.project.vcs.rest;

import com.project.vcs.entity.Play;
import com.project.vcs.service.PlayService;
import com.project.vcs.service.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequiredArgsConstructor
public class PlayResource implements PlayAPI{
    private final PlayService playService;
    @Override
    public ResponseEntity<List<Play>> getAllPlay() {
        return ResponseEntity.ok(playService.getAllPlay());
    }
}
