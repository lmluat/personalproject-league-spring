package com.project.vcs.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
//@NamedQuery(name = "Airplane.findByModel", query =" select a from Airplane a where a.model = ?1")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "match_schedule")
public class MatchSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Tournament tournament;
    private int week;
    private LocalDate time;
    private Team teamOne;
    private Team teamTwo;
    private String location;
}
