package com.project.vcs.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlayerDetailDTO {

    private String position;
    private String ingameName;
    private Boolean isCaptain;
    private String teamName;
    private String tournamentName;
}
