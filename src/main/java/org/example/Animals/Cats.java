package org.example.Animals;

public class Cats extends HomeAnimals {

//    public Cat() {
//        this.animalTypeHome = AnimalTypeHome.CAT;
//    }
    private Integer classId;
    public Cats(String name, String birthday, String commands) {
        super(name, birthday, commands);
        this.animalTypeHome = AnimalTypeHome.CAT;
        this.classId = 1;
    }

//    public AnimalTypeHome getAnimalTypeHome() {
//        return animalTypeHome;
//    }
//
//    public void setAnimalTypeHome(AnimalTypeHome animalTypeHome) {
//        this.animalTypeHome = animalTypeHome;
//    }

    @Override
    public String toString() {
        return id + " " + name + " " + birthday + " " + commands + " " + animalTypeHome;
    }
}
