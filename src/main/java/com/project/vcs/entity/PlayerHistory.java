package com.project.vcs.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "player_history")
public class PlayerHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "player", nullable = false)
    private Player player;
    @ManyToOne
    @JoinColumn(name = "team", nullable = false)
    private Team team;
    @ManyToOne
    @JoinColumn(name = "tournament", nullable = false)
    private Tournament tournament;
}
