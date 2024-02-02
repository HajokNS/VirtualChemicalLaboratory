package com.chornopyskyi.chemicallaboratory.view;

import org.fusesource.jansi.Ansi;
import org.fusesource.jansi.Ansi.Attribute;
import org.fusesource.jansi.Ansi.Color;

import java.util.Scanner;

/**
 * Клас `CustomerConsoleUI` надає методи для виведення різноманітного тексту
 * у консольному інтерфейсі з використанням кольорів та форматування за допомогою Ansi.
 */
public class CustomerConsoleUI {

    /**
     * Конструктор класу.
     */
    public CustomerConsoleUI() {

    }

    /**
     * Метод для виведення заголовку з заданим текстом та стилем.
     *
     * @param text Текст заголовку.
     */
    public static void printTitle(String text) {
        System.out.println(Ansi.ansi()
            .fgDefault()
            .bg(Color.CYAN)
            .fg(Color.DEFAULT)
            .a(Attribute.INTENSITY_BOLD)
            .a("  " + text + "  ")
            .reset());
    }

    /**
     * Метод для виведення назви поля з вказаним текстом.
     *
     * @param text Текст назви поля.
     */
    public static void printFieldName(String text) {
        System.out.print(Ansi.ansi()
            .fgDefault()
            .bg(Ansi.Color.BLACK)
            .fg(Ansi.Color.WHITE)
            .a(text + ": ")
            .reset());
    }

    /**
     * Метод для виведення значення поля з вказаним текстом.
     *
     * @param text Текст значення поля.
     */
    public static void printField(String text) {
        System.out.println(Ansi.ansi()
            .fgDefault()
            .bg(Ansi.Color.BLACK)
            .fg(Ansi.Color.GREEN)
            .a(Attribute.ITALIC)
            .a(text)
            .reset());
    }

    /**
     * Метод для виведення лінії заданої довжини та символу для заповнення.
     *
     * @param fillChar Символ для заповнення.
     * @param length   Довжина лінії.
     */
    public static void printLine(Character fillChar, int length) {
        String text = String.valueOf(fillChar).repeat(length);

        System.out.println(Ansi.ansi()
            .fgDefault()
            .bg(Color.DEFAULT)
            .fg(Color.GREEN)
            .a(Attribute.INTENSITY_BOLD)
            .a(text)
            .reset());
    }

    /**
     * Метод для виведення пункту меню з вказаним текстом.
     *
     * @param text Текст пункту меню.
     */
    public static void printMenu(String text) {
        System.out.println(Ansi.ansi()
            .fgDefault()
            .bg(Color.YELLOW)
            .fg(Color.BLACK)
            .a(Attribute.ITALIC)
            .a("- " + text + " ")
            .reset());
    }

    /**
     * Метод для виведення системного повідомлення з вказаним текстом.
     *
     * @param text Текст системного повідомлення.
     */
    public static void printSystemMessage(String text) {
        System.out.println(Ansi.ansi()
            .fgDefault()
            .bg(Ansi.Color.RED)
            .fg(Ansi.Color.BLACK)
            .a(Attribute.INTENSITY_BOLD)
            .a("- " + text + " ")
            .reset());
    }

    /**
     * Метод для отримання введення від користувача з певним запитанням.
     *
     * @param prompt  Запитання для користувача.
     * @param scanner Об'єкт Scanner для зчитування введення.
     * @return Рядок введення користувача.
     */
    public static String promptUserForInput(String prompt, Scanner scanner) {
        System.out.print(Ansi.ansi()
            .fgDefault()
            .bg(Ansi.Color.YELLOW)
            .fg(Ansi.Color.BLACK)
            .a(prompt + ": ")
            .reset());

        return scanner.nextLine();
    }
}
