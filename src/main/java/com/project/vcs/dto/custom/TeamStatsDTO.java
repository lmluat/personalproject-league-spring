package com.project.vcs.dto.custom;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeamStatsDTO {
    private String teamName;
    private int numberOfMatch;
    private double winRate;
}
