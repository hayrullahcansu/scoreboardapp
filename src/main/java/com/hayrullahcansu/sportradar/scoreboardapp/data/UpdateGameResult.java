package com.hayrullahcansu.sportradar.scoreboardapp.data;

public class UpdateGameResult {
    Boolean result;
    Match match;
    Integer oldHomeTeamScore;
    Integer oldAwayTeamScore;

    public UpdateGameResult() {
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

    public Integer getOldHomeTeamScore() {
        return oldHomeTeamScore;
    }

    public Integer getOldAwayTeamScore() {
        return oldAwayTeamScore;
    }

    public void setOldHomeTeamScore(Integer oldHomeTeamScore) {
        this.oldHomeTeamScore = oldHomeTeamScore;
    }

    public void setOldAwayTeamScore(Integer oldAwayTeamScore) {
        this.oldAwayTeamScore = oldAwayTeamScore;
    }

}
