package com.project.vcs.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "match_detail")
public class MatchDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "match_id", nullable = false)
    private Match match;
    @Column(name ="game_id", nullable = false)
    private int gameId;
    @ManyToOne
    @JoinColumn(name ="team_one", nullable = false)
    private Team teamOne;
    @ManyToOne
    @JoinColumn(name ="team_two", nullable = false)
    private Team teamTwo;
    @ManyToOne
    @JoinColumn(name ="winning_team", nullable = false)
    private Team winningTeam;
    @ManyToOne
    @JoinColumn(name ="mvp_player", nullable = false)
    private Player mostValuablePlayer;
}
