package com.project.vcs.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
//@NamedQuery(name = "Airplane.findByModel", query =" select a from Airplane a where a.model = ?1")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "coach")
public class MatchDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "match_schedule", nullable = false)
    private MatchSchedule matchSchedule;
    @ManyToOne
    @JoinColumn(name = "winning_team", nullable = false)
    private Team team;
    @ManyToOne
    @JoinColumn(name = "mvp_player", nullable = false)
    private Player MVPPlayer;
    @ManyToOne
    @JoinColumn(name = "caster", nullable = false)
    private Caster caster;
}
