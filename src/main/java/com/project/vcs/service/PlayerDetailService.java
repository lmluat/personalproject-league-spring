package com.project.vcs.service;

import com.project.vcs.dto.PlayerDetailDTO;
import com.project.vcs.entity.Player;
import com.project.vcs.entity.PlayerDetail;
import com.project.vcs.entity.TeamDetail;
import com.project.vcs.exception.DemoException;
import com.project.vcs.repository.PlayerDetailRepository;
import com.project.vcs.repository.PlayerRepository;
import com.project.vcs.repository.TeamDetailRepository;
//import com.project.vcs.service.mapper.PlayerDetailMapper;
import com.project.vcs.service.mapper.PlayerDetailMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
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
    public PlayerDetailDTO createPlayerDetail(PlayerDetailDTO playerDetailDTO, Long teamDetailId){
        TeamDetail teamDetail = teamDetailRepository.findById(teamDetailId).get();

         PlayerDetail playerDetail = PlayerDetail.builder()
                 .teamDetail(teamDetail)
                 .isCaptain(playerDetailDTO.getIsCaptain())
                 .position(playerDetailDTO.getPosition())
                 .player(playerRepository.findByingameName(playerDetailDTO.getIngameName()))
                 .build();

         playerDetailRepository.save(playerDetail);
         return PlayerDetailMapper.INSTANCE.toDTO(playerDetail);
    }
    public List<PlayerDetail> findByTeamDetail(TeamDetail teamDetail){
        List<PlayerDetail> playerDetailList = playerDetailRepository.findAll().stream()
                .filter(p -> (p.getTeamDetail().getId() == teamDetail.getId()))
                .collect(Collectors.toList());
        return playerDetailList;
    }
    public PlayerDetailDTO updatePlayerDetail(Long playerDetailId,Long teamDetailId, Long playerId, PlayerDetailDTO playerDetailDTO){
        PlayerDetail playerDetail = playerDetailRepository.findById(playerDetailId).orElseThrow(DemoException::PlayerDetailNotFound);
        Player player = playerRepository.findById(playerId).orElseThrow(DemoException::PlayerNotFound);
        TeamDetail teamDetail = teamDetailRepository.findById(teamDetailId).orElseThrow(DemoException::TeamDetailNotFound);

        if(playerDetailDTO.getPosition() != null){
            playerDetail.setPosition(playerDetail.getPosition());
        }
        if(playerDetailDTO.getPosition() != null){
            playerDetail.setIsCaptain(playerDetailDTO.getIsCaptain());
        }
        if(playerDetail.getPlayer().getId() != playerId){
            playerDetail.setPlayer(player);
        }
        if(playerDetail.getTeamDetail().getId() != teamDetailId){
            playerDetail.setTeamDetail(teamDetail);
        }
        playerDetailRepository.save(playerDetail);
        return PlayerDetailMapper.INSTANCE.toDTO(playerDetail);
    }

}
