package com.project.vcs.service;

import com.project.vcs.dto.TeamDetailDTO;
//import com.project.vcs.dto.custom.TeamDetailCustomDTO;
import com.project.vcs.dto.custom.TeamDetailCustomDTO;
import com.project.vcs.entity.Coach;
import com.project.vcs.entity.Team;
import com.project.vcs.entity.TeamDetail;
import com.project.vcs.entity.Tournament;
import com.project.vcs.repository.CoachRepository;
import com.project.vcs.repository.TeamDetailRepository;
import com.project.vcs.repository.TeamRepository;
import com.project.vcs.repository.TournamentRepository;
import com.project.vcs.service.mapper.TeamDetailMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        Team team = teamRepository.findByTeamName(teamDetailDTO.getTeamName());
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
}
