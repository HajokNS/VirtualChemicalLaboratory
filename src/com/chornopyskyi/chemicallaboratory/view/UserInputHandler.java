package com.chornopyskyi.chemicallaboratory.view;

import java.util.Scanner;

/**
 * Клас, який надає методи для опитування користувача та отримання від нього введення.
 */
public class UserInputHandler {

    private Scanner scanner;

    /**
     * Конструктор класу, що ініціалізує об'єкт класу {@code Scanner} для зчитування введення користувача з консолі.
     */
    public UserInputHandler() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Метод для отримання від користувача логічного значення (так/ні).
     *
     * @param prompt Повідомлення для користувача.
     * @return Логічне значення, яке введене користувачем.
     */
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

    /**
     * Метод для отримання від користувача довгого цілочисельного значення.
     *
     * @param promptMessage Повідомлення для користувача.
     * @return Довге цілочисельне значення, яке введене користувачем.
     */
    public long promptUserForLong(String promptMessage) {
        String userInput = promptUserForString(promptMessage);
        try {
            return Long.parseLong(userInput);
        } catch (NumberFormatException e) {
            System.out.println("Некоректний формат числа. Спробуйте ще раз.");
            return promptUserForLong(promptMessage);
        }
    }

    /**
     * Метод для отримання від користувача рядкового значення.
     *
     * @param prompt Повідомлення для користувача.
     * @return Рядкове значення, яке введене користувачем.
     */
    public String promptUserForString(String prompt) {
        System.out.print(prompt + ": ");
        return scanner.nextLine();
    }

    /**
     * Метод для отримання від користувача цілочисельного значення.
     *
     * @param prompt Повідомлення для користувача.
     * @return Цілочисельне значення, яке введене користувачем.
     */
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

    /**
     * Метод для закриття об'єкта класу {@code Scanner}.
     */
    public void closeScanner() {
        scanner.close();
    }
}
