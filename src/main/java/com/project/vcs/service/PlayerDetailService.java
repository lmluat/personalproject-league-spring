package com.project.vcs.service;

import com.project.vcs.dto.PlayerDetailDTO;
import com.project.vcs.entity.Player;
import com.project.vcs.entity.PlayerDetail;
import com.project.vcs.entity.TeamDetail;
import com.project.vcs.repository.PlayerDetailRepository;
import com.project.vcs.repository.PlayerRepository;
import com.project.vcs.repository.TeamDetailRepository;
//import com.project.vcs.service.mapper.PlayerDetailMapper;
import com.project.vcs.service.mapper.PlayerDetailMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PlayerDetailService {
    private final PlayerDetailRepository playerDetailRepository;
    private final PlayerRepository playerRepository;
    private final TeamDetailRepository teamDetailRepository;
    public List<PlayerDetailDTO> getAllPlayerDetail(){
        return PlayerDetailMapper.INSTANCE.toDTOs(playerDetailRepository.findAll());
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
    public List<PlayerDetail> getListPlayerDetail(TeamDetail teamDetail1, TeamDetail teamDetail2){
        List<PlayerDetail> playerDetailList = playerDetailRepository.findAll().stream()
                .filter(p -> (p.getTeamDetail().getId() == teamDetail1.getId() || p.getTeamDetail().getId() == teamDetail2.getId()))
                .collect(Collectors.toList());
        return playerDetailList;
    }
}
