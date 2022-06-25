package com.hayrullahcansu.sportradar.scoreboardapp.services;

import com.hayrullahcansu.sportradar.scoreboardapp.data.AddingGameResult;
import com.hayrullahcansu.sportradar.scoreboardapp.data.FinishGameResult;
import com.hayrullahcansu.sportradar.scoreboardapp.data.UpdateGameResult;
import com.hayrullahcansu.sportradar.scoreboardapp.service.ScoreBoardService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ScoreBoardServiceTests {

    @Autowired
    ScoreBoardService scoreBoardService;

    @Test
    void Start_A_Game_With_Custom_HomeTeam_AwayTeam() {
        String homeTeam = "Real Madrid";
        String awayTeam = "Barcelona";

        AddingGameResult result = scoreBoardService.StartAGame(homeTeam, awayTeam);

        assertNotNull(result);
        assertEquals(true, result.getResult());
        assertNotNull(result.getMatch());
        assertThat(result.getMatch()).hasFieldOrPropertyWithValue("homeTeam", homeTeam);
        assertThat(result.getMatch()).hasFieldOrPropertyWithValue("awayTeam", awayTeam);
    }

    @Test
    void Start_A_Game_Return_Fail_If_The_Match_Already_Exists() {
        String homeTeam = "Uruguay";
        String awayTeam = "Italy";

        AddingGameResult result = scoreBoardService.StartAGame(homeTeam, awayTeam);

        assertNotNull(result);
        assertEquals(false, result.getResult());
        assertNull(result.getMatch());
    }

    @Test
    void Finish_A_Game_With_Custom_HomeTeam_AwayTeam() {
        String homeTeam = "Mexico";
        String awayTeam = "Canada";
        Integer homeTeamScore = 0;
        Integer awayTeamScore = 5;

        FinishGameResult result = scoreBoardService.FinishAGame(homeTeam, awayTeam);

        assertNotNull(result);
        assertEquals(true, result.getResult());
        assertNotNull(result.getMatch());
        assertThat(result.getMatch()).hasFieldOrPropertyWithValue("homeTeam", homeTeam);
        assertThat(result.getMatch()).hasFieldOrPropertyWithValue("awayTeam", awayTeam);
        assertThat(result.getMatch()).hasFieldOrPropertyWithValue("homeTeamScore", homeTeamScore);
        assertThat(result.getMatch()).hasFieldOrPropertyWithValue("awayTeamScore", awayTeamScore);
    }


    @Test
    void Finish_A_Game_Return_Fail_If_The_Match_Not_Exists() {
        String homeTeam = "Argentina";
        String awayTeam = "Turkey";

        FinishGameResult result = scoreBoardService.FinishAGame(homeTeam, awayTeam);

        assertNotNull(result);
        assertEquals(false, result.getResult());
        assertNull(result.getMatch());
    }


    @Test
    void Update_A_Game_With_Custom_HomeTeam_AwayTeam_And_Custom_Scores() {
        String homeTeam = "Germany";
        String awayTeam = "France";
        Integer homeTeamScore = 3;
        Integer awayTeamScore = 2;

        Integer oldHomeTeamScore = 2;
        Integer oldAwayTeamScore = 2;


        UpdateGameResult result = scoreBoardService.UpdateAGame(homeTeam, awayTeam, homeTeamScore, awayTeamScore);

        assertNotNull(result);
        assertEquals(true, result.getResult());
        assertNotNull(result.getMatch());
        assertThat(result.getMatch()).hasFieldOrPropertyWithValue("homeTeam", homeTeam);
        assertThat(result.getMatch()).hasFieldOrPropertyWithValue("awayTeam", awayTeam);
        assertThat(result.getMatch()).hasFieldOrPropertyWithValue("homeTeamScore", homeTeamScore);
        assertThat(result.getMatch()).hasFieldOrPropertyWithValue("awayTeamScore", awayTeamScore);
        assertThat(result).hasFieldOrPropertyWithValue("oldHomeTeamScore", oldHomeTeamScore);
        assertThat(result).hasFieldOrPropertyWithValue("oldAwayTeamScore", oldAwayTeamScore);
    }

}
