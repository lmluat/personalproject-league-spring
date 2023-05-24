package com.project.vcs.rest;

import com.project.vcs.dto.MatchDetailDTO;
import com.project.vcs.entity.MatchDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@PreAuthorize("hasAnyRole('USER','ADMIN')")
@RequestMapping(value = "/api")
public interface MatchDetailAPI {
    @GetMapping("/matchdetails")
    ResponseEntity<List<MatchDetail>> getAllMatchDetail();
    @PostMapping("/matchdetails/{matchid}")
    ResponseEntity<MatchDetail> createMatchDetail(@PathVariable("matchid") Long id,
                                                  @RequestBody MatchDetailDTO matchDetailDTO);
}
