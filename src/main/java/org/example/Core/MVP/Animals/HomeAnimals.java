package org.example.Core.MVP.Animals;

public class HomeAnimals extends Animals {
    AnimalType animalType;
    public HomeAnimals(String name, String birthday, String commmands, AnimalTypeHome animalType) {
        super(name, birthday, commmands);
        this.animalType = AnimalType.HOME_ANIMALS;
    }
}
