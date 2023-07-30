package org.example.UI;

import org.example.Core.MVP.Animals.AnimalType;
import org.example.Core.MVP.Animals.AnimalTypeHome;
import org.example.Core.MVP.View;

import java.util.Scanner;

public class ConsoleView implements View {

    Scanner in;
    public ConsoleView() {
        in = new Scanner(System.in);
    }

    @Override
    public AnimalType getTypeAnimals() {
        System.out.println("\033[1;34m1\033[0m - Домашнее животное " + "\n" +
                "\033[1;34m2\033[0m - Вьючное животное" + "\n");
        if (in.nextInt() == 1) {
            return AnimalType.HOME_ANIMALS;
        } else return AnimalType.PASK_ANIMALS;
    }

    @Override
    public AnimalTypeHome getTypeAnimalsHome() {
        System.out.println("\033[1;34m1\033[0m - Кошки " + "\n" +
                    "\033[1;34m2\033[0m - Собаки" + "\033[1;34m2\033[0m - Хомячки" + "\n");

        if (in.nextInt() == 1) {
            return AnimalTypeHome.CAT;
        } else if (in.nextInt() == 2) {
            return AnimalTypeHome.DOG;
        }
//        else if (in.nextInt() == 3) {
//            return AnimalTypeHome
//        }
        else System.out.println("\033[1;34mЧто-то введено не так\033[0m");
        return null;
    }

    @Override
    public String getName() {
        System.out.printf("Name: ");
        return in.nextLine();
    }

    @Override
    public String getBirthday() {
        System.out.printf("Birthday: ");
        return in.next();
    }
    @Override
    public String getCommands() {
        System.out.printf("Commands: ");
        return in.next();
    }
}
