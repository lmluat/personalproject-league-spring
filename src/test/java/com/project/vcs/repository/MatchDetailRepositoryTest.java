package com.project.vcs.repository;

import com.project.vcs.entity.MatchDetail;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.validation.constraints.AssertTrue;
import java.util.List;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class MatchDetailRepositoryTest {
    @Autowired
    MatchDetailRepository matchDetailRepository;
    @Test
    void When_inputMatchId_Expect_MatchDetailList() {
        List<MatchDetail> matchDetailList =matchDetailRepository.findByMatchId(1L);
        System.out.println(matchDetailList);
    }
}