package com.project.vcs.repository;

import com.project.vcs.entity.Caster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CasterRepository extends JpaRepository<Caster, Long> {
}
