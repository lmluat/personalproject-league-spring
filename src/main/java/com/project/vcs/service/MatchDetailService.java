package com.project.vcs.service;

import com.project.vcs.dto.MatchDetailDTO;
import com.project.vcs.dto.custom.MatchScheduleTournamentDTO;
import com.project.vcs.entity.*;
import com.project.vcs.exception.DemoException;
import com.project.vcs.repository.*;
import com.project.vcs.service.mapper.MatchDetailMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class MatchDetailService {
    private final MatchDetailRepository matchDetailRepository;
    private final TeamDetailRepository teamDetailRepository;
    private final MatchRepository matchRepository;
    private final PlayerRepository playerRepository;
    private final TeamRepository teamRepository;
    private final PlayerDetailService playerDetailService;
    private final TeamDetailService teamDetailService;
    private final TournamentRepository tournamentRepository;
    public List<MatchDetailDTO> getAllMatchDetail(){
        return MatchDetailMapper.INSTANCE.toDTOs(matchDetailRepository.findAll());
    }
    public MatchDetail findById(Long id){
        return matchDetailRepository.findById(id).orElseThrow(DemoException::MatchDetailNotFound);
    }
    public MatchDetailDTO createMatchDetail(MatchDetailDTO matchDetailDTO, Long matchId) {
        if(isMatchDetailListExistedMatchIdGameId(matchId, matchDetailDTO.getGameId())){
            log.error(DemoException.MatchDetailNotFound().getMessage());
            throw DemoException.badRequest("BadRequest","MatchDetailExisted");
        }

        Tournament tournament = matchRepository.findById(matchId).orElseThrow(DemoException::TournamentNotFound).getTournament();
        Player player = playerRepository.findByingameName(matchDetailDTO.getMostValuablePlayer());
        if(player == null){
            throw DemoException.PlayerNotFound();
        }
        String winningTeam = null;
        if (matchDetailDTO.getWinningTeam().equals(matchDetailDTO.getTeamOne()) || matchDetailDTO.getWinningTeam().equals(matchDetailDTO.getTeamTwo())) {
            winningTeam = matchDetailDTO.getWinningTeam();
        }
        TeamDetail winningTeamDetail = teamDetailService.findByTeamNameAndTournament(matchDetailDTO.getWinningTeam(), tournament);
        List<PlayerDetail> playerDetailListWinningTeam = playerDetailService.findByTeamDetail(winningTeamDetail);

        PlayerDetail mostValuablePlayer = null;
        for (PlayerDetail detail : playerDetailListWinningTeam) {
            if (Objects.equals(player.getId(), detail.getPlayer().getId())) {
                mostValuablePlayer = detail;
            }
        }
        
        TeamDetail teamOne = new TeamDetail();
        TeamDetail teamTwo = new TeamDetail();
        if (!matchDetailDTO.getTeamOne().equals(matchDetailDTO.getTeamTwo())) {
            teamOne = getTeamDetail(tournament, matchDetailDTO.getTeamOne());
            teamTwo = getTeamDetail(tournament, matchDetailDTO.getTeamTwo());
        }

        Match match = matchRepository.findById(matchId).orElseThrow(DemoException::MatchNotFound);
        
        MatchDetail matchDetail = MatchDetail.builder()
                .match(match)
                .gameId(matchDetailDTO.getGameId())
                .teamOne(teamOne)
                .teamTwo(teamTwo)
                .winningTeam(winningTeam)
                .mostValuablePlayer(mostValuablePlayer)
                .build();

        matchDetailRepository.save(matchDetail);
        return MatchDetailMapper.INSTANCE.toDTO(matchDetail);
    }

    public TeamDetail getTeamDetail(Tournament tournament, String teamName){
        Team team = teamRepository.findByTeamName(teamName).orElseThrow(DemoException::TeamNotFound);
        if(team == null){
            throw DemoException.TeamNotFound();
        }
        log.error(DemoException.TeamNotFound().getMessage());

        TeamDetail teamDetail = new TeamDetail();

        List<TeamDetail> teamDetailList = teamDetailRepository.findAll().stream()
                .filter(t -> t.getTournament().getTournamentName().equals(tournament.getTournamentName()))
                .collect(Collectors.toList());

        for (TeamDetail detail : teamDetailList) {
            if (detail.getTeam().getId()==team.getId()) {
                teamDetail = detail;
            }
        }
        return teamDetail;
    }
    public MatchDetailDTO updateMatchDetail(MatchDetailDTO matchDetailDTO, Long matchDetailId){
        MatchDetail matchDetail = matchDetailRepository.findById(matchDetailId).orElseThrow(DemoException::MatchDetailNotFound);
        log.error("updateMatchDetail"+DemoException.MatchDetailNotFound().getMessage());
        TeamDetail teamOneDetail = getTeamDetail(matchDetail.getMatch().getTournament(), matchDetailDTO.getTeamOne());
        TeamDetail teamTwoDetail = getTeamDetail(matchDetail.getMatch().getTournament(), matchDetailDTO.getTeamTwo());


        Player player = playerRepository.findByingameName(matchDetailDTO.getMostValuablePlayer());
        if(player == null){
            throw DemoException.PlayerNotFound();
        }
        Tournament tournament = matchRepository.findById(matchDetail.getMatch().getId()).orElseThrow(DemoException::TournamentNotFound).getTournament();
        TeamDetail winningTeamDetail = teamDetailService.findByTeamNameAndTournament(matchDetailDTO.getWinningTeam(), tournament);
        List<PlayerDetail> playerDetailListWinningTeam = playerDetailService.findByTeamDetail(winningTeamDetail);

        PlayerDetail mostValuablePlayer = null;
        for (PlayerDetail detail : playerDetailListWinningTeam) {
            if (Objects.equals(player.getId(), detail.getPlayer().getId())) {
                mostValuablePlayer = detail;
            }
        }

        matchDetail.setTeamOne(teamOneDetail);
        matchDetail.setTeamTwo(teamTwoDetail);
        matchDetail.setWinningTeam(matchDetailDTO.getWinningTeam());
        matchDetail.setMostValuablePlayer(mostValuablePlayer);
        matchDetailRepository.save(matchDetail);

        return MatchDetailMapper.INSTANCE.toDTO(matchDetail);
    }
    public List<MatchScheduleTournamentDTO> getMatchScheduleByTournament(Long tournamentId){
        int gameId = 1;
        Tournament tournament = tournamentRepository.findById(tournamentId).orElseThrow(DemoException::TournamentNotFound);
        log.error(DemoException.TournamentNotFound().getMessage());
        List<MatchDetail> matchDetailList = matchDetailRepository.findAll().stream()
                .filter(m -> m.getMatch().getTournament().getId() == tournamentId)
                .filter(m -> m.getGameId() == gameId)
                .collect(Collectors.toList());
        return MatchDetailMapper.INSTANCE.toScheduleTournamentDTOs(matchDetailList);
    }
    public List<MatchScheduleTournamentDTO> getMatchScheduleFromStartDateToEndDate(LocalDate startDate, LocalDate endDate){
        int gameId = 1;
        List<MatchDetail> matchDetailList = matchDetailRepository.findAll().stream()
                .filter(m -> m.getGameId() == gameId)
                .filter(m -> m.getMatch().getDate().isAfter(startDate))
                .filter(m -> m.getMatch().getDate().isBefore(endDate))
                .collect(Collectors.toList());
        return MatchDetailMapper.INSTANCE.toScheduleTournamentDTOs(matchDetailList);
    }
    public boolean isMatchDetailListExistedMatchIdGameId(Long matchId, int gameId){
        List<MatchDetail> matchDetailList = matchDetailRepository.findAll().stream()
                .filter(m -> m.getMatch().getId() == matchId)
                .filter(m -> m.getGameId() == gameId)
                .collect(Collectors.toList());
        return matchDetailList.size() > 0;
    }
}
