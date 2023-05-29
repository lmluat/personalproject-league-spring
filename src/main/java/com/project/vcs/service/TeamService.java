package com.project.vcs.service;

import com.project.vcs.dto.TeamDTO;
import com.project.vcs.entity.Team;
import com.project.vcs.exception.DemoException;
import com.project.vcs.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeamService {
    private final TeamRepository teamRepository;
    public List<Team> getAllTeam(){
        return teamRepository.findAll();
    }
    public Team createTeam(TeamDTO teamDTO){
        Team team = Team.builder()
                .teamName(teamDTO.getTeamName())
                .location(teamDTO.getLocation())
                .build();
        return teamRepository.save(team);
    }
    public Team findByTeamName(String name){
        return teamRepository.findByTeamName(name).orElseThrow(DemoException::TeamNotFound);
    }
}
