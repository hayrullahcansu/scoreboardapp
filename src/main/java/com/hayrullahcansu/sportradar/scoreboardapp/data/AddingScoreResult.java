package com.hayrullahcansu.sportradar.scoreboardapp.data;


public class AddingScoreResult {
    Boolean result;
    Match match;

    public AddingScoreResult() {
    }
    
    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }

    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }
}
