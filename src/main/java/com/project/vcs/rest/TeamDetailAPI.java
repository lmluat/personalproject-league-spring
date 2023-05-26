package com.project.vcs.rest;

import com.project.vcs.dto.TeamDetailDTO;
//import com.project.vcs.dto.custom.TeamDetailCustomDTO;
import com.project.vcs.entity.TeamDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping(value = "/api")
public interface TeamDetailAPI {
//    @GetMapping("/teamdetails")
//    ResponseEntity<List<TeamDetailCustomDTO>> getAllTeamDetail();
    @PostMapping("/teamdetails/{tournamentid}")
    ResponseEntity<TeamDetail> createTeamDetail(@PathVariable("tournamentid") Long id, @RequestBody TeamDetailDTO teamDetailDTO);
}
