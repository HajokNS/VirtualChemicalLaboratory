package com.chornopyskyi.chemicallaboratory.service;

import com.chornopyskyi.chemicallaboratory.model.Equipment;
import com.chornopyskyi.chemicallaboratory.view.CustomerConsoleUI;
import com.chornopyskyi.chemicallaboratory.view.UserInputHandler;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class JsonEditorEquipment {

    public static void editJsonForObjectType(String objectType) {
        switch (objectType) {
            case "Equipment":
                editEquipmentJson();
                break;
            default:
                System.out.println("Невідомий тип об'єкту для редагування.");
        }
    }

    public void saveEquipmentToJson(List<Equipment> equipmentList, String filePath) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(filePath), equipmentList);
        } catch (IOException e) {
            e.printStackTrace();
            // Обробка помилок при записі в файл
        }
    }

    private static void editEquipmentJson() {
        JsonEditorEquipment jsonEditor = new JsonEditorEquipment(); // Створюємо екземпляр класу JsonEditor
        EquipmentService equipmentService = new EquipmentService();
        List<Equipment> equipmentList = equipmentService.getEquipmentFromJsonFile(
            "src/com/chornopyskyi/chemicallaboratory/repository/Equipment.json");

        // Виведення списку обладнання для вибору, яке редагувати
        System.out.println("Оберіть обладнання для редагування:");
        equipmentService.printEquipment(equipmentList);

        long idToEdit = new UserInputHandler().promptUserForLong("Введіть айді обладнання для редагування");

        Equipment selectedEquipment = equipmentList.stream()
            .filter(equipment -> equipment.getId() == idToEdit)
            .findFirst()
            .orElse(null);

        if (selectedEquipment != null) {

            // Введення нових даних
            System.out.println("Поточна назва: " + selectedEquipment.getName());
            System.out.println("Поточний опис: " + selectedEquipment.getDescription());
            System.out.println("Поточний опис функціональності: " + selectedEquipment.getFunctionalityDescription());
            System.out.println("Поточний метод використання: " + selectedEquipment.getUsageMethod());

            // Запитання про редагування назви
            boolean editName = UserInputHandler.promptUserForBoolean(
                "Бажаєте редагувати назву? (так/ні)");

            if (editName) {
                String newName = CustomerConsoleUI.promptUserForInput("Введіть нову назву",
                    new Scanner(System.in));
                selectedEquipment.setName(newName);
                System.out.println("Назва успішно оновлена.");
            }

            // Запитання про редагування опису
            boolean editDescription = UserInputHandler.promptUserForBoolean(
                "Бажаєте редагувати опис? (так/ні)");

            if (editDescription) {
                String newDescription = CustomerConsoleUI.promptUserForInput("Введіть новий опис",
                    new Scanner(System.in));
                selectedEquipment.setDescription(newDescription);
                System.out.println("Опис успішно оновлено.");
            }

            // Запитання про редагування опису функціональності
            boolean editFunctionalityDescription = UserInputHandler.promptUserForBoolean(
                "Бажаєте редагувати опис функціональності? (так/ні)");

            if (editFunctionalityDescription) {
                String newFunctionalityDescription = CustomerConsoleUI.promptUserForInput("Введіть новий опис функціональності",
                    new Scanner(System.in));
                selectedEquipment.setFunctionalityDescription(newFunctionalityDescription);
                System.out.println("Опис функціональності успішно оновлено.");
            }

            // Запитання про редагування методу використання
            boolean editUsageMethod = UserInputHandler.promptUserForBoolean(
                "Бажаєте редагувати метод використання? (так/ні)");

            if (editUsageMethod) {
                String newUsageMethod = CustomerConsoleUI.promptUserForInput("Введіть новий метод використання",
                    new Scanner(System.in));
                selectedEquipment.setUsageMethod(newUsageMethod);
                System.out.println("Метод використання успішно оновлено.");
            }

            // Збереження змін у JSON файл
            jsonEditor.saveEquipmentToJson(equipmentList,
                "src/com/chornopyskyi/chemicallaboratory/repository/Equipment.json");

            System.out.println("Дані успішно оновлено.");
        } else {
            System.out.println("Невірний вибір.");
        }
    }
}

