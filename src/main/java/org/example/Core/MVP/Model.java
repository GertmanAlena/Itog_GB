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
    Integer count = 0;
    public static String database = new String("src/Database.txt");
    public static Scanner scan = new Scanner(System.in);

    public Model() {

        this.allAnimals = allAnimals;
    }

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
        count = allAnimals.size();
        System.out.println("количество животных =  " + count);
        for (Animals anim : allAnimals) {
            System.out.println(anim);
        }
        allAnimals.clear();
    }

    public void addAll(Animals animals, String type){
        if(type == "CAT"){
            cats.add(animals);
        } else if (type == "DOG") {
            dogs.add(animals);
        } else if(type == "HAMSTER") {
            hamster.add(animals);
        }  else if(type == "HORSES") {
            horses.add(animals);
        }
    }
//    public void newCommand(Animals animals, String type, String HomePack){
//        if(type == "CAT"){
//            for (Animals cat : cats){
//                System.out.println("cat -> " + cat);
//            }
//        }
//    }
    public Animals searchAnimals(String type, String HomePack) {
        String name = " ";
        if(HomePack == "CAT"){
            int num = 1;
            System.out.println("Под каким номером нужно выбрать животное?");
            for (int i = 0; i < cats.size(); i++) {
                System.out.println("номер " + num++ + " -> " + cats.get(i));
            }
            Integer key = scan.nextInt();
            for (int i = 0; i < cats.size(); i++) {
                if (i == key - 1) {
                    System.out.println(cats.get(i));
                    name = cats.get(i).getName();
                    return cats.get(i);
                }
            }
        } else if (HomePack == "DOG") {
            int num = 1;
            System.out.println("Под каким номером нужно выбрать животное?");
            for (int i = 0; i < dogs.size(); i++) {
                System.out.println("номер " + num++ + " -> " + dogs.get(i));
            }
            Integer key = scan.nextInt();
            for (int i = 0; i < dogs.size(); i++) {
                if (i == key - 1) {
                    System.out.println(dogs.get(i));
                    name = dogs.get(i).getName();
                    return dogs.get(i);
                }
            }
        }else if (HomePack == "HAMSTER") {
            int num = 1;
            System.out.println("Под каким номером нужно выбрать животное?");
            for (int i = 0; i < hamster.size(); i++) {
                System.out.println("номер " + num++ + " -> " + hamster.get(i));
            }
            Integer key = scan.nextInt();
            for (int i = 0; i < hamster.size(); i++) {
                if (i == key - 1) {
                    System.out.println(hamster.get(i));

                    return hamster.get(i);
                }
            }
        }else if (HomePack == "HORSES") {
            int num = 1;
            System.out.println("Под каким номером нужно выбрать животное?");
            for (int i = 0; i < horses.size(); i++) {
                System.out.println("номер " + num++ + " -> " + horses.get(i));
            }
            Integer key = scan.nextInt();
            for (int i = 0; i < horses.size(); i++) {
                if (i == key - 1) {
                    System.out.println(horses.get(i));

                    return horses.get(i);
                }
            }
        }
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


    }
    public List<Animals> type(String HomePack) {
        if(HomePack == "CAT"){
            return cats;
        } else if (HomePack == "DOG") {
            return dogs;
        }

        return null;
    }

    public void commandsAnimals(Animals animal) {
        System.out.println(animal.getName() + " знает команд "+ animal.getCommands());
    }

    public void addCommand(Animals animal) {
        System.out.println("команды животного "+ animal.getCommands());
        System.out.println("Какую команду добавить?");
        String command = scan.next();
        animal.setCommands(command + ", " + animal.getCommands());
        System.out.println("Теперь животное знает другие команды... "+ animal.getCommands());
    }

}
