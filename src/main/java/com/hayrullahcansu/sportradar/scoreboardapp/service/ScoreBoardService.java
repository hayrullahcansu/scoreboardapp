package com.hayrullahcansu.sportradar.scoreboardapp.service;

import com.hayrullahcansu.sportradar.scoreboardapp.data.*;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.locks.ReentrantLock;


@Service
public class ScoreBoardService {
    List<Match> matches = new LinkedList<>(
            Arrays.asList(
                    new Match("Uruguay", "Italy", 6, 6),
                    new Match("Spain", "Brazil", 10, 2),
                    new Match("Mexico", "Canada", 0, 5),
                    new Match("Argentina", "Australia", 3, 1),
                    new Match("Germany", "France", 2, 2)
            )
    );
    ReentrantLock lock = new ReentrantLock();

    public AddingGameResult StartAGame(String homeTeam, String awayTeam) {
        lock.lock();
        AddingGameResult result = new AddingGameResult();
        try {
            var isMatchExists = matches.stream()
                    .anyMatch(p -> p.getHomeTeam() == homeTeam && p.getAwayTeam() == awayTeam);
            if (isMatchExists) {
                result.setResult(false);
                return result;
            }
            Match m = new Match(homeTeam, awayTeam);
            matches.add(m);
            result.setResult(true);
            result.setMatch(m);
        } finally {
            lock.unlock();
        }
        return result;
    }

    public FinishGameResult FinishAGame(String homeTeam, String awayTeam) {
        lock.lock();
        FinishGameResult result = new FinishGameResult();
        try {
            var match = matches.stream()
                    .filter(p -> p.getHomeTeam() == homeTeam && p.getAwayTeam() == awayTeam)
                    .findFirst();
            if (!match.isPresent()) {
                result.setResult(false);
                return result;
            }
            matches.remove(match.get());
            result.setResult(true);
            result.setMatch(match.get());
        } finally {
            lock.unlock();
        }
        return result;
    }

    public UpdateGameResult UpdateAGame(String homeTeam, String awayTeam, Integer homeTeamScore, Integer awayTeamScore) {
        lock.lock();
        UpdateGameResult result = new UpdateGameResult();
        try {
            var match = matches.stream()
                    .filter(p -> p.getHomeTeam() == homeTeam && p.getAwayTeam() == awayTeam)
                    .findFirst();
            if (!match.isPresent()) {
                result.setResult(false);
                return result;
            }
            result.setResult(true);
            result.setOldHomeTeamScore(match.get().getHomeTeamScore());
            result.setOldAwayTeamScore(match.get().getAwayTeamScore());
            match.get().setHomeTeamScore(homeTeamScore);
            match.get().setAwayTeamScore(awayTeamScore);
            result.setMatch(match.get());
        } finally {
            lock.unlock();
        }
        return result;
    }

    public SummaryResult GetSummaryResult() {
        SummaryResult result = new SummaryResult();
        StringBuilder sb = new StringBuilder();
        lock.lock();
        try {
            int index = 1;
            matches.stream().sorted(Comparator.comparingInt(x -> x.getEventStartDateTime().getNano()));
            for (Match m :
                    matches) {
                sb.append(String.format("%d. %s %d - %s %d\n", index, m.getHomeTeam(), m.getHomeTeamScore(), m.getAwayTeam(), m.getAwayTeamScore()));
                index++;
            }
            result.setSummary(sb.toString());
        } finally {
            lock.unlock();
        }
        return result;
    }
}
