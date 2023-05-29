package com.project.vcs.service;

import com.project.vcs.dto.MatchDTO;
import com.project.vcs.dto.custom.MatchInformationDTO;
import com.project.vcs.entity.*;
import com.project.vcs.exception.DemoException;
import com.project.vcs.repository.*;
import com.project.vcs.service.mapper.MatchMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
    public MatchInformationDTO createMatch(MatchInformationDTO matchInformationDTO, Long tournamentId, Long casterId) {
        Tournament tournament = tournamentRepository.findById(tournamentId).orElseThrow(DemoException::TournamentNotFound);
        Caster caster = casterRepository.findById(casterId).orElseThrow(DemoException::CasterNotFound);
        int gameId = 1;

        Team teamOne = teamRepository.findByTeamName(matchInformationDTO.getTeamOne());
        Team teamTwo = teamRepository.findByTeamName(matchInformationDTO.getTeamTwo());

        TeamDetail teamOneDetail = teamDetailRepository.findByTeam(teamOne);
        TeamDetail teamTwoDetail = teamDetailRepository.findByTeam(teamTwo);
        if (isMatchIdGameIdExistingOnSameDay(teamOneDetail, teamTwoDetail, tournament, matchInformationDTO.getDate())) {
            throw DemoException.internalServerError("BadRequest", "MatchExisted");
        }

        Match match = Match.builder()
                .date(matchInformationDTO.getDate())
                .location(matchInformationDTO.getLocation())
                .tournament(tournament)
                .caster(caster)
                .build();

        MatchDetail matchDetail = new MatchDetail(match, gameId, teamOneDetail, teamTwoDetail);
        List<MatchDetail> matchDetailList = new ArrayList<>();
        matchDetailList.add(matchDetail);

        match.setMatchDetailList(matchDetailList);

        matchRepository.save(match);
        return matchInformationDTO;
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
    public boolean isMatchIdGameIdExistingOnSameDay(TeamDetail teamOneDetail, TeamDetail teamTwoDetail, Tournament tournament, LocalDate date) {
        List<Match> matchList = matchRepository.findAll().stream()
                .filter(m -> m.getTournament().getId() == tournament.getId())
                .filter(m -> m.getDate().isEqual(date))
                .filter(m -> m.getMatchDetailList().stream()
                        .anyMatch(md -> md.getTeamOne().equals(teamOneDetail))
                        && m.getMatchDetailList().stream()
                        .anyMatch(md -> md.getTeamTwo().equals(teamTwoDetail)))
                .collect(Collectors.toList());
        return !matchList.isEmpty();
    }


}
