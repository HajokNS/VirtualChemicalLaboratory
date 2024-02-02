package com.chornopyskyi.chemicallaboratory.service;

import com.chornopyskyi.chemicallaboratory.model.ChemicalSubstance;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Клас, який надає сервісні методи для роботи з хімічними речовинами з JSON файлу.
 */
public class ChemicalSubstanceService {

    /**
     * Отримує список хімічних речовин з JSON файлу.
     *
     * @param filePath Шлях до JSON файлу з хімічними речовинами.
     * @return Список об'єктів типу {@code ChemicalSubstance}.
     */
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

    /**
     * Виводить інформацію про хімічні речовини на консоль.
     *
     * @param substances Список хімічних речовин для виведення.
     */
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
}
