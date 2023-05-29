package com.project.vcs.repository;

import com.project.vcs.entity.PlayerDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerDetailRepository extends JpaRepository<PlayerDetail, Long> {
    @Query(value = "SELECT COUNT(md.mvp_player) " +
            "FROM vcsproject6.player p " +
            "JOIN vcsproject6.player_detail pd ON p.id = pd.player_id " +
            "JOIN vcsproject6.match_detail md ON md.mvp_player = pd.id " +
            "JOIN vcsproject6.tournament t ON t.id = md.tournament_id " +
            "WHERE t.tournament_name = ?2 " +
            "AND p.ingame_name = ?1 " +
            "GROUP BY md.mvp_player",
            nativeQuery = true)
    Integer getCountOfMVPPlayers(String ingameNamePlayer, String tournamentName);


}
