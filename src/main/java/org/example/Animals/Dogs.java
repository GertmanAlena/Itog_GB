package org.example.Animals;

public class Dogs extends HomeAnimals {
    AnimalTypeHome animalTypeHome;
    public Dogs(String name, String birthday, String commmands, AnimalTypeHome animalTypeHome) {
        super(name, birthday, commmands);


    }

    public AnimalTypeHome getAnimalTypeHome() {
        return animalTypeHome;
    }

    public void setAnimalTypeHome(AnimalTypeHome animalTypeHome) {
        this.animalTypeHome = animalTypeHome;
    }
}
