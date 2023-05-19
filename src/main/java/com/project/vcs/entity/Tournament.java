package com.project.vcs.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Year;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tournament")
public class Tournament {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "tournament_name", nullable = false)
    private String tournamentName;
    @Column(name = "year", nullable = false)
    private Year year;
    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;
    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;
    @Column(name = "season", nullable = false)
    private String season;
    @Column(name = "sponsor", nullable = false)
    private String sponsor;

}
