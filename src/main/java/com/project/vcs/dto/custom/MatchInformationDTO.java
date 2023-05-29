package com.project.vcs.dto.custom;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MatchInformationDTO {
    private LocalDate date;
    private String location;
    private String teamOne;
    private String teamTwo;

}
