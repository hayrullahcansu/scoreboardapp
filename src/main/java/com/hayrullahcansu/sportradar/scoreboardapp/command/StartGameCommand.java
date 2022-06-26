package com.hayrullahcansu.sportradar.scoreboardapp.command;

import com.hayrullahcansu.sportradar.scoreboardapp.service.ScoreBoardService;

public class StartGameCommand extends BaseCommand {
    public StartGameCommand(ScoreBoardService scoreBoardService) {
        super(scoreBoardService);
    }

    @Override
    void InitializeMenu() {
        setHomeTeam();
        setAwayTeam();
    }

    @Override
    void RunCommandAndRenderResult() {
        var result = scoreBoardService.StartAGame(getHomeTeam(), getAwayTeam());
        if (result.getResult()) {
            var m = result.getMatch();
            WriteLine(String.format("Match started successfully %s %d - %s %d",
                    m.getHomeTeam(),
                    m.getHomeTeamScore(),
                    m.getAwayTeam(),
                    m.getAwayTeamScore()));
        } else {
            WriteLine("The given match already exists");
        }
    }
}
