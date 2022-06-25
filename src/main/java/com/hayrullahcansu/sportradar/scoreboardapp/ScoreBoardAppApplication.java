package com.hayrullahcansu.sportradar.scoreboardapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScoreBoardAppApplication implements CommandLineRunner {
    private static Logger Logger = LoggerFactory
            .getLogger(ScoreBoardAppApplication.class);

    public static void main(String[] args) {
        Logger.info("Application is starting");
        SpringApplication.run(ScoreBoardAppApplication.class, args);
        Logger.info("Application shutdown");
    }

    @Override
    public void run(String... args) throws Exception {
        Logger.info("Application is started");


    }
}
