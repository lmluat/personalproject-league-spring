package com.project.vcs.rest;

import com.project.vcs.entity.Play;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping(value = "/api")
public interface PlayAPI {
    @GetMapping("/play")
    ResponseEntity<List<Play>> getAllPlay();
}
