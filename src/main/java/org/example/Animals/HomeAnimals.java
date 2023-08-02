package org.example.Animals;

public class HomeAnimals extends Animals {
    AnimalType animalType;
    public HomeAnimals(String name, String birthday, String commmands) {
        super(name, birthday, commmands);

    }

    public AnimalType getAnimalType() {
        return animalType;
    }

    public void setAnimalType(AnimalType animalType) {
        this.animalType = animalType;
    }
}
