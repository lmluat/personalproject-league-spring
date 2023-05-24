package com.project.vcs.rest;

import com.project.vcs.entity.Match;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.awt.image.RescaleOp;
import java.util.List;
@PreAuthorize("hasAnyRole('USER','ADMIN')")
@RequestMapping(value = "/api")
public interface MatchAPI {
    @GetMapping("/matchs")
    ResponseEntity<List<Match>> getAllMatch();
}
