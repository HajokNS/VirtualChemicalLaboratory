package com.chornopyskyi.chemicallaboratory.chemicallaboratory;

import com.chornopyskyi.chemicallaboratory.model.User;
import com.chornopyskyi.chemicallaboratory.view.Menu;

/**
 * Клас {@code Application} представляє програму хімічного лабораторію.
 * В цьому класі визначено основні параметри та методи для виконання програми.
 *
 * <p>Клас містить статичний масив користувачів, поточного користувача та метод для запуску програми.</p>
 *
 * @author Чорнопиский Денис
 * @version 1.0
 */
public class Application {

    /**
     * Масив користувачів, який зберігає дані про усіх користувачів лабораторії.
     */
    public static User[] users;

    /**
     * Поточний користувач, який використовується у програмі.
     */
    public static User currentUser = new User("Den32131", "Denis123@gmail.com", "Denis123qwert", "");

    /**
     * Метод для запуску програми та відображення головного меню.
     *
     * @throws IllegalAccessException виняток, який може бути викинутий при доступі до недозволених об'єктів.
     */
    public static void runner() throws IllegalAccessException {
        Menu.show();
    }

    /**
     * Головний метод, який викликається при запуску програми. Викликає метод {@code runner()} для запуску програми.
     *
     * @param args масив аргументів командного рядка.
     * @throws IllegalAccessException виняток, який може бути викинутий при доступі до недозволених об'єктів.
     */
    public static void main(String[] args) throws IllegalAccessException {
        runner();
    }
}
