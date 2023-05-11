package com.project.vcs.entity;

import java.time.LocalDate;

public class MatchSchedule {
    private Long id;
    private Tournament tournament;
    private int week;
    private LocalDate time;
    private Team teamOne;
    private Team teamTwo;
    private String location;
}
