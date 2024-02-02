package com.chornopyskyi.chemicallaboratory.service;

import com.chornopyskyi.chemicallaboratory.model.ChemicalSubstance;
import com.chornopyskyi.chemicallaboratory.model.Path;
import com.chornopyskyi.chemicallaboratory.view.CustomerConsoleUI;
import java.util.List;
import java.util.Scanner;

/**
 * Клас, який надає методи для додавання та видалення хімічних речовин через редагування JSON файлу.
 */
public class JsonAddDelSubstance {

    /**
     * Додає нову хімічну речовину до JSON файлу.
     */
    public static void addChemicalSubstanceJson() {
        JsonEditorSubstance jsonEditor = new JsonEditorSubstance();
        ChemicalSubstanceService substanceService = new ChemicalSubstanceService();
        List<ChemicalSubstance> substances = substanceService.getChemicalSubstancesFromJsonFile(
            Path.SUBSTANCE_JSON.getPath());

        // Отримання айді останнього елемента у списку
        long lastId = substances.isEmpty() ? 0 : substances.get(substances.size() - 1).getId();

        // Введення нових даних для нової хімічної речовини
        String newName = CustomerConsoleUI.promptUserForInput("Введіть назву", new Scanner(System.in));
        String newMolecularFormula = CustomerConsoleUI.promptUserForInput("Введіть молекулярну формулу", new Scanner(System.in));
        String newDescription = CustomerConsoleUI.promptUserForInput("Введіть опис", new Scanner(System.in));
        String newType = CustomerConsoleUI.promptUserForInput("Введіть тип", new Scanner(System.in));

        // Створення нової хімічної речовини з автоматично збільшеним айді
        ChemicalSubstance newSubstance = new ChemicalSubstance(lastId + 1, newName, newMolecularFormula, newDescription, newType);
        substances.add(newSubstance);

        // Збереження змін у JSON файл
        jsonEditor.saveChemicalSubstancesToJson(substances, Path.SUBSTANCE_JSON.getPath());

        System.out.println("Нова хімічна речовина успішно додана.");
    }

    /**
     * Видаляє хімічну речовину за її айді з JSON файлу.
     *
     * @param idToDelete Айді хімічної речовини для видалення.
     */
    public void deleteChemicalSubstanceById(long idToDelete) {
        ChemicalSubstanceService substanceService = new ChemicalSubstanceService();
        List<ChemicalSubstance> substances = substanceService.getChemicalSubstancesFromJsonFile(
            Path.SUBSTANCE_JSON.getPath());

        // Пошук хімічної речовини за введеним айді
        ChemicalSubstance substanceToRemove = substances.stream()
            .filter(substance -> substance.getId() == idToDelete)
            .findFirst()
            .orElse(null);

        // Перевірка, чи знайдено хімічну речовину за введеним айді
        if (substanceToRemove != null) {
            // Видалення хімічної речовини та збереження змін у JSON файл
            substances.remove(substanceToRemove);
            JsonEditorSubstance jsonEditor = new JsonEditorSubstance();
            jsonEditor.saveChemicalSubstancesToJson(substances, Path.SUBSTANCE_JSON.getPath());
            System.out.println("Хімічну речовину з айді " + idToDelete + " успішно видалено.");
        } else {
            System.out.println("Хімічну речовину з айді " + idToDelete + " не знайдено.");
        }
    }
}
