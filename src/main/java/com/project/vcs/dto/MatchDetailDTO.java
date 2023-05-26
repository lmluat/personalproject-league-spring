package com.project.vcs.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MatchDetailDTO {
    private int gameId;
    private String teamOne;
    private String teamTwo;
    private String winningTeam;
    private String mostValuablePlayer;
    public MatchDetailDTO(String teamOne, String teamTwo, int gameId){}
}
