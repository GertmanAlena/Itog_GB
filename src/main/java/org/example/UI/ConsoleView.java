package org.example.UI;

import org.example.Animals.AnimalType;
import org.example.Animals.AnimalTypeHome;
import org.example.Animals.AnimalTypePack;
import org.example.Core.MVP.View;

import java.util.Scanner;

public class ConsoleView implements View {

    Scanner in;
    public ConsoleView() {
        in = new Scanner(System.in);
    }

    @Override
    public AnimalType getTypeAnimals() {
        try{
            System.out.println("\033[1;34m1\033[0m - Домашнее животное " + "\n" +
                    "\033[1;34m2\033[0m - Вьючное животное" + "\n");
            if (in.nextInt() == 1) {
                return AnimalType.HOME_ANIMALS;
            } else if (in.nextInt() == 2){
                return AnimalType.PASK_ANIMALS;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        System.out.println("\033[1;34mЧто-то введено не так\033[0m");
        return null;
    }

    @Override
    public AnimalTypeHome getTypeAnimalsHome() {
        System.out.println("\033[1;34m1\033[0m - Кошки  " + "\033[1;34m2\033[0m - Собаки  " + "\033[1;34m3\033[0m - Хомячки" + "\n");

        try{
            if (in.nextInt() == 1) {
                return AnimalTypeHome.CAT;
            } else if (in.nextInt() == 2) {
                return AnimalTypeHome.DOG;
            }
            else if (in.nextInt() == 3) {
                return AnimalTypeHome.HAMSTER;
            }

        } catch (Exception e) {
            System.out.println("\033[1;34mЧто-то введено не так\033[0m");
            throw new RuntimeException(e);

        }
        return null;
    }
    @Override
    public AnimalTypePack getTypeAnimalsPack() {
        System.out.println("\033[1;34m1\033[0m - Верблюды  " + "\033[1;34m2\033[0m - Лошади  " +
                "\033[1;34m3\033[0m - Ослики" + "\n");

        if (in.nextInt() == 1) {
            return AnimalTypePack.CAMEL;
        } else if (in.nextInt() == 2) {
            return AnimalTypePack.HORSES;
        } else if (in.nextInt() == 3) {
            return AnimalTypePack.DONKEYS;

        }
//        else if (in.nextInt() == 3) {
//            return AnimalTypeHome
//        }
        else System.out.println("\033[1;34mЧто-то введено не так\033[0m");
        return null;
    }

    @Override
    public String getName() {
        System.out.print("Name: ");
        return in.next();
    }

    @Override
    public String getBirthday() {
        System.out.print("Birthday: ");
        return in.next();
    }
    @Override
    public String getCommands() {
        System.out.print("Commands: ");
        return in.next();
    }
}
