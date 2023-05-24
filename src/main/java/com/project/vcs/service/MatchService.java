package com.project.vcs.service;

import com.project.vcs.dto.MatchDTO;
import com.project.vcs.entity.Match;
import com.project.vcs.repository.CasterRepository;
import com.project.vcs.repository.MatchRepository;
import com.project.vcs.repository.TournamentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MatchService {
    private final MatchRepository matchRepository;
    private final CasterRepository casterRepository;
    private final TournamentRepository tournamentRepository;
    public List<Match> getAllMatch(){
        return matchRepository.findAll();
    }
    public Match createMatch(MatchDTO matchDTO, Long tournamentId, Long casterId){

        Match match = Match.builder()
                .date(matchDTO.getDate())
                .caster(casterRepository.findById(casterId).get())
                .tournament(tournamentRepository.findById(tournamentId).get())
                .location(matchDTO.getLocation())
                .build();

        return matchRepository.save(match);
    }

}
