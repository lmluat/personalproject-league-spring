package com.project.vcs.service;

import com.project.vcs.entity.TeamDetail;
import com.project.vcs.repository.TeamDetailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeamDetailService {
    private final TeamDetailRepository teamDetailRepository;
    public List<TeamDetail> getAllTeamDetail(){
        return teamDetailRepository.findAll();
    }
}
