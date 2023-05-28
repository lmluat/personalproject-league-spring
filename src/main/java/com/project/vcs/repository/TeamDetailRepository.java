package com.project.vcs.repository;

import com.project.vcs.entity.Team;
import com.project.vcs.entity.TeamDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamDetailRepository extends JpaRepository<TeamDetail, Long> {
        TeamDetail findByTeam(Team team);

}
