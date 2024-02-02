package com.chornopyskyi.chemicallaboratory.service;

import com.chornopyskyi.chemicallaboratory.chemicallaboratory.Application;
import com.chornopyskyi.chemicallaboratory.model.Path;
import com.chornopyskyi.chemicallaboratory.model.User;
import com.chornopyskyi.chemicallaboratory.view.CustomerConsoleUI;
import com.chornopyskyi.chemicallaboratory.view.UserInputHandler;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Клас `RegistrationService` відповідає за реєстрацію нових користувачів
 * та збереження їх даних у файл JSON.
 */
public class RegistrationService {
    private static User[] users2;

    /**
     * Метод {@code registration} забезпечує процес реєстрації нового користувача.
     * Вводяться логін, пароль, email та обирається роль. Дані користувача зберігаються у файл JSON.
     */
    public static void registration() {
        String username;
        String password;
        String email;

        do {
            try {
                if (Application.users == null) {
                    Application.users = new User[]{};
                }

                // Отримати логін та перевірити його унікальність
                username = CustomerConsoleUI.promptUserForInput("Введіть логін",
                    new java.util.Scanner(System.in));

                users2 = new ObjectMapper().readValue(new File(Path.USER_JSON.getPath()), User[].class);

                if (isLoginUnique(username)) {
                    // Отримати пароль
                    password = CustomerConsoleUI.promptUserForInput("Введіть пароль",
                        new java.util.Scanner(System.in));

                    // Отримати email
                    email = CustomerConsoleUI.promptUserForInput("Введіть email",
                        new java.util.Scanner(System.in));

                    // Отримати вибір ролі
                    CustomerConsoleUI.printMenu("Оберіть роль:");
                    CustomerConsoleUI.printMenu("1) Користувач");
                    CustomerConsoleUI.printMenu("2) Лаборант");
                    CustomerConsoleUI.printMenu("3) Викладач");
                    CustomerConsoleUI.printMenu("4) Адмін");
                    int roleChoice = new UserInputHandler().promptUserForInteger("Ваш вибір");

                    String role;
                    switch (roleChoice) {
                        case 1:
                            role = "Користувач";
                            break;
                        case 2:
                            role = "Лаборант";
                            break;
                        case 3:
                            role = "Викладач";
                            break;
                        case 4:
                            role = "Адмін";
                            break;
                        default:
                            role = "Користувач";
                            break;
                    }

                    // Створити нового користувача
                    User newUser = new User(password, email, username, role);
                    Application.currentUser = newUser;

                    Application.users = addNewUser(Application.users, newUser);

                    saveUsersToJson(Application.users, Path.USER_JSON.getPath());

                    CustomerConsoleUI.printSystemMessage("Реєстрація пройшла успішно.");
                    break;  // Вийти з циклу, якщо реєстрація успішна
                } else {
                    System.out.println(
                        "Цей логін вже використовується. Оберіть інший.");
                }

            } catch (IllegalArgumentException e) {
                // Вивести повідомлення про помилку та продовжити цикл
                System.out.println("Помилка реєстрації. Перевірте введені дані.");
            } catch (Exception e) {
                // Обробити інші винятки
                e.printStackTrace();
                System.out.println("Сталася помилка. Будь ласка, спробуйте ще раз.");
            }

        } while (true);  // Цикл, доки користувач не введе правильні дані
    }

    /**
     * Метод {@code addNewUser} додає нового користувача до масиву користувачів.
     *
     * @param users   Початковий масив користувачів.
     * @param newUser Об'єкт нового користувача, який потрібно додати.
     * @return Новий масив користувачів, що включає в себе нового користувача.
     */
    private static User[] addNewUser(User[] users, User newUser) {
        User[] newUsers = Arrays.copyOf(users, users.length + 1);
        newUsers[users.length] = newUser;
        return newUsers;
    }

    /**
     * Метод {@code isLoginUnique} перевіряє, чи є логін унікальним серед існуючих користувачів.
     *
     * @param login Логін, який слід перевірити на унікальність.
     * @return {@code true}, якщо логін унікальний; {@code false}, якщо логін вже використовується.
     */
    private static boolean isLoginUnique(String login) {
        if (users2 != null) {
            for (User existingUser : users2) {
                if (existingUser.getUsername().equals(login)) {
                    return false; // Логін не є унікальним
                }
            }
        }
        return true; // Логін є унікальним
    }

    /**
     * Метод {@code saveUsersToJson} зберігає дані про користувачів у файл JSON.
     *
     * @param users    Масив користувачів для збереження.
     * @param filePath Шлях до файлу JSON для збереження даних про користувачів.
     */
    private static void saveUsersToJson(User[] users, String filePath) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            File file = new File(filePath);
            User[] existingUsers;

            if (file.exists()) {
                existingUsers = objectMapper.readValue(file, User[].class);
            } else {
                existingUsers = new User[]{};
            }

            List<User> userList = new ArrayList<>(Arrays.asList(existingUsers));
            userList.addAll(Arrays.asList(users));

            objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, userList.toArray(new User[0]));

            Application.users = userList.toArray(new User[0]);

        } catch (IOException e) {
            e.printStackTrace();
            CustomerConsoleUI.printSystemMessage("Сталася помилка під час роботи з файлом.");
        }
    }
}
