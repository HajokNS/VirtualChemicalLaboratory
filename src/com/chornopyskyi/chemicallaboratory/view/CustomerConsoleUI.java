package com.chornopyskyi.chemicallaboratory.view;

import java.util.Scanner;
import org.fusesource.jansi.Ansi;
import org.fusesource.jansi.Ansi.Attribute;
import org.fusesource.jansi.Ansi.Color;

public class CustomerConsoleUI {

    public CustomerConsoleUI() {

    }

    public static void printTitle(String text)
    {
        System.out.println(Ansi.ansi()
            .fgDefault()
            .bg(Color.CYAN)
            .fg(Color.DEFAULT)
            .a(Ansi.Attribute.INTENSITY_BOLD)
            .a("  " + text + "  ")
            .reset());
    }

    public static void printFieldName(String text)
    {
        System.out.print(Ansi.ansi()
            .fgDefault()
            .bg(Ansi.Color.BLACK)
            .fg(Ansi.Color.WHITE)
            .a(text + ": ")
            .reset());
    }

    public static void printField(String text)
    {
        System.out.println(Ansi.ansi()
            .fgDefault()
            .bg(Ansi.Color.BLACK)
            .fg(Ansi.Color.GREEN)
            .a(Ansi.Attribute.ITALIC)
            .a(text)
            .reset());
    }

    public static void printLine(Character fillChar, int length )
    {
        String text = String.valueOf(fillChar).repeat(length);

        System.out.println(Ansi.ansi()
            .fgDefault()
            .bg(Color.DEFAULT)
            .fg(Color.GREEN)
            .a(Ansi.Attribute.INTENSITY_BOLD)
            .a(text)
            .reset());
    }

    public static void printMenu(String text)
    {
        System.out.println(Ansi.ansi()
            .fgDefault()
            .bg(Color.YELLOW)
            .fg(Color.BLACK)
            .a(Attribute.ITALIC)
            .a("- " + text + " ")
            .reset());
    }

    public static void printSystemMessage(String text)
    {
        System.out.println(Ansi.ansi()
            .fgDefault()
            .bg(Ansi.Color.RED)
            .fg(Ansi.Color.BLACK)
            .a(Ansi.Attribute.INTENSITY_BOLD)
            .a("- " + text + " ")
            .reset());
    }

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
