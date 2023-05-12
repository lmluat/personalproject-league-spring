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
@Table(name = "player_history")
public class PlayerHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "player_id", nullable = false)
    private Player player;
    @OneToOne
    @JoinColumn(name = "team_id", nullable = false)
    private Team team;
    @OneToOne
    @JoinColumn(name = "tournament_id", nullable = false)
    private Tournament tournament;
}
