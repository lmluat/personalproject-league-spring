package com.project.vcs.service;

import com.project.vcs.entity.Team;
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
}
