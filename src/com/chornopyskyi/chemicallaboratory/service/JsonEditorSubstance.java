package com.chornopyskyi.chemicallaboratory.service;

import com.chornopyskyi.chemicallaboratory.model.ChemicalSubstance;
import com.chornopyskyi.chemicallaboratory.model.Path;
import com.chornopyskyi.chemicallaboratory.view.CustomerConsoleUI;
import com.chornopyskyi.chemicallaboratory.view.UserInputHandler;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

/**
 * Клас `JsonEditorSubstance` відповідає за редагування та збереження даних
 * про хімічні речовини у форматі JSON. Надає можливість вибору об'єкту для редагування та
 * здійснення змін у ньому.
 */
public class JsonEditorSubstance {

    /**
     * Метод {@code editJsonForObjectType} обробляє вибір типу об'єкту для редагування
     * та викликає відповідний метод редагування.
     *
     * @param objectType Тип об'єкту для редагування ("ChemicalSubstance" - хімічна речовина).
     */
    public static void editJsonForObjectType(String objectType) {
        switch (objectType) {
            case "ChemicalSubstance":
                editChemicalSubstancesJson();
                break;
            default:
                System.out.println("Невідомий тип об'єкту для редагування.");
        }
    }

    /**
     * Метод {@code saveChemicalSubstancesToJson} зберігає список хімічних речовин у файл JSON
     * за вказаним шляхом.
     *
     * @param substances Список об'єктів хімічних речовин для збереження.
     * @param filePath   Шлях до файлу JSON для збереження.
     */
    public void saveChemicalSubstancesToJson(List<ChemicalSubstance> substances, String filePath) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(filePath), substances);
        } catch (IOException e) {
            e.printStackTrace();
            // Обробка помилок при записі в файл
        }
    }

    /**
     * Метод {@code editChemicalSubstancesJson} викликається для редагування хімічних речовин.
     * Користувач обирає речовину за айді, та редагує її властивості.
     * Зміни зберігаються у файл JSON.
     */
    private static void editChemicalSubstancesJson() {
        JsonEditorSubstance jsonEditor = new JsonEditorSubstance(); // Створюємо екземпляр класу JsonEditor
        ChemicalSubstanceService substanceService = new ChemicalSubstanceService();
        List<ChemicalSubstance> substances = substanceService.getChemicalSubstancesFromJsonFile(
            Path.SUBSTANCE_JSON.getPath());

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
            jsonEditor.saveChemicalSubstancesToJson(substances, Path.SUBSTANCE_JSON.getPath());

            System.out.println("Дані успішно оновлено.");
        } else {
            System.out.println("Невірний вибір.");
        }
    }
}
