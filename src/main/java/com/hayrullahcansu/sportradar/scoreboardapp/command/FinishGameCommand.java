package com.hayrullahcansu.sportradar.scoreboardapp.command;

import com.hayrullahcansu.sportradar.scoreboardapp.service.ScoreBoardService;

public class FinishGameCommand extends BaseCommand {
    public FinishGameCommand(ScoreBoardService scoreBoardService) {
        super(scoreBoardService);
    }

    @Override
    void InitializeMenu() {
        setHomeTeam();
        setAwayTeam();
    }

    @Override
    void RunCommandAndRenderResult() {
        var result = scoreBoardService.FinishAGame(getHomeTeam(), getAwayTeam());
        if (result.getResult()) {
            var m = result.getMatch();
            WriteLine(String.format("Match finished successfully %s %d - %s %d",
                    m.getHomeTeam(),
                    m.getHomeTeamScore(),
                    m.getAwayTeam(),
                    m.getAwayTeamScore()));
        } else {
            WriteLine(String.format("The given match not exists %s %s", getHomeTeam(), getAwayTeam()));
        }
    }
}
