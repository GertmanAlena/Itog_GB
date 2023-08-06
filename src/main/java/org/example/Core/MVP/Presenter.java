package org.example.Core.MVP;


import org.example.Animals.*;
import org.springframework.context.annotation.EnableMBeanExport;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

import static java.sql.DriverManager.getConnection;

public class Presenter {

    private View view;
    private Model model;
    Integer count = 0;

    public Presenter(View view) {
        this.view = view;
        model = new Model();
    }


    public void showAllAnimals() throws ClassNotFoundException {
        model.showAllAnimals();

    }

    public void createAnimal() throws IOException {

        AnimalType animalType = view.getTypeAnimals(); // HOME_ANIMALS или PASK_ANIMALS
        System.out.println("animalType " + animalType);
        if (animalType == AnimalType.HOME_ANIMALS) {
            AnimalTypeHome animalTypeHome = view.getTypeAnimalsHome();

            if (animalTypeHome == AnimalTypeHome.CAT) {
                Cats cat = new Cats(view.getName(), view.getBirthday(), view.getCommands());
                cat.setAnimalType(AnimalType.HOME_ANIMALS);
                cat.setClassId();
                cat.setAnimalTypeHome();
                cat.setIdAnimal(model.sizeAllAnimals());
                System.out.println("IdAnimal -> " + cat.getIdAnimal());
                System.out.println("cat -> " + cat);
                model.addAll(cat, String.valueOf(animalTypeHome));
//                model.addAnimal_HOME_ANIMALS(cat);

            } else if (animalTypeHome == AnimalTypeHome.DOG) {
                Dogs dog = new Dogs(view.getName(), view.getBirthday(), view.getCommands());
                dog.setAnimalType(AnimalType.HOME_ANIMALS);
                dog.setClassId();
                dog.setAnimalTypeHome();
                System.out.println("cat " + dog);
                model.addAll(dog, String.valueOf(animalTypeHome));

            }else if (animalTypeHome == AnimalTypeHome.HAMSTER) {
                //TODO
            }

        } else if (animalType == AnimalType.PASK_ANIMALS) {
            AnimalTypePack animalTypePack = view.getTypeAnimalsPack();
            if (animalTypePack == AnimalTypePack.HORSES){
                Horses horses = new Horses(view.getName(), view.getBirthday(), view.getCommands());
                horses.setAnimalType(AnimalType.PASK_ANIMALS);
                horses.setClassId();
                horses.setAnimalTypePack();
                System.out.println("horses " + horses);
                model.addAll(horses, String.valueOf(animalTypePack));
            } else if (animalTypePack == AnimalTypePack.CAMEL) {
                //TODO
            } else  if (animalTypePack == AnimalTypePack.DONKEYS) {
                //TODO
            }


        }
    }


    public void showHomeAnimals() {
        model.showHomeAnimals();
    }

    public void showPackAnimals() {
        model.showPackAnimals();
    }

    public void delAllAnimals() {
        model.delAllAnimals();
    }

//    public void nawCommand() {
//        AnimalType animalType = view.getTypeAnimals();
//        if (animalType == AnimalType.HOME_ANIMALS){
//            model.newCommand;
//        } else if (animalType == AnimalType.PASK_ANIMALS){
//
//        }
//
//    }

    public Animals searchAnimals() {
        AnimalType animalType = view.getTypeAnimals();
        if (animalType == AnimalType.HOME_ANIMALS){
            AnimalTypeHome animalTypeHome = view.getTypeAnimalsHome();
            Animals animals = model.searchAnimals(String.valueOf(animalType), String.valueOf(animalTypeHome));
            return animals;
        }else if (animalType == AnimalType.PASK_ANIMALS){
            AnimalTypePack animalTypePack = view.getTypeAnimalsPack();
            Animals animals = model.searchAnimals(String.valueOf(animalType), String.valueOf(animalTypePack));
            return animals;
        }

        return null;
    }

    public void dellAnimals() {
        model.delAnimals(searchAnimals());
    }

    public void commandsAnimals() {
        model.commandsAnimals(searchAnimals());
    }

    public void addCommand() {
        model.addCommand(searchAnimals());
    }
}
