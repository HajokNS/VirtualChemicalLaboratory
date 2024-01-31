package com.chornopyskyi.chemicallaboratory.service;

import com.chornopyskyi.chemicallaboratory.model.ChemicalReaction;
import com.chornopyskyi.chemicallaboratory.model.Equipment;
import com.chornopyskyi.chemicallaboratory.model.ChemicalSubstance;
import com.chornopyskyi.chemicallaboratory.view.CustomerConsoleUI;
import com.chornopyskyi.chemicallaboratory.view.UserInputHandler;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class ChemicalReactionService {

    public void performChemicalReactions() {
        // 1. Отримання 10 молекулярних формул
        List<ChemicalSubstance> randomSubstances = getRandomChemicalSubstances(10);

        // 2. Виведення молекулярних формул та отримання введення користувача
        CustomerConsoleUI.printSystemMessage("Доступні реакції:");
        printChemicalSubstances(randomSubstances);

        CustomerConsoleUI.printMenu("Виберіть номер реакції для проведення!");

        // Отримання вибору користувача
        String userChoice = new UserInputHandler().promptUserForString("Введіть 2 цифри (через кому)");

        // Парсинг та обробка введення
        List<Integer> selectedIndexes = parseUserChoice(userChoice);

        // Повторення введення, поки користувач не введе дійсні індекси
        while (selectedIndexes.isEmpty()) {
            // Знову отримати вибір користувача
            userChoice = new UserInputHandler().promptUserForString("Введіть 2 цифри (через кому)");

            // Повторно парсити та обробляти введення
            selectedIndexes = parseUserChoice(userChoice);
        }

        // 3. Виведення типу реакції
        String reactionType = getReactionType();
        CustomerConsoleUI.printSystemMessage("Тип реакції: " + reactionType);

        // 4. Отримання та виведення списку обладнання
        List<String> allEquipment = getAllEquipment();
        printEquipment(allEquipment);
        // Повторення введення, поки користувач не введе дійсний номер обладнання
        int equipmentChoice;
        do {
            equipmentChoice = new UserInputHandler().promptUserForInteger(
                "Оберіть номер обладнання");
        } while (equipmentChoice < 1 || equipmentChoice > allEquipment.size());
        String selectedEquipment = allEquipment.get(equipmentChoice - 1);

        // 5. Формування та виведення результату
        ChemicalSubstance firstSubstance = randomSubstances.get(selectedIndexes.get(0) - 1);
        ChemicalSubstance secondSubstance = randomSubstances.get(selectedIndexes.get(1) - 1);

        CustomerConsoleUI.printSystemMessage(
            firstSubstance.getMolecularFormula() + " + " + secondSubstance.getMolecularFormula() +
                " --> " + firstSubstance.getMolecularFormula()
                + secondSubstance.getMolecularFormula()
        );

        // 6. Запис результату в JSON файл
        ChemicalReaction result = new ChemicalReaction(
            UUID.randomUUID().getMostSignificantBits(),
            0,
            Arrays.asList(firstSubstance.getMolecularFormula(),
                secondSubstance.getMolecularFormula()),
            Arrays.asList(
                firstSubstance.getMolecularFormula() + secondSubstance.getMolecularFormula()),
            reactionType,
            Collections.singletonList(selectedEquipment)
        );

        saveResultToJson(result,
            "src/com/chornopyskyi/chemicallaboratory/repository/ReportResults.json");
    }


    private List<ChemicalSubstance> getRandomChemicalSubstances(int count) {
        // Отримати всі молекулярні формули з JSON файлу
        List<ChemicalSubstance> allSubstances = getChemicalSubstancesFromJsonFile(
            "src/com/chornopyskyi/chemicallaboratory/repository/ChemicalSubstance.json");

        // Забрати необхідну кількість формул
        Collections.shuffle(allSubstances);
        return allSubstances.subList(0, Math.min(count, allSubstances.size()));
    }

    private void printChemicalSubstances(List<ChemicalSubstance> substances) {
        for (int i = 0; i < substances.size(); i++) {
            CustomerConsoleUI.printMenu((i + 1) + ") " + substances.get(i).getMolecularFormula());
        }
    }

    private List<Integer> parseUserChoice(String userChoice) {
        String[] selectedIndexes = userChoice.split(",");

        // Перевірка чи введено рівно 2 індекси
        if (selectedIndexes.length != 2) {
            CustomerConsoleUI.printSystemMessage("Введіть рівно 2 індекси через кому.");
            return Collections.emptyList();
        }

        List<Integer> result = new ArrayList<>();
        for (String index : selectedIndexes) {
            try {
                int parsedIndex = Integer.parseInt(index);

                // Перевірка чи індекс в межах допустимого діапазону
                if (parsedIndex < 1 || parsedIndex > 10) {
                    CustomerConsoleUI.printSystemMessage("Недопустимий індекс: " + parsedIndex);
                    return Collections.emptyList();
                }

                result.add(parsedIndex);
            } catch (NumberFormatException e) {
                CustomerConsoleUI.printSystemMessage("Невірний формат індексу: " + index);
                return Collections.emptyList();
            }
        }
        return result;
    }

    private String getReactionType() {
        // Повторення введення, поки користувач не введе дійсний тип реакції
        while (true) {
            // Вивести можливі типи реакцій
            CustomerConsoleUI.printSystemMessage("Виберіть тип реакції:");
            CustomerConsoleUI.printMenu("1) Синтез");
            CustomerConsoleUI.printMenu("2) Розклад");
            CustomerConsoleUI.printMenu("3) Заміщення");
            CustomerConsoleUI.printMenu("4) Двійкова");
            CustomerConsoleUI.printMenu("5) Ацидо-базова");

            // Запитати користувача про вибір типу реакції
            int choice = new UserInputHandler().promptUserForInteger("Оберіть тип реакції:");

            // Перевірка чи введено дійсний тип реакції
            if (choice >= 1 && choice <= 5) {
                switch (choice) {
                    case 1:
                        return "Синтез";
                    case 2:
                        return "Розклад";
                    case 3:
                        return "Заміщення";
                    case 4:
                        return "Двійкова";
                    case 5:
                        return "Ацидо-базова";
                }
            }

            CustomerConsoleUI.printSystemMessage("Невірний вибір. Будь ласка, виберіть тип реакції від 1 до 5.");
        }
    }

    private List<String> getAllEquipment() {
        return getEquipmentFromJsonFile("src/com/chornopyskyi/chemicallaboratory/repository/Equipment.json");
    }

    private void printEquipment(List<String> equipment) {
        for (int i = 0; i < equipment.size(); i++) {
            CustomerConsoleUI.printMenu((i + 1) + ") " + equipment.get(i));
        }
    }

    private void saveResultToJson(ChemicalReaction result, String filePath) {
        try {
            // Створіть екземпляр ObjectMapper
            ObjectMapper objectMapper = new ObjectMapper();

            // Налаштуйте ObjectMapper для виведення в красивому форматі
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

            // Створіть файл за вказаним шляхом
            File file = new File(filePath);

            // Перевірте, чи файл існує
            if (!file.exists()) {
                System.out.println("Файл не існує. Спробуйте зберегти результат у новий файл.");
                return;
            }

            // Прочитайте вміст файлу у список
            List<ChemicalReaction> existingContent = objectMapper.readValue(file, List.class);

            // Додайте новий результат до списку
            existingContent.add(result);

            // Запишіть оновлений список у файл
            objectMapper.writeValue(file, existingContent);

            System.out.println("Результат додано у файл: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
            CustomerConsoleUI.printSystemMessage("Помилка під час збереження результату у файл.");
        }
    }

    private List<ChemicalSubstance> getChemicalSubstancesFromJsonFile(String filePath) {
        try {
            // Створити екземпляр ObjectMapper
            ObjectMapper objectMapper = new ObjectMapper();

            // Створити файл за вказаним шляхом
            File file = new File(filePath);

            // Перевірити, чи файл існує
            if (!file.exists()) {
                System.out.println("Файл не існує. Переконайтеся, що шлях правильний.");
                return Collections.emptyList();
            }

            // Прочитати вміст файлу та отримати список молекулярних формул
            List<ChemicalSubstance> chemicalSubstances = objectMapper.readValue(
                file,
                new TypeReference<List<ChemicalSubstance>>() {}
            );

            return chemicalSubstances;
        } catch (IOException e) {
            e.printStackTrace();
            CustomerConsoleUI.printSystemMessage("Помилка під час отримання молекулярних формул з файлу.");
            return Collections.emptyList();
        }
    }

    private List<String> getEquipmentFromJsonFile(String filePath) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            File file = new File(filePath);

            if (!file.exists()) {
                System.out.println("Файл не існує. Переконайтеся, що шлях правильний.");
                return Collections.emptyList();
            }

            List<Equipment> equipmentList = objectMapper.readValue(file, new TypeReference<List<Equipment>>() {});

            // Повертаємо список строкових представлень обладнання
            return equipmentList.stream()
                .map(Equipment::getName) // або іншого поля, яке вам потрібно
                .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
            CustomerConsoleUI.printSystemMessage("Помилка під час отримання обладнання з файлу.");
            return Collections.emptyList();
        }
    }
}