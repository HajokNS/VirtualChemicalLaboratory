package com.chornopyskyi.chemicallaboratory.model;

/**
 * Перерахування {@code Path} містить шляхи до файлів у проекті.
 * Кожен елемент перерахування містить конкретний шлях та надає метод для отримання цього шляху.
 */
public enum Path {

    /**
     * Шлях до файлу з даними користувачів.
     */
    USER_JSON("src/com/chornopyskyi/chemicallaboratory/repository/UserData.json"),
    REPORT_JSON("src/com/chornopyskyi/chemicallaboratory/repository/ReportResults.json"),
    EXPERIMENT_JSON("src/com/chornopyskyi/chemicallaboratory/repository/Experiments.json"),
    EQUIPMENT_JSON("src/com/chornopyskyi/chemicallaboratory/repository/Equipment.json"),
    SUBSTANCE_JSON("src/com/chornopyskyi/chemicallaboratory/repository/ChemicalSubstance.json"),
    REACTION_JSON("src/com/chornopyskyi/chemicallaboratory/repository/ChemicalReaction.json");

    /**
     * Змінна, яка містить шлях.
     */
    private final String path;

    /**
     * Конструктор, який ініціалізує шлях.
     *
     * @param path Шлях до файлу.
     */
    Path(String path) {
        this.path = path;
    }

    /**
     * Отримує шлях до файлу.
     *
     * @return Шлях до файлу.
     */
    public String getPath() {
        return path;
    }
}

