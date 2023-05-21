package com.project.vcs.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.time.LocalDate;
import java.time.Year;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TournamentDTO {

    private String tournamentName;

    private Year year;

    private LocalDate startDate;

    private LocalDate endDate;

    private String season;

    private String sponsor;
}
