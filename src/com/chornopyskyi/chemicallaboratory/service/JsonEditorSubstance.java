package com.chornopyskyi.chemicallaboratory.service;

import com.chornopyskyi.chemicallaboratory.model.ChemicalSubstance;
import com.chornopyskyi.chemicallaboratory.view.CustomerConsoleUI;
import com.chornopyskyi.chemicallaboratory.view.UserInputHandler;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class JsonEditorSubstance {

    public static void editJsonForObjectType(String objectType) {
        switch (objectType) {
            case "ChemicalSubstance":
                editChemicalSubstancesJson();
                break;
            default:
                System.out.println("Невідомий тип об'єкту для редагування.");
        }
    }

    public void saveChemicalSubstancesToJson(List<ChemicalSubstance> substances, String filePath) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(filePath), substances);
        } catch (IOException e) {
            e.printStackTrace();
            // Обробка помилок при записі в файл
        }
    }

    private static void editChemicalSubstancesJson() {
        JsonEditorSubstance jsonEditor = new JsonEditorSubstance(); // Створюємо екземпляр класу JsonEditor
        ChemicalSubstanceService substanceService = new ChemicalSubstanceService();
        List<ChemicalSubstance> substances = substanceService.getChemicalSubstancesFromJsonFile(
            "src/com/chornopyskyi/chemicallaboratory/repository/ChemicalSubstance.json");

        // Виведення списку речовин для вибору, яку редагувати
        System.out.println("Оберіть речовину для редагування:");
        substanceService.printChemicalSubstances(substances);

        long idToEdit = new UserInputHandler().promptUserForLong("Введіть айді речовини для редагування");

        ChemicalSubstance selectedSubstance = substances.stream()
            .filter(substance -> substance.getId() == idToEdit)
            .findFirst()
            .orElse(null);

        if (selectedSubstance != null) {

            // Введення нових даних
            System.out.println("Поточна назва: " + selectedSubstance.getName());
            System.out.println("Поточна молекулярна формула: " + selectedSubstance.getMolecularFormula());
            System.out.println("Поточний опис: " + selectedSubstance.getDescription());
            System.out.println("Поточний тип: " + selectedSubstance.getSubstanceType());

            // Запитання про редагування назви
            boolean editName = UserInputHandler.promptUserForBoolean(
                "Бажаєте редагувати назву? (так/ні)");

            if (editName) {
                String newName = CustomerConsoleUI.promptUserForInput("Введіть нову назву",
                    new Scanner(System.in));
                selectedSubstance.setName(newName);
                System.out.println("Назва успішно оновлена.");
            }

            // Запитання про редагування молекулярної формули
            boolean editMolecularFormula = UserInputHandler.promptUserForBoolean(
                "Бажаєте редагувати молекулярну формулу? (так/ні)");

            if (editMolecularFormula) {
                String newMolecularFormula = CustomerConsoleUI.promptUserForInput("Введіть нову молекулярну формулу",
                    new Scanner(System.in));
                selectedSubstance.setMolecularFormula(newMolecularFormula);
                System.out.println("Молекулярна формула успішно оновлена.");
            }

            // Запитання про редагування опису
            boolean editDescription = UserInputHandler.promptUserForBoolean(
                "Бажаєте редагувати опис? (так/ні)");

            if (editDescription) {
                String newDescription = CustomerConsoleUI.promptUserForInput("Введіть новий опис",
                    new Scanner(System.in));
                selectedSubstance.setDescription(newDescription);
                System.out.println("Опис успішно оновлено.");
            }

            // Запитання про редагування типу
            boolean editType = UserInputHandler.promptUserForBoolean(
                "Бажаєте редагувати тип? (так/ні)");

            if (editType) {
                String newType = CustomerConsoleUI.promptUserForInput("Введіть новий тип",
                    new Scanner(System.in));
                selectedSubstance.setSubstanceType(newType);
                System.out.println("Тип успішно оновлено.");
            }

            // Збереження змін у JSON файл
            jsonEditor.saveChemicalSubstancesToJson(substances,
                "src/com/chornopyskyi/chemicallaboratory/repository/ChemicalSubstance.json");

            System.out.println("Дані успішно оновлено.");
        } else {
            System.out.println("Невірний вибір.");
        }
    }
}
