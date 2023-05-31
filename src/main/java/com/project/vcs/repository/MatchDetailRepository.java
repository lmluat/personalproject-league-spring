package com.project.vcs.repository;

import com.project.vcs.entity.Match;
import com.project.vcs.entity.MatchDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatchDetailRepository extends JpaRepository<MatchDetail, Long> {
    @Query(value = "SELECT * FROM vcsproject6.match_detail md WHERE md.match_id = ?1 ", nativeQuery = true)
    List<MatchDetail> findByMatchId(Long matchId);


}
