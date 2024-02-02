package com.chornopyskyi.chemicallaboratory.service;

import com.chornopyskyi.chemicallaboratory.model.Path;
import com.chornopyskyi.chemicallaboratory.model.User;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/**
 * Клас `UserService` відповідає за операції над користувачами, такі як завантаження,
 * збереження, виведення на екран та видалення користувачів.
 */
public class UserService {

    private List<User> users;
    private final String userDataFilePath = Path.USER_JSON.getPath();

    /**
     * Конструктор класу. При створенні екземпляра UserService завантажте користувачів з файлу.
     */
    public UserService() {
        loadUsersFromFile();
    }

    /**
     * Метод для завантаження користувачів з JSON-файлу.
     */
    private void loadUsersFromFile() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            users = objectMapper.readValue(new File(userDataFilePath), new TypeReference<List<User>>() {});
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Помилка при завантаженні користувачів з файлу.");
        }
    }

    /**
     * Метод для збереження користувачів у JSON-файл.
     */
    private void saveUsersToFile() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

            objectMapper.writeValue(new File(userDataFilePath), users);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Помилка при збереженні користувачів у файл.");
        }
    }

    /**
     * Метод для виведення інформації про всіх користувачів на екран.
     */
    public void printAllUsers() {
        System.out.println("Інформація про користувачів:");
        for (User user : users) {
            System.out.println("Емейл: " + user.getEmail() + ", Ім'я: " + user.getUsername() + ", Роль: " + user.getRole());
        }
        System.out.println();
    }

    /**
     * Метод для видалення користувача за емейлом.
     *
     * @param email Емейл користувача, якого слід видалити.
     */
    public void deleteUserByEmail(String email) {
        Iterator<User> iterator = users.iterator();
        while (iterator.hasNext()) {
            User user = iterator.next();
            if (user.getEmail().equals(email)) {
                iterator.remove();
                System.out.println("Користувач з емейлом " + email + " був видалений.");
                saveUsersToFile(); // Оновлення файлу після видалення
                return;
            }
        }

        System.out.println("Користувача з емейлом " + email + " не знайдено.");
    }
}
