package com.project.vcs.service;

import com.project.vcs.entity.Match;
import com.project.vcs.repository.MatchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MatchService {
    private final MatchRepository matchRepository;
    public List<Match> getAllMatch(){
        return matchRepository.findAll();
    }
}
