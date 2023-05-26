package com.project.vcs.service;

import com.project.vcs.dto.MatchDetailDTO;
import com.project.vcs.entity.*;
import com.project.vcs.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
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
//    public List<MatchDetailCustomDTO> getAllMatchDetail(){
//        return MatchDetailMapper.INSTANCE.toDTOs(matchDetailRepository.findAll());
//    }
    public MatchDetail findById(Long id){
        return matchDetailRepository.findById(id).get();
    }
    public MatchDetail createMatchDetail(MatchDetailDTO matchDetailDTO, Long matchId) {

        Tournament tournament = matchRepository.findById(matchId).get().getTournament();
        Player player = playerRepository.findByingameName(matchDetailDTO.getMostValuablePlayer());

        String winningTeam = null;

        TeamDetail teamOne = new TeamDetail();
        TeamDetail teamTwo = new TeamDetail();
        if (!matchDetailDTO.getTeamOne().equals(matchDetailDTO.getTeamTwo())) {
            teamOne = getTeamDetail(tournament, matchDetailDTO.getTeamOne());
            teamTwo = getTeamDetail(tournament, matchDetailDTO.getTeamTwo());
        }
        List<PlayerDetail> playerDetailList = playerDetailService.getListPlayerDetail(teamOne, teamTwo);

        PlayerDetail playerDetail = null;
        for (PlayerDetail detail : playerDetailList) {
            if (Objects.equals(player.getId(), detail.getPlayer().getId())) {
                playerDetail = detail;
            }
        }

        Match match = matchRepository.findById(matchId).get();

        if (matchDetailDTO.getWinningTeam().equals(matchDetailDTO.getTeamOne()) || matchDetailDTO.getWinningTeam().equals(matchDetailDTO.getTeamTwo())) {
            winningTeam = matchDetailDTO.getWinningTeam();
        }

        MatchDetail matchDetail = MatchDetail.builder()
                .match(match)
                .gameId(matchDetailDTO.getGameId())
                .teamOne(teamOne)
                .teamTwo(teamTwo)
                .winningTeam(winningTeam)
                .mostValuablePlayer(playerDetail)
                .build();

        matchDetailRepository.save(matchDetail);
        return matchDetail;
    }
    public TeamDetail getTeamDetail(Tournament tournament, String teamName){
        Long teamId = teamRepository.findByTeamName(teamName).getId();

        TeamDetail teamDetail = new TeamDetail();

        List<TeamDetail> teamDetailList = teamDetailRepository.findAll().stream()
                .filter(t -> t.getTournament().getTournamentName().equals(tournament.getTournamentName()))
                .collect(Collectors.toList());

        for (TeamDetail detail : teamDetailList) {
            if (detail.getTeam().getId()==teamId) {
                teamDetail = detail;
            }
        }
        return teamDetail;
    }
}
