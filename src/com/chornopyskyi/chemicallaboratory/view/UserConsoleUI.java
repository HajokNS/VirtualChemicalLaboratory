package com.chornopyskyi.chemicallaboratory.view;

import com.chornopyskyi.chemicallaboratory.model.User;
import java.lang.reflect.Field;

/**
 * Клас, що надає методи для виведення інформації про користувачів в консоль.
 */
public class UserConsoleUI {

    /**
     * Метод для виведення інформації про користувача в консоль.
     *
     * @param user Об'єкт класу {@link User}, інформацію про якого потрібно вивести.
     * @throws IllegalAccessException Виникає, якщо виникає помилка при доступі до полів класу.
     */
    public static void displayUserInfo(User user) throws IllegalAccessException {

        // Ітерація по полях класу User
        for (Field field : User.class.getDeclaredFields()) {
            String fieldName = field.getName();
            field.setAccessible(true);
            Object value = field.get(user);

            // Виведення імені поля
            CustomerConsoleUI.printFieldName(fieldName);

            // Виведення значення поля в консоль
            if (value instanceof String) {
                CustomerConsoleUI.printField((String) value);
            } else if (value instanceof Long) {
                CustomerConsoleUI.printField(String.valueOf(value));
            } else {
                CustomerConsoleUI.printField(value.toString());
            }
        }
    }
}
