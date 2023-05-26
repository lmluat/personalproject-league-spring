package com.project.vcs.dto;

import com.project.vcs.entity.Caster;
import com.project.vcs.entity.Tournament;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MatchDTO {
    private String tournamentName;
    private String casterName;
    private LocalDate date;
    private String location;

}
