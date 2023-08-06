package org.example.Core.MVP;

import org.example.Animals.*;
import org.example.GroupIterator.GroupIterator;

import java.util.*;

public class Model implements Iterable<Animals> {

    static List<Animals> allAnimals = new ArrayList<Animals>();
    static List<Animals> animalsHome = new ArrayList<>();
    static List<Animals> animalsPack = new ArrayList<>();
    static List<Animals> cats = new ArrayList<Animals>();
    static List<Animals> dogs = new ArrayList<Animals>();
    static List<Animals> hamster = new ArrayList<Animals>();
    static List<Animals> horses = new ArrayList<Animals>();
    static List<Animals> camel = new ArrayList<Animals>();
    static List<Animals> donkeys = new ArrayList<Animals>();
    Integer count = 0;
    public static String database = new String("src/Database.txt");
    public static Scanner scan = new Scanner(System.in);
    Integer countAnimals = 0;

    public Model() {

        this.allAnimals = allAnimals;
    }

    /**
     * метод просмотра всех животных
     */
    public void showAllAnimals() {
        for (Animals anim : cats){
            allAnimals.add(anim);
        }
        for (Animals anim : dogs){
            allAnimals.add(anim);
        }
        for (Animals anim : hamster){
            allAnimals.add(anim);
        }
        for (Animals anim : horses){
            allAnimals.add(anim);
        }
        for (Animals anim : camel){
            allAnimals.add(anim);
        }
        for (Animals anim : donkeys){
            allAnimals.add(anim);
        }
        count = allAnimals.size();
        System.out.println("количество животных =  " + count);
        for (Animals anim : allAnimals) {
            System.out.println(anim);
        }
        allAnimals.clear();
    }

    public void addAll(Animals animals, String type){
        try {
            if(type == "CAT"){
                cats.add(animals);
            } else if (type == "DOG") {
                dogs.add(animals);
            } else if(type == "HAMSTER") {
                hamster.add(animals);
            } else if(type == "HORSES") {
                horses.add(animals);
            } else if(type == "CAMEL") {
                camel.add(animals);
            } else if(type == "DONKEYS") {
                donkeys.add(animals);
            }
            countAnimals++;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    public Animals searchAnimals(String HomePack) {
        if (HomePack == null) {
            System.out.println("Животное не найдено");
            return null;
        } else if (type(HomePack).size() == 0) {
            System.out.println("Список " + type(HomePack).size() + "пуст!!");
            return null;
        } else {
            int num = 1;
            System.out.println("Под каким номером нужно выбрать животное?");

            for (int i = 0; i < type(HomePack).size(); i++) {
                System.out.println("номер " + num++ + " -> " + type(HomePack).get(i));
            }
            Integer key = scan.nextInt();
            for (int i = 0; i < type(HomePack).size(); i++) {
                if (i == key - 1) {
                    System.out.println(type(HomePack).get(i));
                    return type(HomePack).get(i);
                }
            }
        }

//                System.out.println("номер " + num++ + " -> " + cats.get(i));
//            }

//        if(HomePack == "CAT"){
//            int num = 1;
//            System.out.println("Под каким номером нужно выбрать животное?");
//            for (int i = 0; i < cats.size(); i++) {
//                System.out.println("номер " + num++ + " -> " + cats.get(i));
//            }
//            Integer key = scan.nextInt();
//            for (int i = 0; i < cats.size(); i++) {
//                if (i == key - 1) {
//                    System.out.println(cats.get(i));
//                    return cats.get(i);
//                }
//            }
//        } else if (HomePack == "DOG") {
//            int num = 1;
//            System.out.println("Под каким номером нужно выбрать животное?");
//            for (int i = 0; i < dogs.size(); i++) {
//                System.out.println("номер " + num++ + " -> " + dogs.get(i));
//            }
//            Integer key = scan.nextInt();
//            for (int i = 0; i < dogs.size(); i++) {
//                if (i == key - 1) {
//                    System.out.println(dogs.get(i));
//                    return dogs.get(i);
//                }
//            }
//        }else if (HomePack == "HAMSTER") {
//            int num = 1;
//            System.out.println("Под каким номером нужно выбрать животное?");
//            for (int i = 0; i < hamster.size(); i++) {
//                System.out.println("номер " + num++ + " -> " + hamster.get(i));
//            }
//            Integer key = scan.nextInt();
//            for (int i = 0; i < hamster.size(); i++) {
//                if (i == key - 1) {
//                    System.out.println(hamster.get(i));
//
//                    return hamster.get(i);
//                }
//            }
//        }else if (HomePack == "HORSES") {
//            int num = 1;
//            System.out.println("Под каким номером нужно выбрать животное?");
//            for (int i = 0; i < horses.size(); i++) {
//                System.out.println("номер " + num++ + " -> " + horses.get(i));
//            }
//            Integer key = scan.nextInt();
//            for (int i = 0; i < horses.size(); i++) {
//                if (i == key - 1) {
//                    System.out.println(horses.get(i));
//
//                    return horses.get(i);
//                }
//            }
//        }else if (HomePack == "CAMEL") {
//            int num = 1;
//            System.out.println("Под каким номером нужно выбрать животное?");
//            for (int i = 0; i < horses.size(); i++) {
//                System.out.println("номер " + num++ + " -> " + camel.get(i));
//            }
//            Integer key = scan.nextInt();
//            for (int i = 0; i < horses.size(); i++) {
//                if (i == key - 1) {
//                    System.out.println(camel.get(i));
//
//                    return camel.get(i);
//                }
//            }
//        }
        return null;
    }

    public Integer sizeAllAnimals() {
        System.out.println("allAnimals.size()" + allAnimals.size()+1);
        return allAnimals.size();

    }
    public Iterator <Animals> iterator() {
        return new GroupIterator<>(allAnimals);
    }

    public void showHomeAnimals() {
        for (int i = 0; i < cats.size(); i++) {
            animalsHome.add(cats.get(i));
        }
        for (int i = 0; i < dogs.size(); i++) {
            animalsHome.add(dogs.get(i));
        }
        for (int i = 0; i < hamster.size(); i++) {
            animalsHome.add(hamster.get(i));
        }
        count = animalsHome.size();
        System.out.println("количество домашних животных =  " + count);
        for (int i = 0; i < animalsHome.size(); i++){
            System.out.println("animalsHome " + animalsHome.get(i));
        }
        animalsHome.clear();
    }

    public void showPackAnimals() {
        for (int i = 0; i < horses.size(); i++) {
            animalsPack.add(horses.get(i));
        }
        for (int i = 0; i < camel.size(); i++) {
            animalsPack.add(camel.get(i));
        }
        for (int i = 0; i < donkeys.size(); i++) {
            animalsPack.add(donkeys.get(i));
        }

        count = animalsPack.size();

        if (count == 0){
            System.out.println("количество диких животных =  " + count);
        }
        else
            for (int i = 0; i < animalsHome.size(); i++){
                System.out.println("animalsPack " + animalsPack.get(i));
        }
    }

    public void delAllAnimals() {
        cats.clear();
        dogs.clear();
        horses.clear();
        hamster.clear();
        countAnimals = 0;
    }

    public void delAnimals(Animals animals) {
        System.out.println("animals " + animals);
        System.out.println("AnimalTypeHome " + animals.getAnimalTypeHome());
        List<Animals> temp = new ArrayList<Animals>();
        temp = type(String.valueOf(animals.getAnimalTypeHome()));
        for (int i = 0; i < temp.size(); i++) {
            if (animals.getName() == temp.get(i).getName()) {
                temp.remove(i);

            }
        }
        countAnimals--;


    }
    public List<Animals> type(String HomePack) {
        if(HomePack == "CAT"){
            return cats;
        } else if (HomePack == "DOG") {
            return dogs;
        } else if (HomePack == "HAMSTER") {
            return hamster;
        } else if (HomePack == "CAMEL") {
            return camel;
        } else if (HomePack == "DONKEYS") {
            return donkeys;
        } else if (HomePack == "HORSES") {
            return horses;
        }

        return null;
    }

    public void commandsAnimals(Animals animal) {
        System.out.println(animal.getName() + " знает команд "+ animal.getCommands());
    }

    public void addCommand(Animals animal) {
        if(animal == null) {
            System.out.println("Тут животных нет... ");
        } else {
            System.out.println("команды животного "+ animal.getCommands());
            System.out.println("Какую команду добавить?");
            String command = scan.next();
            animal.setCommands(command + ", " + animal.getCommands());
            System.out.println("Теперь животное знает другие команды... "+ animal.getCommands());
        }

    }

}
