package com.project.vcs.rest;

import com.project.vcs.dto.MatchDetailDTO;
//import com.project.vcs.dto.custom.MatchDetailCustomDTO;
import com.project.vcs.entity.MatchDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping(value = "/api")
public interface MatchDetailAPI {
//    @GetMapping("/matchdetails")
//    ResponseEntity<List<MatchDetailCustomDTO>> getAllMatchDetail();
    @PostMapping("/matchdetails/{matchid}")
    ResponseEntity<MatchDetail> createMatchDetail(@PathVariable("matchid") Long id,
                                                  @RequestBody MatchDetailDTO matchDetailDTO);
}
