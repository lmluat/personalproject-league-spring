package com.project.vcs.repository;

import com.project.vcs.entity.Tournament;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TournamentRepository extends JpaRepository<Tournament, Long> {
    Optional<Tournament> findBytournamentName(String tournamentName);
}
