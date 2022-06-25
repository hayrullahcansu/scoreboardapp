package com.hayrullahcansu.sportradar.scoreboardapp;

import com.hayrullahcansu.sportradar.scoreboardapp.data.AddingScoreResult;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ScoreBoardAppApplicationTests {

    ScoreBoardService scoreBoardService;

    @Test
    void StartAGameWithCustomHomeTeamAwayTeam() {
        String homeTeam = "Real Madrid";
        String awayTeam = "Barcelona";

        AddingScoreResult result = scoreBoardService.StartAGame(homeTeam, awayTeam);

        assertNotNull(result);
        assertEquals(true, result.getResult());
        assertNotNull(result.getMatch());
        assertThat(result.getMatch()).hasFieldOrPropertyWithValue("homeTeam", homeTeam);
        assertThat(result.getMatch()).hasFieldOrPropertyWithValue("awayTeam", awayTeam);
    }

}
