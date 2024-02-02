package com.chornopyskyi.chemicallaboratory.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.Objects;
import java.util.UUID;
/**
 * Клас {@code User} представляє користувача із вказаною інформацією, такою як ідентифікатор, пароль,
 * електронна пошта, логін та роль користувача.
 *
 * <p>Використовується аннотації для налаштування JSON-серіалізації та десеріалізації.
 */
@JsonPropertyOrder({"idUser", "username", "password", "email", "role", "errors", "valid"})
@JsonIgnoreProperties(ignoreUnknown = true)
public class User extends EntityErrors {

    /**
     * Унікальний ідентифікатор користувача.
     */
    private String idUser;

    /**
     * Пароль користувача.
     */
    private String password;

    /**
     * Електронна пошта користувача.
     */
    private String email;

    /**
     * Логін користувача.
     */
    private String username;

    /**
     * Роль користувача.
     */
    private String role;

    /**
     * Конструктор для створення нового об'єкта користувача з вказаними параметрами.
     *
     * @param password Пароль користувача.
     * @param email    Електронна пошта користувача.
     * @param username Логін користувача.
     * @param role     Роль користувача.
     */
    public User(@JsonProperty("password") String password, @JsonProperty("email") String email,
        @JsonProperty("username") String username, @JsonProperty("role") String role) {
        this.idUser = UUID.randomUUID().toString();
        this.password = setPassword(password);
        this.email = setEmail(email);
        setUsername(username);
        this.role = role;
    }

    /**
     * Порожній конструктор для створення порожнього об'єкта користувача.
     */
    public User() {
        // Пустий конструктор
    }

    // Геттери та сеттери

    /**
     * Отримує ідентифікатор користувача.
     *
     * @return Ідентифікатор користувача.
     */
    public String getIdUser() {
        return idUser;
    }

    /**
     * Встановлює ідентифікатор користувача.
     *
     * @param idUser Ідентифікатор користувача.
     */
    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    /**
     * Отримує роль користувача.
     *
     * @return Роль користувача.
     */
    public String getRole() {
        return role;
    }

    /**
     * Встановлює роль користувача.
     *
     * @param role Роль користувача.
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * Отримує пароль користувача.
     *
     * @return Пароль користувача.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Отримує електронну пошту користувача.
     *
     * @return Електронна пошта користувача.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Отримує логін користувача.
     *
     * @return Логін користувача.
     */
    public String getUsername() {
        return username;
    }

    // Інші методи

    /**
     * Встановлює електронну пошту користувача та проводить валідацію.
     *
     * @param email Електронна пошта користувача.
     * @return Електронна пошта користувача.
     * @throws EntityArgumentException Виняток, який виникає при невідповідності валідаційним правилам.
     */
    public String setEmail(String email) {
        final String templateName = "електронної пошти";

        // Логіка валідації

        if (!errors.isEmpty()) {
            throw new EntityArgumentException(errors);
        }

        return email;
    }

    /**
     * Встановлює логін користувача та проводить валідацію.
     *
     * @param username Логін користувача.
     * @throws EntityArgumentException Виняток, який виникає при невідповідності валідаційним правилам.
     */
    public void setUsername(String username) {
        final String templateName = "логіну";

        // Логіка валідації

        if (!this.errors.isEmpty()) {
            throw new EntityArgumentException(errors);
        }

        this.username = username;
    }

    /**
     * Встановлює пароль користувача та проводить валідацію.
     *
     * @param password Пароль користувача.
     * @return Пароль користувача.
     * @throws EntityArgumentException Виняток, який виникає при невідповідності валідаційним правилам.
     */
    public String setPassword(String password) {
        final String templateName = "паролю";

        // Логіка валідації

        return password;
    }

    /**
     * Порівнює об'єкт користувача з іншим об'єктом на рівність за електронною поштою.
     *
     * @param o Інший об'єкт для порівняння.
     * @return {@code true}, якщо об'єкти рівні; {@code false} в іншому випадку.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(email, user.email);
    }

    /**
     * Генерує хеш-код об'єкта користувача за електронною поштою.
     *
     * @return Хеш-код об'єкта.
     */
    @Override
    public int hashCode() {
        return Objects.hash(email);
    }

    /**
     * Повертає рядкове представлення об'єкта користувача.
     *
     * @return Рядкове представлення об'єкта.
     */
    @Override
    public String toString() {
        return "User{" +
            "password='" + password + '\'' +
            ", email='" + email + '\'' +
            ", username='" + username + '\'' +
            ", id=" + idUser +
            '}';
    }

    /**
     * Виводить інформацію про користувача на консоль.
     */
    public void displayUserInfo() {
        System.out.println("User Information:");
        System.out.println("ID: " + idUser);
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
        System.out.println("Email: " + email);
    }
}

