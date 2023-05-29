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
class PlayerDetailRepositoryTest {
    @Autowired
    PlayerDetailRepository playerDetailRepository;
    @Test
    void getCountOfMVPPlayers() {
        System.out.println(playerDetailRepository.getCountOfMvpPlayers("Shogun","VIETNAM CHAMPIONSHIP SERIES 2023"));

    }

    @Test
    void getDistinctPlayerIngameNamesByTournament() {
    playerDetailRepository.getDistinctPlayerIngameNamesByTournament("VIETNAM CHAMPIONSHIP SERIES 2023");
    }
}