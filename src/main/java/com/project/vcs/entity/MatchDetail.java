package com.project.vcs.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;

@Entity
@Data
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
    @Range(min = 1, max = 3)
    private int gameId;
    @ManyToOne
    @JoinColumn(name ="team_one",nullable = false)
    private TeamDetail teamOne;
    @ManyToOne
    @JoinColumn(name ="team_two",nullable = false)
    private TeamDetail teamTwo;
    @Column(name ="winning_Team")
    private String winningTeam;
    @ManyToOne
    @JoinColumn(name ="mvp_player")
    private PlayerDetail mostValuablePlayer;

    public MatchDetail(Match match, int gameId, TeamDetail teamOne, TeamDetail teamTwo) {
        this.match = match;
        this.gameId = gameId;
        this.teamOne = teamOne;
        this.teamTwo = teamTwo;
    }
}
