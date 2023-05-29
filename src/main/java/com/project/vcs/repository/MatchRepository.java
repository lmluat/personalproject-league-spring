package com.project.vcs.repository;

import com.project.vcs.entity.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatchRepository extends JpaRepository<Match, Long> {
@Query(value = "select m.* from vcsproject6.match m join vcsproject6.tournament t on m.tournament = t.id where t.tournament_name = ?1", nativeQuery = true)
    List<Match> findByTournamentName(String tournamentName);
}

