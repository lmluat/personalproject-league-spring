package com.project.vcs.rest;

import com.project.vcs.dto.PlayerDetailDTO;
import com.project.vcs.entity.PlayerDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping(value = "/api/playerdetails")
public interface PlayerDetailAPI {
    @GetMapping
    ResponseEntity<List<PlayerDetailDTO>> getAllPlayerDetail();
    @PostMapping("/{teamdetailid}")
    ResponseEntity<PlayerDetailDTO> createPlayerDetail(@PathVariable("teamdetailid") Long id,
                                                    @RequestBody PlayerDetailDTO playerDetailDTO);
    @PutMapping("{playerdetailid}/{teamdetailid}/{playerid}")
    ResponseEntity<PlayerDetailDTO> updatePlayerDetail(@PathVariable("playerdetailid") Long playerDetailId,
                                                       @PathVariable("teamdetailid") Long teamDetailID,
                                                       @PathVariable("playerid") Long playerId,
                                                       @RequestBody PlayerDetailDTO playerDetailDTO);
}
