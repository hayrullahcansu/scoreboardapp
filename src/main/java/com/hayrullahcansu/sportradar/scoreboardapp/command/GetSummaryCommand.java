package com.hayrullahcansu.sportradar.scoreboardapp.command;

import com.hayrullahcansu.sportradar.scoreboardapp.service.ScoreBoardService;

public class GetSummaryCommand extends BaseCommand {
    public GetSummaryCommand(ScoreBoardService scoreBoardService) {
        super(scoreBoardService);
    }

    @Override
    void InitializeMenu() {

    }

    @Override
    void RunCommandAndRenderResult() {
        var result = scoreBoardService.GetSummaryResult();
        ClearConsole();
        WriteLine(result.getSummary());
    }
}
