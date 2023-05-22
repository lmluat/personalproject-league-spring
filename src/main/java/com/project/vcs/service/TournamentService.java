package com.project.vcs.service;

import com.project.vcs.dto.TournamentDTO;
import com.project.vcs.entity.Tournament;
import com.project.vcs.repository.TournamentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TournamentService {
    private final TournamentRepository tournamentRepository;

    public List<Tournament> getAllTournament(){
        return tournamentRepository.findAll();
    }
    public Tournament createTournament(TournamentDTO tournamentDTO){
       Tournament tournament = Tournament.builder()
               .tournamentName(tournamentDTO.getTournamentName())
               .year(tournamentDTO.getYear())
               .startDate(tournamentDTO.getStartDate())
               .endDate(tournamentDTO.getEndDate())
               .sponsor(tournamentDTO.getSponsor())
               .build();

       return tournamentRepository.save(tournament);
    }
    public void deleteTournament(Long id){
        tournamentRepository.deleteById(id);
    }

 }
