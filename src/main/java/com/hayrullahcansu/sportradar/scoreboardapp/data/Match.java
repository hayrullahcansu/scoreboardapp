package com.hayrullahcansu.sportradar.scoreboardapp.data;

import java.time.LocalDateTime;

public class Match {
    String homeTeam;
    String awayTeam;
    Integer homeTeamScore;
    Integer awayTeamScore;
    LocalDateTime eventStartDateTime;


    public Match(String homeTeam, String awayTeam) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.homeTeamScore = 0;
        this.awayTeamScore = 0;
        this.eventStartDateTime = LocalDateTime.now();
    }

    public Match(String homeTeam, String awayTeam, Integer homeTeamScore, Integer awayTeamScore) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.homeTeamScore = homeTeamScore;
        this.awayTeamScore = awayTeamScore;
        this.eventStartDateTime = LocalDateTime.now();
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public Integer getHomeTeamScore() {
        return homeTeamScore;
    }

    public Integer getAwayTeamScore() {
        return awayTeamScore;
    }

    public LocalDateTime getEventStartDateTime() {
        return eventStartDateTime;
    }
}
