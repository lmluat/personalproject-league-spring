package com.project.vcs.service;

import com.project.vcs.entity.Play;
import com.project.vcs.repository.PlayRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlayService {
    private final PlayRepository playRepository;
    public List<Play> getAllPlay(){
        return playRepository.findAll();
    }

}
