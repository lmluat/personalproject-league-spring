package com.project.vcs.entity;

import com.project.vcs.dto.TeamDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "team", uniqueConstraints = {@UniqueConstraint(columnNames = {"team_name"})})
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "team_name", nullable = false, unique = true)
    private String teamName;
    @Column(name = "location", nullable = false)
    private String location;

}
