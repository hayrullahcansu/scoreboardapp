package com.hayrullahcansu.sportradar.scoreboardapp.service;

import com.hayrullahcansu.sportradar.scoreboardapp.data.AddingScoreResult;
import com.hayrullahcansu.sportradar.scoreboardapp.data.Match;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;


@Service
public class ScoreBoardService {

    private List<Match> matches = new LinkedList<>();
    ReentrantLock lock = new ReentrantLock();

    public AddingScoreResult StartAGame(String homeTeam, String awayTeam) {
        lock.lock();
        AddingScoreResult result = new AddingScoreResult();
        try {
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
