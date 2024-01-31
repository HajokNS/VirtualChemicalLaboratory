package com.chornopyskyi.chemicallaboratory.service;

import com.chornopyskyi.chemicallaboratory.model.ChemicalReaction;
import com.chornopyskyi.chemicallaboratory.model.Experiment;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ExperimentService {


    private List<Experiment> experiments = new ArrayList<>();
    private List<ChemicalReaction> chemicalReactions = new ArrayList<>();

    public void loadExperiments(String filePath) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Experiment[] experimentArray = objectMapper.readValue(new File(filePath), Experiment[].class);
            experiments.addAll(List.of(experimentArray));
        } catch (IOException e) {
            System.out.println("Помилка при зчитуванні експериментів з файлу: " + e.getMessage());
        }
    }

    public void loadChemicalReactions(String filePath) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            ChemicalReaction[] reactionArray = objectMapper.readValue(new File(filePath), ChemicalReaction[].class);
            chemicalReactions.addAll(List.of(reactionArray));
        } catch (IOException e) {
            System.out.println("Помилка при зчитуванні хімічних реакцій з файлу: " + e.getMessage());
        }
    }

    public void printExperiments() {
        System.out.println("Список експериментів:");
        for (Experiment experiment : experiments) {
            System.out.println(experiment.getIdExperiment() + ") " + experiment.getName() + " - " +
                experiment.getTheme() + " - " + experiment.getGoal());
        }
    }

    public void filterExperiments() {
        Scanner scanner = new Scanner(System.in);

        printExperiments(); // Виведення експериментів перед фільтрацією реакцій

        System.out.println("Фільтрація експериментів за номером Лабораторної роботи. Введіть номер:");

        long idExperimentToFilter = scanner.nextLong();

        try {
            ObjectMapper objectMapper = new ObjectMapper();

            File file = new File("src/com/chornopyskyi/chemicallaboratory/repository/ReportResults.json");

            // Перевірка існування введеного idExperiment в файлі "ReportResult.json"
            List<ChemicalReaction> existingResults = new ArrayList<>();
            if (file.exists()) {
                existingResults = objectMapper.readValue(file, new TypeReference<List<ChemicalReaction>>() {});

                boolean experimentExists = existingResults.stream()
                    .anyMatch(reaction -> reaction.getExperimentId() == idExperimentToFilter);

                if (experimentExists) {
                    // Фільтрація реакцій за введеним idExperiment
                    List<ChemicalReaction> filteredReactions = existingResults.stream()
                        .filter(reaction -> reaction.getExperimentId() == idExperimentToFilter)
                        .collect(Collectors.toList());

                    if (!filteredReactions.isEmpty()) {
                        System.out.println("Реакції для експерименту з idExperiment=" + idExperimentToFilter + ":");
                        for (ChemicalReaction reaction : filteredReactions) {
                            System.out.println(formatReactionOutput(reaction));
                        }
                    } else {
                        System.out.println("Реакції для введеного idExperiment не знайдено.");
                    }
                } else {
                    System.out.println("Експеримент з idExperiment=" + idExperimentToFilter + " не знайдено в файлі \"ReportResult.json\".");
                }
            } else {
                System.out.println("Файл \"ReportResult.json\" не існує або порожній.");
            }
        } catch (IOException e) {
            System.out.println("Помилка при читанні файлу \"ReportResult.json\": " + e.getMessage());
        }
    }

    public void conductExperiment() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Виберіть експеримент:");

        for (Experiment experiment : experiments) {
            System.out.println(experiment.getIdExperiment() + ") " + experiment.getName() + " - " +
                experiment.getTheme() + " - " + experiment.getGoal());
        }

        int selectedExperimentId = scanner.nextInt();

        Experiment selectedExperiment = getExperimentById(selectedExperimentId);

        if (selectedExperiment != null) {
            System.out.println("Вибрано експеримент: " + selectedExperiment.getName());

            System.out.println("Виберіть хімічні реакції (введіть айді через кому):");

            for (ChemicalReaction reaction : chemicalReactions) {
                System.out.println(formatReactionOutput(reaction));
            }

            String selectedReactionsInput = scanner.next();
            String[] selectedReactionsIds = selectedReactionsInput.split(",");

            List<ChemicalReaction> selectedReactions = getReactionsByIds(selectedReactionsIds);

            if (!selectedReactions.isEmpty()) {
                System.out.println("Вибрано хімічні реакції:");

                for (ChemicalReaction reaction : selectedReactions) {
                    System.out.println(formatReactionOutput(reaction));
                }

                // Збереження результатів в файл
                saveResultsToFile(selectedExperiment.getIdExperiment(), selectedReactions);

            } else {
                System.out.println("Невірно введені айді реакцій.");
            }
        } else {
            System.out.println("Експеримент не знайдено.");
        }
    }

    private String formatReactionOutput(ChemicalReaction reaction) {
        return String.format("ChemicalReaction - id=%d - experimentId=%d - reactants=%s - products=%s - reactionType='%s' - equipmentList=%s",
            reaction.getIdReaction(), reaction.getExperimentId(),
            formatList(reaction.getReactants()), formatList(reaction.getProducts()),
            reaction.getReactionType(), formatList(reaction.getEquipmentList()));
    }



    private String formatList(List<String> items) {
        return items.stream().collect(Collectors.joining(", "));
    }


    private Experiment getExperimentById(int experimentId) {
        for (Experiment experiment : experiments) {
            if (experiment.getIdExperiment() == experimentId) {
                return experiment;
            }
        }
        return null;
    }

    private List<ChemicalReaction> getReactionsByIds(String[] reactionIds) {
        List<ChemicalReaction> selectedReactions = new ArrayList<>();
        for (String reactionId : reactionIds) {
            long id = Long.parseLong(reactionId);
            for (ChemicalReaction reaction : chemicalReactions) {
                if (reaction.getIdReaction() == id) {
                    selectedReactions.add(reaction);
                    break;
                }
            }
        }
        return selectedReactions;
    }

    private void saveResultsToFile(long experimentId, List<ChemicalReaction> selectedReactions) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();

            File file = new File("src/com/chornopyskyi/chemicallaboratory/repository/ReportResults.json");

            // Зчитати попередні результати (якщо вони існують)
            List<ChemicalReaction> existingResults = new ArrayList<>();
            if (file.exists()) {
                existingResults = objectMapper.readValue(file, new TypeReference<List<ChemicalReaction>>() {});

                // Видалити старі результати з поточним experimentId
                existingResults.removeIf(reaction -> reaction.getExperimentId() == experimentId);
            }

// Створити нові об'єкти ChemicalReaction з оновленим experimentId
            List<ChemicalReaction> updatedReactions = new ArrayList<>();
            for (ChemicalReaction reaction : selectedReactions) {
                boolean reactionExists = existingResults.stream()
                    .anyMatch(existingReaction -> existingReaction.getExperimentId() == experimentId &&
                        existingReaction.getIdReaction() == reaction.getIdReaction());

                if (!reactionExists) {
                    ChemicalReaction updatedReaction = new ChemicalReaction(
                        reaction.getIdReaction(),
                        experimentId,
                        reaction.getReactants(),
                        reaction.getProducts(),
                        reaction.getReactionType(),
                        reaction.getEquipmentList()
                    );
                    updatedReactions.add(updatedReaction);
                }
            }

            existingResults.removeIf(existingReaction -> existingReaction.getExperimentId() == experimentId);

            for (ChemicalReaction updatedReaction : updatedReactions) {
                existingResults.removeIf(existingReaction -> existingReaction.getIdReaction() == updatedReaction.getIdReaction());
                existingResults.add(updatedReaction);
            }

            objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, existingResults);

            System.out.println("Результати успішно збережено в файл " + file.getName());
        } catch (IOException e) {
            System.out.println("Помилка при збереженні результатів: " + e.getMessage());
        }
    }

}

