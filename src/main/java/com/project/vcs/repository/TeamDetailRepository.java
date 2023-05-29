package com.project.vcs.repository;

import com.project.vcs.dto.custom.TeamStatsDTO;
import com.project.vcs.entity.Team;
import com.project.vcs.entity.TeamDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import java.util.List;

@Repository
public interface TeamDetailRepository extends JpaRepository<TeamDetail, Long> {
        TeamDetail findByTeam(Team team);
//        @Query(value = "SELECT t.team_name, COUNT(md.match_id), " +
//                        "COUNT(md.winning_team) * 100.0 / COUNT(md.match_id) AS win_percentage " +
//                        "FROM vcsproject6.team t " +
//                        "JOIN vcsproject6.team_detail td ON t.id = td.team_id " +
//                        "JOIN vcsproject6.match_detail md ON (md.team_one = td.id OR md.team_two = td.id) " +
//                        "JOIN vcsproject6.tournament t2 ON t2.tournament_name = ?2 " +
//                        "JOIN vcsproject6.match m ON m.id = md.match_id " +
//                        "WHERE t.team_name = ?1 AND m.tournament = t2.id " +
//                        "GROUP BY t.team_name", nativeQuery = true)
//        String getTeamStats(String teamName, String tournamentName);
        @Query(value = "SELECT COUNT(md.match_id) " +
                "FROM vcsproject6.team t " +
                "JOIN vcsproject6.team_detail td ON t.id = td.team_id " +
                "JOIN vcsproject6.match_detail md ON (md.team_one = td.id OR md.team_two = td.id) " +
                "JOIN vcsproject6.tournament t2 ON t2.tournament_name = ?2 " +
                "JOIN vcsproject6.match m ON m.id = md.match_id " +
                "WHERE t.team_name = ?1 AND m.tournament = t2.id " +
                "GROUP BY t.team_name", nativeQuery = true)
        int findNumberOfMatch(String teamName, String tournamentName);
        @Query(value = "SELECT COUNT(md.winning_team) " +
                "FROM vcsproject6.team t " +
                "JOIN vcsproject6.team_detail td ON t.id = td.team_id " +
                "JOIN vcsproject6.match_detail md ON (md.team_one = td.id OR md.team_two = td.id) " +
                "JOIN vcsproject6.tournament t2 ON t2.tournament_name = ?2 " +
                "JOIN vcsproject6.match m ON m.id = md.match_id " +
                "WHERE t.team_name = ?1 AND m.tournament = t2.id " +
                "GROUP BY t.team_name", nativeQuery = true)
        int findNumberOfWinningMatch(String teamName, String tournamentName);
        @Query(value = "SELECT COUNT(td.id), t.tournament_name " +
                "FROM vcsproject6.tournament t " +
                "JOIN vcsproject6.team_detail td ON t.id = td.tournament_id " +
                "where t.tournament_name = ?1 " +
                "GROUP BY t.tournament_name", nativeQuery = true)
        Integer getTeamCountPerTournament(String tournamentName);

}
