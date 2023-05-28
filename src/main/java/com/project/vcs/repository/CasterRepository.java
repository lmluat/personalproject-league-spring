package com.project.vcs.repository;

import com.project.vcs.entity.Caster;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CasterRepository extends JpaRepository<Caster, Long> {
    public Optional<Caster> findById(Long id);

}
