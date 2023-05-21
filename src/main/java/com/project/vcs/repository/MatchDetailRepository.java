package com.project.vcs.repository;

import com.project.vcs.entity.MatchDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchDetailRepository extends JpaRepository<MatchDetail, Long> {
}
