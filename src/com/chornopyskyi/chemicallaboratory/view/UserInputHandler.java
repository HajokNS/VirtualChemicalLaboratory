package com.chornopyskyi.chemicallaboratory.view;

import java.util.Scanner;

public class UserInputHandler {
    private Scanner scanner;

    public static boolean promptUserForBoolean(String prompt) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print(prompt + " ");
            String input = scanner.nextLine().trim().toLowerCase();

            if (input.equals("так") || input.equals("ні")) {
                return input.equals("так");
            } else {
                System.out.println("Будь ласка, введіть 'так' або 'ні'.");
            }
        }
    }

    public long promptUserForLong(String promptMessage) {
        String userInput = promptUserForString(promptMessage);
        try {
            return Long.parseLong(userInput);
        } catch (NumberFormatException e) {
            System.out.println("Некоректний формат числа. Спробуйте ще раз.");
            return promptUserForLong(promptMessage);
        }
    }

    public UserInputHandler() {
        this.scanner = new Scanner(System.in);
    }

    // Метод для отримання рядка від користувача
    public String promptUserForString(String prompt) {
        System.out.print(prompt + ": ");
        return scanner.nextLine();
    }

    // Метод для отримання цілочисельного значення від користувача
    public int promptUserForInteger(String prompt) {
        CustomerConsoleUI.printSystemMessage(prompt + ": ");

        while (!scanner.hasNextInt()) {
            CustomerConsoleUI.printSystemMessage("Будь ласка, введіть ціле число.");
            CustomerConsoleUI.printSystemMessage(prompt + ": ");
            scanner.next();
        }
        int result = scanner.nextInt();
        scanner.nextLine();
        return result;
    }

    // Інші методи опитування користувача можна додати за необхідності

    public void closeScanner() {
        scanner.close();
    }
}
