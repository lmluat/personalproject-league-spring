package com.project.vcs.service;

import com.project.vcs.entity.TeamDetail;
import com.project.vcs.entity.Tournament;
import com.project.vcs.repository.MatchRepository;
import com.project.vcs.repository.TeamDetailRepository;
import com.project.vcs.repository.TeamRepository;
import com.project.vcs.repository.TournamentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class MatchServiceTest {
    @Autowired
    MatchService matchService;
    @Autowired
    TeamDetailRepository teamDetailRepository;
    @Autowired
    TournamentRepository tournamentRepository;
    @Test
    void isMatchIdGameIdExistingOnSameDay() {
        TeamDetail teamOneDetail = teamDetailRepository.findById(5L).get();
        TeamDetail teamTwoDetail = teamDetailRepository.findById(7L).get();
        Tournament tournament = tournamentRepository.findById(5L).get();
        LocalDate date = LocalDate.of(2023,02,24);
        System.out.println(matchService.isMatchIdGameIdExistingOnSameDay(teamOneDetail, teamTwoDetail, tournament, date ));
    }

}