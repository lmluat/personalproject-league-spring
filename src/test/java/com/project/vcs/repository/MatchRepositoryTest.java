package com.project.vcs.repository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class MatchRepositoryTest {
    @Autowired
    MatchRepository matchRepository;
    @Test
    void When_inputTournamentName_Expect_returnMatchList() {
        matchRepository.findByTournamentName("VIETNAM CHAMPIONSHIP SERIES 2023");
        matchRepository.findById(1L).get().getMatchDetailList().get(0).getTeamOne().getTeam().getTeamName();
        System.out.println(matchRepository.findById(19L).get().getMatchDetailList().get(0).getTeamOne().getTeam().getTeamName());
    }

}