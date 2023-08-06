package org.example.UI;

import org.example.Core.MVP.Presenter;
import org.example.Core.MVP.View;

import java.util.Scanner;


public class App {


    public static void start() throws Exception{

        View view = new ConsoleView();
        Presenter presenter = new Presenter(view);

        try (Scanner scan = new Scanner(System.in)) {
            while (true) {
                System.out.println("\033[1;34m***Выбирай, что будем делать***\033[0m");
                System.out.println("\033[1;34m1\033[0m - Добавить новое животное " + "\n" +
                        "\033[1;34m2\033[0m - Посмотреть список всех животных" + "\n" +
                        "\033[1;34m3\033[0m - Посмотреть список домашних животных" + "\n" +
                        "\033[1;34m4\033[0m - Посмотреть список диких животных" + "\n" +
                        "\033[1;34m5\033[0m - Удалить всех животных " + "\n" +
                        "\033[1;34m6\033[0m - Найти животное " + "\n" +
                        "\033[1;34m7\033[0m - Удалить выбранное животное " + "\n" +
                        "\033[1;34m8\033[0m - Список команд животного" + "\n" +
                        "\033[1;34m9\033[0m - Добавить команду животному" + "\n" +
                        "\033[1;34m10\033[0m - Количество животных" + "\n" +
                        "\n\033[1;35mДля выхода нажмите (0)\033[0m");
                String key = scan.next();
                System.out.print("\033[H\033[J");
                switch (key) {
                    case "1":
                        presenter.createAnimal();
                        break;
                    case "2":
                        presenter.showAllAnimals();
                        break;
                    case "3":
                        presenter.showHomeAnimals();
                        break;
                    case "4":
                        presenter.showPackAnimals();
                        break;
                    case "5":
                        presenter.delAllAnimals();
                        break;
                    case "6":
                        presenter.searchAnimals();
                        break;
                    case "7":
                        presenter.dellAnimals();
                        break;
                    case "8":
                        presenter.commandsAnimals();
                        break;
                    case "9":
                        presenter.addCommand();
                        break;
                    case "10":
                        System.out.println("Количество животных в питомнике = " + presenter.countAllAnimals());
                        break;
                    case "0":
                        System.out.println("До скорых встреч!");
                        System.exit(0);
                        break;
                   default:
                        System.out.println("Такой команды нет");
                        break;
                }
            }
        }
    }



}
