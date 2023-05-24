package com.project.vcs.service;

import com.project.vcs.entity.PlayerDetail;
import com.project.vcs.repository.PlayerDetailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlayerDetailService {
    private final PlayerDetailRepository playerDetailRepository;
    public List<PlayerDetail> getAllPlay(){
        return playerDetailRepository.findAll();
    }
}
