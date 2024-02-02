package com.chornopyskyi.chemicallaboratory.view;

import com.chornopyskyi.chemicallaboratory.service.ChemicalReactionService;
import com.chornopyskyi.chemicallaboratory.chemicallaboratory.Application;
import com.chornopyskyi.chemicallaboratory.model.ChemicalSubstance;
import com.chornopyskyi.chemicallaboratory.model.Equipment;
import com.chornopyskyi.chemicallaboratory.service.*;
import java.util.List;

/**
 * Клас `Menu` представляє консольне меню лабораторії з різними опціями для різних ролей користувачів.
 */
public class Menu {

    /**
     * Конструктор класу.
     */
    public Menu() {
    }

    /**
     * Метод `show` відображає головне меню лабораторії та обробляє вибір користувача.
     *
     * @throws IllegalAccessException Виняток, який може виникнути при доступі до полів/методів з неправильним доступом.
     */
    public static void show() throws IllegalAccessException {
        ExperimentService experimentService = new ExperimentService();

        CustomerConsoleUI.printLine('-', 20);
        CustomerConsoleUI.printTitle("Меню лабораторії");
        CustomerConsoleUI.printLine('-', 20);

        while (true) {
            String userRole = Application.currentUser.getRole();

            if ("".equals(userRole)) {
                CustomerConsoleUI.printMenu("1) Реєстрація");
                CustomerConsoleUI.printMenu("2) Авторизація");
            } else {
                CustomerConsoleUI.printMenu("1) Вийти із системи");
                CustomerConsoleUI.printMenu("2) Переглянути свої дані");
                CustomerConsoleUI.printMenu("3) Інформація");
                CustomerConsoleUI.printMenu("4) Хімічна реакція речовин");
                CustomerConsoleUI.printMenu("5) Проведення експерименту");
                CustomerConsoleUI.printMenu("6) Фільтрація експериментів");

                if ("Адмін".equals(userRole)) {
                    CustomerConsoleUI.printMenu("7) Видалення користувачів");
                }
            }

            CustomerConsoleUI.printMenu("0) Вихід з програми");

            int choice = new UserInputHandler().promptUserForInteger(
                "Ваш вибір"); // вибір користувача

            if ("".equals(userRole)) {
                switch (choice) {
                    case 1:
                        // Логіка для реєстрації
                        RegistrationService.registration();
                        break;
                    case 2:
                        // Логіка для авторизації
                        AuthorizationService.authorization();
                        break;
                    case 0:
                        CustomerConsoleUI.printTitle(
                            "Дякую, що скористалися нашою програмою.");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Вибрано невірний пункт меню.");
                        break;
                }
            } else {
                switch (choice) {
                    case 1:
                        Application.currentUser.setRole("");
                        break;
                    case 2:
                        // Логіка для перегляду своїх даних
                        UserConsoleUI.displayUserInfo(Application.currentUser);
                        break;
                    case 3:
                        // Інформація про хімічні речовини
                        CustomerConsoleUI.printMenu("1) Інформація про хімічні речовини");
                        CustomerConsoleUI.printMenu("2) Інформація про обладнання");

                        if ("Адмін".equals(userRole) || "Викладач".equals(userRole)) {
                            CustomerConsoleUI.printMenu("3) Редагування хімічних речовин");
                            CustomerConsoleUI.printMenu("4) Редагування обладнання");
                            CustomerConsoleUI.printMenu("5) Додати/Видалити хімічну речовину");
                            CustomerConsoleUI.printMenu("6) Додати/Видалити обладнання");
                        }

                        int subMenuChoice = new UserInputHandler().promptUserForInteger(
                            "Оберіть підпункт (введіть номер, або 0 для повернення в меню)");

                        switch (subMenuChoice) {
                            case 1:
                                // Логіка для виведення молекулярних формул
                                ChemicalSubstanceService reactionService = new ChemicalSubstanceService();

                                // Викличте метод getChemicalSubstancesFromJsonFile та виведіть результат
                                List<ChemicalSubstance> substances = reactionService.getChemicalSubstancesFromJsonFile(
                                    "src/com/chornopyskyi/chemicallaboratory/repository/ChemicalSubstance.json");

                                // Викличте метод printChemicalSubstances для виведення результату
                                reactionService.printChemicalSubstances(substances);
                                break;
                            case 2:
                                EquipmentService equipmentService = new EquipmentService();
                                List<Equipment> equipmentList = equipmentService.getEquipmentFromJsonFile(
                                    "src/com/chornopyskyi/chemicallaboratory/repository/Equipment.json"
                                );
                                equipmentService.printEquipment(equipmentList);
                                break;
                            case 3:
                                if ("Адмін".equals(userRole) || "Викладач".equals(userRole)) {
                                    JsonEditorSubstance jsonEditor = new JsonEditorSubstance();
                                    jsonEditor.editJsonForObjectType("ChemicalSubstance");
                                } else {
                                    CustomerConsoleUI.printSystemMessage(
                                        "Невірний вибір. Спробуйте ще раз.");
                                }
                                break;
                            case 4:
                                if ("Адмін".equals(userRole) || "Викладач".equals(userRole)) {
                                    JsonEditorEquipment jsonEditor = new JsonEditorEquipment();
                                    jsonEditor.editJsonForObjectType("Equipment");
                                } else {
                                    CustomerConsoleUI.printSystemMessage(
                                        "Невірний вибір. Спробуйте ще раз.");
                                }
                                break;
                            case 5:
                                if ("Адмін".equals(userRole) || "Викладач".equals(userRole)) {
                                    CustomerConsoleUI.printMenu("1) Додати хімічну речовину");
                                    CustomerConsoleUI.printMenu("2) Видалити хімічну речовину");

                                    int addOrRemoveChoice = new UserInputHandler().promptUserForInteger(
                                        "Оберіть дію (введіть номер, або 0 для повернення в меню)");

                                    switch (addOrRemoveChoice) {
                                        case 1:
                                            JsonAddDelSubstance.addChemicalSubstanceJson();
                                            break;
                                        case 2:
                                            CustomerConsoleUI.printSystemMessage("Список хімічних речовин перед видаленням:");
                                            ChemicalSubstanceService substanceService = new ChemicalSubstanceService();
                                            List<ChemicalSubstance> substancesBeforeDeletion = substanceService.getChemicalSubstancesFromJsonFile(
                                                "src/com/chornopyskyi/chemicallaboratory/repository/ChemicalSubstance.json");
                                            substanceService.printChemicalSubstances(substancesBeforeDeletion);
                                            // Введення айді для видалення
                                            long idToDelete = new UserInputHandler().promptUserForLong(
                                                "Введіть айді хімічної речовини, яку ви хочете видалити");

                                            // Логіка для видалення хімічної речовини
                                            JsonAddDelSubstance jsonAddDelSubstance = new JsonAddDelSubstance();
                                            jsonAddDelSubstance.deleteChemicalSubstanceById(idToDelete);
                                            break;
                                        case 0:
                                            break;
                                    }
                                } else {
                                    CustomerConsoleUI.printSystemMessage(
                                        "Невірний вибір. Спробуйте ще раз.");
                                }
                                break;
                            case 6:
                                if ("Адмін".equals(userRole) || "Викладач".equals(userRole)) {
                                    CustomerConsoleUI.printMenu("1) Додати обладнання");
                                    CustomerConsoleUI.printMenu("2) Видалити обладнання");

                                    int addOrRemoveEquipmentChoice = new UserInputHandler().promptUserForInteger(
                                        "Оберіть дію (введіть номер, або 0 для повернення в меню)");

                                    switch (addOrRemoveEquipmentChoice) {
                                        case 1:
                                            JsonAddDelEquipment.addEquipmentJson();
                                            break;
                                        case 2:
                                            CustomerConsoleUI.printSystemMessage("Список обладнання перед видаленням:");
                                            EquipmentService equipmentServiceForDeletion = new EquipmentService();
                                            List<Equipment> equipmentBeforeDeletion = equipmentServiceForDeletion.getEquipmentFromJsonFile(
                                                "src/com/chornopyskyi/chemicallaboratory/repository/Equipment.json");
                                            equipmentServiceForDeletion.printEquipment(equipmentBeforeDeletion);

                                            // Введення айді для видалення обладнання
                                            long equipmentIdToDelete = new UserInputHandler().promptUserForLong(
                                                "Введіть айді обладнання, яке ви хочете видалити");

                                            // Логіка для видалення обладнання
                                            JsonAddDelEquipment jsonAddDelEquipment = new JsonAddDelEquipment();
                                            jsonAddDelEquipment.deleteEquipmentById(equipmentIdToDelete);
                                            break;
                                        case 0:
                                            break;
                                        default:
                                            CustomerConsoleUI.printSystemMessage(
                                                "Невірний вибір. Спробуйте ще раз.");
                                            break;
                                    }
                                } else {
                                    CustomerConsoleUI.printSystemMessage(
                                        "Невірний вибір. Спробуйте ще раз.");
                                }
                                break;
                        }
                        break;

                    case 4:
                        ChemicalReactionService chemicalReactionService = new ChemicalReactionService();
                        chemicalReactionService.performChemicalReactions();
                        break;
                    case 5:
                        experimentService.loadExperiments("src/com/chornopyskyi/chemicallaboratory/repository/Experiments.json");
                        experimentService.loadChemicalReactions("src/com/chornopyskyi/chemicallaboratory/repository/ReportResults.json");
                        experimentService.conductExperiment();
                        break;
                    case 6:
                        experimentService.loadExperiments("src/com/chornopyskyi/chemicallaboratory/repository/Experiments.json");
                        experimentService.filterExperiments();
                        break;
                    case 7:
                        if ("Адмін".equals(userRole)) {
                            UserInputHandler userInputHandler = new UserInputHandler();
                            UserService userService = new UserService();

                            userService.printAllUsers();

                            String emailToDelete = userInputHandler.promptUserForString("Введіть емейл користувача для видалення");
                            userService.deleteUserByEmail(emailToDelete);
                        } else {
                            CustomerConsoleUI.printSystemMessage(
                                "Невірний вибір. Спробуйте ще раз.");
                        }
                        break;
                    case 0:
                        // Вихід
                        CustomerConsoleUI.printTitle(
                            "Дякую, що скористалися нашою програмою.");
                        System.exit(0);
                        break;
                    default:
                        CustomerConsoleUI.printSystemMessage(
                            "Невірний вибір. Спробуйте ще раз.");
                        break;
                }

                if (choice == 0) {
                    break;
                }
            }
        }
    }
}

