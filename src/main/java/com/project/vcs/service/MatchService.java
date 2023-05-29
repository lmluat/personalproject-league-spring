package com.project.vcs.service;

import com.project.vcs.dto.MatchDTO;
//import com.project.vcs.dto.custom.MatchCustomDTO;
//import com.project.vcs.dto.custom.MatchDetailCustomDTO;
//import com.project.vcs.dto.custom.MatchScheduleDTO;
import com.project.vcs.dto.MatchDetailDTO;
import com.project.vcs.dto.custom.MatchScheduleDTO;
import com.project.vcs.dto.custom.MatchUpdateDTO;
import com.project.vcs.entity.*;
import com.project.vcs.exception.DemoException;
import com.project.vcs.repository.*;
//import com.project.vcs.service.mapper.MatchMapper;
import com.project.vcs.service.mapper.MatchMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MatchService {
    private final MatchRepository matchRepository;
    private final CasterRepository casterRepository;
    private final TournamentRepository tournamentRepository;
    private final TeamRepository teamRepository;
    private final TeamDetailRepository teamDetailRepository;
    private final MatchDetailRepository matchDetailRepository;

    public List<MatchDTO> getAllMatch(){
        return MatchMapper.INSTANCE.toDTOs(matchRepository.findAll());
    }
    public MatchScheduleDTO createMatch(MatchScheduleDTO matchScheduleDTO, Long tournamentId, Long casterId) {
        Tournament tournament = tournamentRepository.findById(tournamentId).get();
        Caster caster = casterRepository.findById(casterId).get();
        int gameId = 1;

        Team teamOne = teamRepository.findByTeamName(matchScheduleDTO.getTeamOne());
        Team teamTwo = teamRepository.findByTeamName(matchScheduleDTO.getTeamTwo());

        TeamDetail teamOneDetail = teamDetailRepository.findByTeam(teamOne);
        TeamDetail teamTwoDetail = teamDetailRepository.findByTeam(teamTwo);

        Match match = Match.builder()
                .date(matchScheduleDTO.getDate())
                .location(matchScheduleDTO.getLocation())
                .tournament(tournament)
                .caster(caster)
                .build();

        MatchDetail matchDetail = new MatchDetail(match, gameId, teamOneDetail, teamTwoDetail);
        List<MatchDetail> matchDetailList = new ArrayList<>();
        matchDetailList.add(matchDetail);

        match.setMatchDetailList(matchDetailList);

        matchRepository.save(match);
        return matchScheduleDTO;
    }
    public MatchDTO updateMatch(MatchDTO matchDTO, Long matchId, Long casterId, Long tournamentId){
        Match match = matchRepository.findById(matchId).orElseThrow(DemoException::MatchNotFound);
        Caster caster = casterRepository.findById(casterId).orElseThrow(DemoException::CasterNotFound);
        Tournament tournament = tournamentRepository.findById(tournamentId).orElseThrow(DemoException::TournamentNotFound);

        if (matchDTO.getDate() != null) {
            match.setDate(matchDTO.getDate());
        }
        if (matchDTO.getLocation() != null) {
            match.setLocation(matchDTO.getLocation());
        }

        match.setCaster(caster);
        match.setTournament(tournament);
        matchRepository.save(match);

        return MatchMapper.INSTANCE.toDTO(match);
    }
    public void deleteMatch(Long matchId){
        Match match = matchRepository.findById(matchId).orElseThrow(DemoException::MatchNotFound);
        matchRepository.delete(match);
    }
}
