package com.hayrullahcansu.sportradar.scoreboardapp;

import com.hayrullahcansu.sportradar.scoreboardapp.command.CommandService;
import com.hayrullahcansu.sportradar.scoreboardapp.service.ScoreBoardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ScoreBoardAppApplication implements CommandLineRunner {
    CommandService commandService;
    @Autowired
    private ApplicationContext context;

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
        if (!isJUnitTest()) {
            commandService = new CommandService(context.getBean(ScoreBoardService.class));
            commandService.RunAndServe();
        }

    }

    public static boolean isJUnitTest() {
        for (StackTraceElement element : Thread.currentThread().getStackTrace()) {
            if (element.getClassName().startsWith("org.junit.")) {
                return true;
            }
        }
        return false;
    }
}
