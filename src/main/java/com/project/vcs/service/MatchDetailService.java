package com.project.vcs.service;

import com.project.vcs.dto.MatchDetailDTO;
import com.project.vcs.entity.*;
import com.project.vcs.exception.DemoException;
import com.project.vcs.repository.*;
import com.project.vcs.service.mapper.MatchDetailMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MatchDetailService {
    private final MatchDetailRepository matchDetailRepository;
    private final TeamDetailRepository teamDetailRepository;
    private final MatchRepository matchRepository;
    private final PlayerRepository playerRepository;
    private final TeamRepository teamRepository;
    private final PlayerDetailService playerDetailService;
    private final TeamDetailService teamDetailService;
    public List<MatchDetailDTO> getAllMatchDetail(){
        return MatchDetailMapper.INSTANCE.toDTOs(matchDetailRepository.findAll());
    }
    public MatchDetail findById(Long id){
        return matchDetailRepository.findById(id).orElseThrow(DemoException::MatchDetailNotFound);
    }
    public MatchDetailDTO createMatchDetail(MatchDetailDTO matchDetailDTO, Long matchId) {

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

        Match match = matchRepository.findById(matchId).get();
        
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
        Team team = teamRepository.findByTeamName(teamName);
        if(team == null){
            throw DemoException.TeamNotFound();
        }

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
    public MatchDetailDTO updateMatchDetail(MatchDetailDTO matchDetailDTO, Long matchId, int gameId){
        List<MatchDetail> matchDetails = matchDetailRepository.findByMatchId(matchId);
        if(matchDetails == null){
            throw DemoException.MatchDetailNotFound();
        }
        MatchDetail matchDetail = matchDetails.stream()
                .filter(m -> m.getGameId() == gameId)
                .findFirst().orElseThrow(DemoException::MatchDetailNotFound);

        TeamDetail teamOneDetail = getTeamDetail(matchDetail.getMatch().getTournament(), matchDetailDTO.getTeamOne());
        TeamDetail teamTwoDetail = getTeamDetail(matchDetail.getMatch().getTournament(), matchDetailDTO.getTeamTwo());

        Player player = playerRepository.findByingameName(matchDetailDTO.getMostValuablePlayer());
        if(player == null){
            throw DemoException.PlayerNotFound();
        }
        Tournament tournament = matchRepository.findById(matchId).orElseThrow(DemoException::TournamentNotFound).getTournament();
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
}
