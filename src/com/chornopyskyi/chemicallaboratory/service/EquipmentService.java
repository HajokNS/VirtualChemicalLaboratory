package com.chornopyskyi.chemicallaboratory.service;

import com.chornopyskyi.chemicallaboratory.model.Equipment;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EquipmentService {
    public List<Equipment> getEquipmentFromJsonFile(String filePath) {
        List<Equipment> equipmentList = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Зчитати JSON з файлу та отримати кореневий вузол
            JsonNode rootNode = objectMapper.readTree(new File(filePath));

            // Проходження через всі об'єкти в масиві JSON
            for (JsonNode equipmentNode : rootNode) {
                long id = equipmentNode.get("id").asLong();
                String name = equipmentNode.get("name").asText();
                String description = equipmentNode.get("description").asText();
                String functionalityDescription = equipmentNode.get("functionalityDescription").asText();
                String usageMethod = equipmentNode.get("usageMethod").asText();

                // Створіть об'єкт обладнання та додайте його до списку
                Equipment equipment = new Equipment(id, name, description, functionalityDescription, usageMethod);
                equipmentList.add(equipment);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return equipmentList;
    }

    public void printEquipment(List<Equipment> equipmentList) {
        if (equipmentList.isEmpty()) {
            System.out.println("Немає даних про обладнання.");
        } else {
            System.out.println("Інформація про обладнання:");
            for (Equipment equipment : equipmentList) {
                System.out.println("ID: " + equipment.getId());
                System.out.println("Назва: " + equipment.getName());
                System.out.println("Опис: " + equipment.getDescription());
                System.out.println("Опис функціональності: " + equipment.getFunctionalityDescription());
                System.out.println("Метод використання: " + equipment.getUsageMethod());
                System.out.println();
            }
        }
    }

    


}
