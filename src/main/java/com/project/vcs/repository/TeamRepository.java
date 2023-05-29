package com.project.vcs.repository;

import com.project.vcs.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {
        Optional<Team> findByTeamName(String teamName);
}
