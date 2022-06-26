package com.hayrullahcansu.sportradar.scoreboardapp.command;

import com.hayrullahcansu.sportradar.scoreboardapp.service.ScoreBoardService;

import java.util.Scanner;

public class CommandService {

    final
    ScoreBoardService scoreBoardService;
    private Scanner scanner = new Scanner(System.in);

    public CommandService(ScoreBoardService scoreBoardService) {
        this.scoreBoardService = scoreBoardService;
    }


    public void RunAndServe() {
        String command;
        do {
            command = GetCommand();
        } while (ExecuteCommand(command));
    }

    private boolean ExecuteCommand(String command) {
        BaseCommand commandRunner = null;
        switch (command.trim()) {
            case "1":
                //Start A Game
                commandRunner = new StartGameCommand(scoreBoardService);
                break;
            case "2":
                //Finish A Game
                commandRunner = new FinishGameCommand(scoreBoardService);
                break;
            case "3":
                //Update A Game
                commandRunner = new UpdateGameCommand(scoreBoardService);
                break;
            case "4":
                //Get Summary
                commandRunner = new GetSummaryCommand(scoreBoardService);
                break;
            case "x":
            case "X":
                //Exit
                clearConsole();
                return false;
        }
        if (commandRunner != null)
            commandRunner.ServeCommand();
        return true;
    }

    private void GetSummaryCommand() {
    }

    private void UpdateGameCommand() {
    }

    private void FinishGameCommand() {
    }

    private void StartGameCommand() {

    }

    private String GetCommand() {
        RenderMenu();
        var command = scanner.nextLine();
        return command;
    }

    private void RenderMenu() {
        clearConsole();
        StringBuilder sb = new StringBuilder();
        sb
                .append("################################################\n")
                .append("################################################\n")
                .append("\n")
                .append(" 1. Start A Match\n")
                .append(" 2. Finish A Match\n")
                .append(" 3. Update A Match\n")
                .append(" 4. Get Summary\n")
                .append(" x. Exit\n")
                .append("################################################\n")
                .append("################################################\n")
                .append("\n");
        System.out.println(sb);
    }


    public final static void clearConsole() {
        try {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows")) {
                Runtime.getRuntime().exec("cls");
            } else {
                Runtime.getRuntime().exec("clear");
            }
        } catch (final Exception e) {
            //  Handle any exceptions.
        }
    }
}
