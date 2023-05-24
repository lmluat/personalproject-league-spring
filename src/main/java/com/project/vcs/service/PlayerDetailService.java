package com.project.vcs.service;

import com.project.vcs.dto.PlayerDetailDTO;
import com.project.vcs.entity.PlayerDetail;
import com.project.vcs.entity.TeamDetail;
import com.project.vcs.repository.PlayerDetailRepository;
import com.project.vcs.repository.PlayerRepository;
import com.project.vcs.repository.TeamDetailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlayerDetailService {
    private final PlayerDetailRepository playerDetailRepository;
    private final PlayerRepository playerRepository;
    private final TeamDetailRepository teamDetailRepository;
    public List<PlayerDetail> getAllPlay(){
        return playerDetailRepository.findAll();
    }
    public PlayerDetail createPlayerDetail(PlayerDetailDTO playerDetailDTO, Long teamDetailId){
        TeamDetail teamDetail = teamDetailRepository.findById(teamDetailId).get();

         PlayerDetail playerDetail = PlayerDetail.builder()
                 .teamDetail(teamDetail)
                 .isCaptain(playerDetailDTO.getIsCaptain())
                 .position(playerDetailDTO.getPosition())
                 .player(playerRepository.findByingameName(playerDetailDTO.getIngameName()))
                 .build();

         return playerDetailRepository.save(playerDetail);
    }
}
