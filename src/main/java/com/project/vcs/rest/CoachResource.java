package com.project.vcs.rest;

import com.project.vcs.entity.Coach;
import com.project.vcs.service.CoachService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CoachResource implements CoachAPI{
    private final CoachService coachService;

    @Override
    public ResponseEntity<List<Coach>> getAllCoach() {
        return ResponseEntity.ok(coachService.getAllCoach());
    }
}
