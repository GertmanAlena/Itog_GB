package org.example.Core.MVP.Animals;

public class Cats extends HomeAnimals {
    AnimalTypeHome animalTypeHome;
    public Cats(String name, String birthday, String commmands, AnimalTypeHome animalTypeHome) {
        super(name, birthday, commmands, animalTypeHome);
        this.animalTypeHome = animalTypeHome;

    }

}
