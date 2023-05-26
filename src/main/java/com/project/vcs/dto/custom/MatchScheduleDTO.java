package com.project.vcs.dto.custom;

import com.project.vcs.entity.MatchDetail;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MatchScheduleDTO {
    private LocalDate date;
    private String location;
    private String teamOne;
    private String teamTwo;

}
