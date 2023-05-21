package com.project.vcs.service;

import com.project.vcs.entity.Tournament;
import com.project.vcs.repository.TournamentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TournamentService {
    private final TournamentRepository tournamentRepository;

    public List<Tournament> getAllTournament(){
        return tournamentRepository.findAll();
    }
}
