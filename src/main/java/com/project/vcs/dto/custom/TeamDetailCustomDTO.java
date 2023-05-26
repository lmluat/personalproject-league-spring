package com.project.vcs.dto.custom;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeamDetailCustomDTO {
    private String sponsor;
    private String coachName;
    private String teamName;
    private String tournamentName;
}
