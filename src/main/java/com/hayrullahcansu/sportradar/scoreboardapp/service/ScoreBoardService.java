package com.hayrullahcansu.sportradar.scoreboardapp.service;

import com.hayrullahcansu.sportradar.scoreboardapp.data.AddingScoreResult;
import com.hayrullahcansu.sportradar.scoreboardapp.data.Match;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;


@Service
public class ScoreBoardService {
    List<Match> matches = new LinkedList<>(
            Arrays.asList(
                    new Match("Mexico", "Canada", 0, 5),
                    new Match("Spain", "Brazil", 10, 2),
                    new Match("Germany", "France", 2, 2),
                    new Match("Uruguay", "Italy", 6, 6),
                    new Match("Argentina", "Australia", 3, 1)
            )
    );
    ReentrantLock lock = new ReentrantLock();

    public AddingScoreResult StartAGame(String homeTeam, String awayTeam) {
        lock.lock();
        AddingScoreResult result = new AddingScoreResult();
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
}