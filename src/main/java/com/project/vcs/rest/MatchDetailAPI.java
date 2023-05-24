package com.project.vcs.rest;

import com.project.vcs.entity.MatchDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
@PreAuthorize("hasAnyRole('USER','ADMIN')")
@RequestMapping(value = "/api")
public interface MatchDetailAPI {
    @GetMapping("/matchdetails")
    ResponseEntity<List<MatchDetail>> getAllMatchDetail();
}
