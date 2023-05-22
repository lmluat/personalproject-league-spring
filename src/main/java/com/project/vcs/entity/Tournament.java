package com.project.vcs.entity;

import com.project.vcs.dto.TournamentDTO;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.time.Year;
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tournament", uniqueConstraints = {@UniqueConstraint(columnNames = {"tournament_name"})})
public class Tournament {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "tournament_name", nullable = false)
    @NotEmpty
    private String tournamentName;
    @Column(name = "year", nullable = false)
    private String year;
    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;
    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;
    @Column(name = "season", nullable = false)
    private String season;
    @Column(name = "sponsor")
    private String sponsor;

}
