package com.project.vcs.repository;

import com.project.vcs.entity.TeamDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamDetailRepository extends JpaRepository<TeamDetail, Long> {
}
