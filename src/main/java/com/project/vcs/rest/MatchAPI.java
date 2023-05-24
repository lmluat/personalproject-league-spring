package com.project.vcs.rest;

import com.project.vcs.dto.MatchDTO;
import com.project.vcs.entity.Match;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@PreAuthorize("hasAnyRole('USER','ADMIN')")
@RequestMapping(value = "/api")
public interface MatchAPI {
    @GetMapping("/matchs")
    ResponseEntity<List<Match>> getAllMatch();
    @PostMapping("/matchs/{tournamentid}/{casterid}")
    ResponseEntity<Match> createMatch(@PathVariable("tournamentid") Long tournamentId,
                                      @PathVariable("casterid") Long casterId,
                                      @RequestBody MatchDTO matchDTO);
}
