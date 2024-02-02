package com.chornopyskyi.chemicallaboratory.service;

import com.chornopyskyi.chemicallaboratory.chemicallaboratory.Application;
import com.chornopyskyi.chemicallaboratory.model.Path;
import com.chornopyskyi.chemicallaboratory.model.User;
import com.chornopyskyi.chemicallaboratory.view.CustomerConsoleUI;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Сервіс для авторизації користувача.
 */
public class AuthorizationService {

    /**
     * Здійснює процес авторизації користувача.
     */
    public static void authorization() {
        String username = CustomerConsoleUI.promptUserForInput("Введіть логін", new Scanner(System.in));
        String password = CustomerConsoleUI.promptUserForInput("Введіть пароль", new Scanner(System.in));

        System.out.println("Ви ввели логін: " + username + " і пароль: " + password);

        List<User> users = readUsersFromJson(Path.USER_JSON.getPath());

        User user = findUserByUsername(users, username);

        if (user != null && user.getPassword().equals(password)) {
            Application.currentUser = user;
            CustomerConsoleUI.printSystemMessage("Авторизація пройшла успішно.");

        } else {
            CustomerConsoleUI.printSystemMessage("Помилка авторизації. Перевірте логін та пароль.");
        }
    }

    /**
     * Пошук користувача за логіном у списку користувачів.
     *
     * @param users    Список користувачів.
     * @param username Логін користувача.
     * @return Знайдений користувач або {@code null}, якщо користувач не знайдений.
     */
    private static User findUserByUsername(List<User> users, String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    /**
     * Зчитує користувачів із JSON-файлу.
     *
     * @param filePath Шлях до JSON-файлу.
     * @return Список користувачів, зчитаний із файлу.
     */
    private static List<User> readUsersFromJson(String filePath) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return Arrays.asList(objectMapper.readValue(new File(filePath), User[].class));
        } catch (IOException e) {
            e.printStackTrace();
            // Обробка помилок при читанні з файлу
            return new ArrayList<>();
        }
    }
}
