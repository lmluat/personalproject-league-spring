package com.project.vcs.rest;

import com.project.vcs.entity.MatchDetail;
import com.project.vcs.service.MatchDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MatchDetailResource implements MatchDetailAPI{
        private final MatchDetailService matchDetailService;
    @Override
    public ResponseEntity<List<MatchDetail>> getAllMatchDetail() {
        return ResponseEntity.ok(matchDetailService.getAllMatchDetail());
    }
}
