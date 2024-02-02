package com.chornopyskyi.chemicallaboratory.service;

import com.chornopyskyi.chemicallaboratory.model.Equipment;
import com.chornopyskyi.chemicallaboratory.model.Path;
import com.chornopyskyi.chemicallaboratory.view.CustomerConsoleUI;
import java.util.List;
import java.util.Scanner;

/**
 * Клас, який надає методи для додавання та видалення обладнання через редагування JSON файлу.
 */
public class JsonAddDelEquipment {

    /**
     * Додає нове обладнання до JSON файлу.
     */
    public static void addEquipmentJson() {
        JsonEditorEquipment jsonEditor = new JsonEditorEquipment();
        EquipmentService equipmentService = new EquipmentService();
        List<Equipment> equipmentList = equipmentService.getEquipmentFromJsonFile(Path.EQUIPMENT_JSON.getPath());

        // Отримання айді останнього елемента у списку
        long lastId = equipmentList.isEmpty() ? 0 : equipmentList.get(equipmentList.size() - 1).getId();

        // Введення нових даних для нового обладнання
        String newName = CustomerConsoleUI.promptUserForInput("Введіть назву", new Scanner(System.in));
        String newDescription = CustomerConsoleUI.promptUserForInput("Введіть опис", new Scanner(System.in));
        String newFunctionalityDescription = CustomerConsoleUI.promptUserForInput("Введіть опис функціональності", new Scanner(System.in));
        String newUsageMethod = CustomerConsoleUI.promptUserForInput("Введіть метод використання", new Scanner(System.in));

        // Створення нового обладнання з автоматично збільшеним айді
        Equipment newEquipment = new Equipment(lastId + 1, newName, newDescription, newFunctionalityDescription, newUsageMethod);
        equipmentList.add(newEquipment);

        // Збереження змін у JSON файл
        jsonEditor.saveEquipmentToJson(equipmentList, Path.EQUIPMENT_JSON.getPath());

        System.out.println("Нове обладнання успішно додано.");
    }

    /**
     * Видаляє обладнання за його айді з JSON файлу.
     *
     * @param idToDelete Айді обладнання для видалення.
     */
    public static void deleteEquipmentById(long idToDelete) {
        EquipmentService equipmentService = new EquipmentService();
        List<Equipment> equipmentList = equipmentService.getEquipmentFromJsonFile(Path.EQUIPMENT_JSON.getPath());

        // Пошук обладнання за введеним айді
        Equipment equipmentToRemove = equipmentList.stream()
            .filter(equipment -> equipment.getId() == idToDelete)
            .findFirst()
            .orElse(null);

        // Перевірка, чи знайдено обладнання за введеним айді
        if (equipmentToRemove != null) {
            // Видалення обладнання та збереження змін у JSON файл
            equipmentList.remove(equipmentToRemove);
            JsonEditorEquipment jsonEditor = new JsonEditorEquipment();
            jsonEditor.saveEquipmentToJson(equipmentList, Path.EQUIPMENT_JSON.getPath());
            System.out.println("Обладнання з айді " + idToDelete + " успішно видалено.");
        } else {
            System.out.println("Обладнання з айді " + idToDelete + " не знайдено.");
        }
    }
}
