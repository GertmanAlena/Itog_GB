package org.example.UI;

import org.example.Animals.Animals;
import org.example.Config;
import org.example.Core.MVP.Presenter;
import org.example.Core.MVP.View;
import org.example.Core.MVP.Presenter.*;
import java.util.Scanner;


public class App {


    public static void start() throws Exception{

        Config config = new Config();
        View view = new ConsoleView();
        Presenter presenter = new Presenter(view);
        config.createNursery();
        try (Scanner scan = new Scanner(System.in)) {
            while (true) {
                System.out.println("\033[1;34m***Выбирай, что будем делать***\033[0m");
                System.out.println("\033[1;34m1\033[0m - Добавить новое животное " + "\n" +
                        "\033[1;34m2\033[0m - Посмотреть список всех животных" + "\n" +
                        "\033[1;34m3\033[0m - Удалить всех животных " + "\n" +
                        "\033[1;34m4\033[0m - Удалить выбранное животное" + "\n" +
                        "\n\033[1;35mДля выхода нажмите (0)\033[0m");
                String key = scan.next();
                System.out.print("\033[H\033[J");
                switch (key) {
                    case "1":
                        presenter.createAnimal();

                        break;
                    case "2":
                        ///countToy = presenter.giveaway(createType(2));
                        ///presenter.play(RandNam(countToy));
                        break;
                    case "0":
                        System.out.println("До скорых встреч!");
                        System.exit(0);
                        break;
                    case "3":
                        ///presenter.readToy();
                        break;
                    case "4":
                        ///presenter.clearTheList();
                        break;
                    case "5":
                        ///presenter.delToy();
                        break;
                    default:
                        System.out.println("Такой команды нет");
                        break;
                }
            }
        }
    }



}
