package com.project.vcs.rest;

import com.project.vcs.dto.PlayerDetailDTO;
import com.project.vcs.entity.PlayerDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping(value = "/api")
public interface PlayerDetailAPI {
    @GetMapping("/playerdetails")
    ResponseEntity<List<PlayerDetailDTO>> getAllPlayerDetail();
    @PostMapping("/playerdetails/{teamdetailid}")
    ResponseEntity<PlayerDetail> createPlayerDetail(@PathVariable("teamdetailid") Long id,
                                                    @RequestBody PlayerDetailDTO playerDetailDTO);
}
