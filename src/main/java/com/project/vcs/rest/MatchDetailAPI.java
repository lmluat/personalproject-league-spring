package com.project.vcs.rest;

import com.project.vcs.entity.MatchDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping(value = "/api")
public interface MatchDetailAPI {
    @GetMapping("/matchdetail")
    ResponseEntity<List<MatchDetail>> getAllMatchDetail();
}
