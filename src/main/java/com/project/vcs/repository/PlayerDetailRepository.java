package com.project.vcs.repository;

import com.project.vcs.entity.PlayerDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerDetailRepository extends JpaRepository<PlayerDetail, Long> {
    @Query(value = "SELECT COUNT(md.mvp_player) " +
            "FROM vcsproject6.player p, vcsproject6.player_detail pd, vcsproject6.match_detail md, vcsproject6.tournament t " +
            "WHERE t.tournament_name = ?2 " +
            "AND p.ingame_name = ?1 " +
            "AND p.id = pd.player_id " +
            "AND md.mvp_player = pd.id " +
            "GROUP BY md.mvp_player",
            nativeQuery = true)
    Integer getCountOfMvpPlayers(String ingameNamePlayer, String tournamentName);
    @Query(value = "SELECT player.ingameName" +
            "FROM Player p, PlayerDetail pd, TeamDetail td, Tournament t " +
            "WHERE t.tournamentName = ?1 " +
            "AND td.tournament.id = t.id " +
            "AND pd.teamDetail.id = td.id " +
            "AND p.id = pd.player.id " +
            "GROUP BY p.ingameName")
    List<String> getDistinctPlayerIngameNamesByTournament(String tournamentName);
}
