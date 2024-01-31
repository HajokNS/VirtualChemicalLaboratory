package com.chornopyskyi.chemicallaboratory.service;

import com.chornopyskyi.chemicallaboratory.model.ChemicalSubstance;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ChemicalSubstanceService {

    public List<ChemicalSubstance> getChemicalSubstancesFromJsonFile(String filePath) {
        List<ChemicalSubstance> chemicalSubstances = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Зчитати JSON з файлу та отримати кореневий вузол
            JsonNode rootNode = objectMapper.readTree(new File(filePath));

            // Проходження через всі об'єкти в масиві JSON
            for (JsonNode substanceNode : rootNode) {
                long id = substanceNode.get("id").asLong();
                String name = substanceNode.get("name").asText();
                String molecularFormula = substanceNode.get("molecularFormula").asText();
                String description = substanceNode.get("description").asText();
                String substanceType = substanceNode.get("substanceType").asText();

                // Створіть об'єкт хімічної речовини та додайте його до списку
                ChemicalSubstance substance = new ChemicalSubstance(id, name, molecularFormula,
                    description, substanceType);
                chemicalSubstances.add(substance);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return chemicalSubstances;
    }

    public void printChemicalSubstances(List<ChemicalSubstance> substances) {
        if (substances.isEmpty()) {
            System.out.println("Немає даних про хімічні речовини.");
        } else {
            System.out.println("Інформація про хімічні речовини:");
            for (ChemicalSubstance substance : substances) {
                System.out.println("ID: " + substance.getId());
                System.out.println("Назва: " + substance.getName());
                System.out.println("Молекулярна формула: " + substance.getMolecularFormula());
                System.out.println("Опис: " + substance.getDescription());
                System.out.println("Тип: " + substance.getSubstanceType());
                System.out.println();
            }
        }
    }

   /* public List<ChemicalSubstance> chooseChemicalSubstances(List<ChemicalSubstance> substances) {
        Scanner scanner = new Scanner(System.in);
        List<ChemicalSubstance> chosenSubstances = new ArrayList<>();

        System.out.println("Виберіть номери двох хімічних речовин (через кому):");
        for (int i = 0; i < substances.size(); i++) {
            System.out.println((i + 1) + ". " + substances.get(i).getName());
        }

        String input = scanner.next();
        String[] choices = input.split(",");

        if (choices.length != 2) {
            System.out.println("Невірний ввід. Виберіть дві речовини, використовуючи кому.");
            return null;
        }

        try {
            int choice1 = Integer.parseInt(choices[0].trim());
            int choice2 = Integer.parseInt(choices[1].trim());

            if (choice1 >= 1 && choice1 <= substances.size() && choice2 >= 1
                && choice2 <= substances.size()) {
                chosenSubstances.add(substances.get(choice1 - 1));
                chosenSubstances.add(substances.get(choice2 - 1));
            } else {
                System.out.println("Невірний ввід. Виберіть дві речовини, використовуючи кому.");
                return null;
            }
        } catch (NumberFormatException e) {
            System.out.println("Невірний ввід. Введіть числа, використовуючи кому.");
            return null;
        }

        return chosenSubstances;
    }*/

   /* public void saveChemicalSubstancesToJsonFile(List<ChemicalSubstance> selectedSubstances,
        String filePath) {
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectWriter objectWriter = objectMapper.writerWithDefaultPrettyPrinter();

        try {
            // Включення форматування для красивого JSON
            objectWriter = objectWriter.with(SerializationFeature.INDENT_OUTPUT);

            // Запис JSON до файлу
            objectWriter.writeValue(new File(filePath), selectedSubstances);
            System.out.println("Реактиви були успішно збережені у файл: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Помилка при збереженні реактивів у файл: " + filePath);
        }
    }*/

}
