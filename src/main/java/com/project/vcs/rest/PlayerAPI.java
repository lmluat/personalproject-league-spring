package com.project.vcs.rest;

import com.project.vcs.entity.Player;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping(value = "/api")
public interface PlayerAPI {
    @GetMapping
    ResponseEntity<List<Player>> getAllPlayer();
}
