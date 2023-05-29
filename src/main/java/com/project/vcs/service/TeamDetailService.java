package com.project.vcs.service;

import com.project.vcs.dto.TeamDetailDTO;
//import com.project.vcs.dto.custom.TeamDetailCustomDTO;
import com.project.vcs.dto.custom.TeamDetailCustomDTO;
import com.project.vcs.dto.custom.TeamStatsDTO;
import com.project.vcs.entity.Coach;
import com.project.vcs.entity.Team;
import com.project.vcs.entity.TeamDetail;
import com.project.vcs.entity.Tournament;
import com.project.vcs.exception.DemoException;
import com.project.vcs.repository.CoachRepository;
import com.project.vcs.repository.TeamDetailRepository;
import com.project.vcs.repository.TeamRepository;
import com.project.vcs.repository.TournamentRepository;
import com.project.vcs.service.mapper.TeamDetailMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TeamDetailService {
    private final TeamDetailRepository teamDetailRepository;
    private final TeamRepository teamRepository;
    private final CoachRepository coachRepository;
    private final TournamentRepository tournamentRepository;
    public List<TeamDetailCustomDTO> getAllTeamDetail(){
        return TeamDetailMapper.INSTANCE.toCustomDTOs(teamDetailRepository.findAll());
    }
    public TeamDetail createTeamDetail(Long id, TeamDetailDTO teamDetailDTO){
        Team team = teamRepository.findByTeamName(teamDetailDTO.getTeamName()).orElseThrow(DemoException::TeamNotFound);
        Coach coach = coachRepository.findByIngameName(teamDetailDTO.getIngameNameCoach());
        String sponsor = teamDetailDTO.getSponsor();
        Optional<Tournament> tournament = tournamentRepository.findById(id);

        TeamDetail teamDetail = new TeamDetail();

        teamDetail.setTeam(team);
        teamDetail.setCoach(coach);
        teamDetail.setSponsor(sponsor);

        if(tournament.isPresent()){
            teamDetail.setTournament(tournament.get());
        }

        return teamDetailRepository.save(teamDetail);
    }
    public TeamDetail findByTeamNameAndTournament(String teamName, Tournament tournament){
        TeamDetail teamDetail = teamDetailRepository.findAll().stream()
                .filter(t -> t.getTeam().getTeamName().equals(teamName))
                .filter(t -> t.getTournament().getTournamentName().equals(tournament.getTournamentName()))
                .collect(Collectors.toList()).get(0);
        return teamDetail;
    }
    public TeamStatsDTO getWinningRateInTournament(String teamName, String tournamentName){
        Team team = teamRepository.findByTeamName(teamName).orElseThrow(DemoException::TeamNotFound);

        Tournament tournament = tournamentRepository.findBytournamentName(tournamentName).orElseThrow(DemoException::TournamentNotFound);

        int numberOfMatch = teamDetailRepository.findNumberOfMatch(teamName, tournamentName);
        double numberOfWinningMatch = teamDetailRepository.findNumberOfWinningMatch(teamName, tournamentName);
        double winningRate = numberOfWinningMatch/numberOfMatch*100;

        return new TeamStatsDTO(teamName, numberOfMatch, winningRate);
    }
    public List<TeamStatsDTO> getListTeamStats(String tournamentName){
        List<TeamStatsDTO> teamStatsDTOS = new ArrayList<>();
        List<String> teamNameList = teamDetailRepository.findAll().stream()
                .filter(t -> t.getTournament().getTournamentName().equals(tournamentName))
                .map(TeamDetail::getTeam)
                .map(Team::getTeamName)
                .collect(Collectors.toList());

        teamNameList.forEach(t -> {
            TeamStatsDTO teamStatsDTO = getWinningRateInTournament(t, tournamentName);
            teamStatsDTOS.add(teamStatsDTO);
        });
        List<TeamStatsDTO> sortedTeamStatsDTOS = teamStatsDTOS.stream()
                .sorted(Comparator.comparingDouble(TeamStatsDTO::getWinRate).reversed())
                .collect(Collectors.toList());

        return sortedTeamStatsDTOS;

    }
}
