package com.project.vcs.service;

import com.project.vcs.entity.MatchDetail;
import com.project.vcs.repository.MatchDetailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MatchDetailService {
    private final MatchDetailRepository matchDetailRepository;
    public List<MatchDetail> getAllMatchDetail(){
        return matchDetailRepository.findAll();
    }
}
