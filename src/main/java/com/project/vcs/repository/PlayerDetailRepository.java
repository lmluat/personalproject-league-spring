package com.project.vcs.repository;

import com.project.vcs.entity.PlayerDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerDetailRepository extends JpaRepository<PlayerDetail, Long> {
}
