package com.project.vcs.service;

import com.project.vcs.dto.MatchDTO;
import com.project.vcs.dto.MatchDetailDTO;
import com.project.vcs.dto.custom.MatchScheduleTournamentDTO;
import com.project.vcs.entity.Match;
import org.apache.tomcat.jni.Local;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class MatchDetailServiceTest {
    @Autowired
    MatchDetailService matchDetailService;
    @Test
    void getMatchScheduleTournament() {
        List<MatchScheduleTournamentDTO> matchScheduleTournamentDTOS = matchDetailService.getMatchScheduleByTournament(5L);
        matchScheduleTournamentDTOS.forEach(System.out::println);
    }

    @Test
    void getMatchScheduleFromStartDateToEndDate() {
        LocalDate startDate = LocalDate.of(2023, 1, 1);
        LocalDate endDate = LocalDate.of(2023, 5, 5);
        List<MatchScheduleTournamentDTO> matchScheduleTournamentDTOS = matchDetailService.getMatchScheduleFromStartDateToEndDate(startDate,endDate);
        matchScheduleTournamentDTOS.forEach(System.out::println);
    }

    @Test
    void updateMatchDetail() {
        MatchDetailDTO matchDetailDTO = MatchDetailDTO.builder()
                .winningTeam("Saigon Buffalo")
                .mostValuablePlayer("Shogun")
                .build();
        matchDetailService.updateMatchDetail(matchDetailDTO, 33L,1);
    }

    @Test
    void isMatchDetailListExistedMatchIdGameId() {
        System.out.println(matchDetailService.isMatchDetailListExistedMatchIdGameId(28L,4));
    }
}