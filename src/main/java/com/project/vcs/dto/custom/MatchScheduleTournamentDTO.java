package com.project.vcs.dto.custom;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MatchScheduleTournamentDTO {
    private String tournamentName;
    private String location;
    private LocalDate date;
    private String casterName;
    private String teamOneName;
    private String teamTwoName;
}
