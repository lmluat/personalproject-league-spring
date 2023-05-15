package com.project.vcs.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "match_schedule")
public class MatchSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "tournament_id", nullable = false)
    private Tournament tournament;
    @Column(name = "week", nullable = false)
    private int week;
    @Column(name = "time", nullable = false)
    private LocalDate time;
    @ManyToOne
    @JoinColumn(name = "team_one", nullable = false)
    private Team teamOne;
    @ManyToOne
    @JoinColumn(name = "team_two", nullable = false)
    private Team teamTwo;
}
