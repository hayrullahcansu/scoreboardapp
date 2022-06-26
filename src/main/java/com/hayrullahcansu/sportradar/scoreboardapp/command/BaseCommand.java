package com.hayrullahcansu.sportradar.scoreboardapp.command;

import com.hayrullahcansu.sportradar.scoreboardapp.service.ScoreBoardService;

import java.util.Scanner;

public abstract class BaseCommand {
    final
    ScoreBoardService scoreBoardService;
    private String homeTeam;
    private String awayTeam;

    public BaseCommand(ScoreBoardService scoreBoardService) {
        this.scoreBoardService = scoreBoardService;
        scanner = new Scanner(System.in);
    }

    public void ServeCommand() {
        InitializeMenu();
        RunCommandAndRenderResult();
        System.out.println("\nPress enter to return to menu");
//        scanner.next();
        try {
            System.in.read();
        } catch (Exception e) {
        }
    }

    abstract void InitializeMenu();

    abstract void RunCommandAndRenderResult();

    protected Scanner scanner;

    protected void ClearConsole() {
        CommandService.clearConsole();
    }

    protected String ReadLine() {
        return scanner.nextLine();
    }

    protected void WriteLine(String data) {
        System.out.printf("%s\n", data);
    }

    protected String getHomeTeam() {
        return homeTeam;
    }

    protected String getAwayTeam() {
        return awayTeam;
    }

    protected void setHomeTeam() {
        System.out.println("Enter Home Team");
        this.homeTeam = ReadLine();
    }

    protected void setAwayTeam() {
        System.out.println("Enter Away Team");
        this.awayTeam = ReadLine();
    }
}
