package com.project.vcs.rest;

import com.project.vcs.entity.Match;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.awt.image.RescaleOp;
import java.util.List;

@RequestMapping(value = "/api")
public interface MatchAPI {
    @GetMapping("/match")
    ResponseEntity<List<Match>> getAllMatch();
}
