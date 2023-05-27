package com.project.vcs.rest.impl;

import com.project.vcs.dto.CoachDTO;
import com.project.vcs.entity.Coach;
import com.project.vcs.rest.CoachAPI;
import com.project.vcs.service.CoachService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CoachResource implements CoachAPI {
    private final CoachService coachService;

    @Override
    public ResponseEntity<List<Coach>> getAllCoach() {
        return ResponseEntity.ok(coachService.getAllCoach());
    }

    @Override
    public ResponseEntity<CoachDTO> createCoach(CoachDTO coachDTO) {
        return ResponseEntity.ok(coachService.createCoach(coachDTO));
    }

    @Override
    public ResponseEntity<CoachDTO> updateCoach(Long id, CoachDTO coachDTO) {
        return ResponseEntity.ok(coachService.updateCoach(coachDTO, id));
    }
}
