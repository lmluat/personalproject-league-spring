package com.project.vcs.security.repository;

import com.project.vcs.security.entity.UserRoleAssignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleAssignmentRepository extends JpaRepository<UserRoleAssignment, Integer> {
}
