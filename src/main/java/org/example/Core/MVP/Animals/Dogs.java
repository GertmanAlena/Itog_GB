package org.example.Core.MVP.Animals;

public class Dogs extends HomeAnimals {
    AnimalTypeHome animalTypeHome;
    public Dogs(String name, String birthday, String commmands, AnimalTypeHome animalTypeHome) {
        super(name, birthday, commmands, animalTypeHome);
        this.animalTypeHome = animalTypeHome;

    }

}
