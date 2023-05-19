package com.project.vcs.rest;

import com.project.vcs.entity.Coach;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping(value = "/api")
public interface CoachAPI {
    @GetMapping("/coach")
    ResponseEntity<List<Coach>> getAllCoach();
}
