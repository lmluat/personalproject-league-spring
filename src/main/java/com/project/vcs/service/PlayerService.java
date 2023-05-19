package com.project.vcs.service;

import com.project.vcs.entity.Player;
import com.project.vcs.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlayerService {
    private final PlayerRepository playerRepository;
    public List<Player> getAllPlayer(){
        return playerRepository.findAll();
    }
}
