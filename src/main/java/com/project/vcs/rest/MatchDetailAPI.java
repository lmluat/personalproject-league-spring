package com.project.vcs.rest;

import com.project.vcs.dto.MatchDetailDTO;
//import com.project.vcs.dto.custom.MatchDetailCustomDTO;
import com.project.vcs.entity.MatchDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;
@RequestMapping(value = "/api/matchdetails")
public interface MatchDetailAPI {
    @GetMapping
    ResponseEntity<List<MatchDetailDTO>> getAllMatchDetail();
    @PostMapping("/{matchid}")
    ResponseEntity<MatchDetailDTO> createMatchDetail(@PathVariable("matchid") Long id,
                                                  @Valid @RequestBody MatchDetailDTO matchDetailDTO);
    @PutMapping("/{matchid}/{gameid}")
    ResponseEntity<MatchDetailDTO> updateMatchDetail(@PathVariable("matchid") Long matchId,
                                                     @PathVariable("gameid") @Min(1) @Max(3) int gameId,
                                                     @RequestBody MatchDetailDTO matchDetailDTO);
}
