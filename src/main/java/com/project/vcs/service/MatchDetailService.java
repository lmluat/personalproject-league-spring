package com.project.vcs.service;

import com.project.vcs.dto.MatchDetailDTO;
import com.project.vcs.entity.MatchDetail;
import com.project.vcs.entity.Player;
import com.project.vcs.entity.Team;
import com.project.vcs.repository.MatchDetailRepository;
import com.project.vcs.repository.PlayerRepository;
import com.project.vcs.repository.TeamDetailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MatchDetailService {
    private final MatchDetailRepository matchDetailRepository;
    private final TeamDetailRepository teamDetailRepository;
    private final PlayerRepository playerRepository;
    public List<MatchDetail> getAllMatchDetail(){
        return matchDetailRepository.findAll();
    }
    public void createMatchDetail(MatchDetailDTO matchDetailDTO){

        Player player = playerRepository.findByIngameName(matchDetailDTO.getMostValuablePlayer());


    }
}
