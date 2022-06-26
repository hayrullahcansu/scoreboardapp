package com.hayrullahcansu.sportradar.scoreboardapp.command;

import com.hayrullahcansu.sportradar.scoreboardapp.service.ScoreBoardService;

public class UpdateGameCommand extends BaseCommand {
    Integer homeTeamScore;
    Integer awayTeamScore;

    public UpdateGameCommand(ScoreBoardService scoreBoardService) {
        super(scoreBoardService);
    }

    @Override
    void InitializeMenu() {
        setHomeTeam();
        WriteLine("Enter Home Team Score");
        homeTeamScore = Integer.parseInt(scanner.nextLine().trim());
        setAwayTeam();
        WriteLine("Enter Away Team Score");
        awayTeamScore = Integer.parseInt(scanner.nextLine().trim());
    }

    @Override
    void RunCommandAndRenderResult() {
        var result = scoreBoardService.UpdateAGame(getHomeTeam(), getAwayTeam(), homeTeamScore, awayTeamScore);
        if (result.getResult()) {
            var m = result.getMatch();
            WriteLine(String.format("Match score updated successfully %s %d - %s %d\n\nold scores: %d - %d",
                    m.getHomeTeam(),
                    m.getHomeTeamScore(),
                    m.getAwayTeam(),
                    m.getAwayTeamScore(),
                    result.getOldHomeTeamScore(),
                    result.getOldAwayTeamScore()));
        } else {
            WriteLine("The given match not exists");
        }
    }
}
