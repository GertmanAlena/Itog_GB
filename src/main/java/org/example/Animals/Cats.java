package org.example.Animals;

public class Cats extends Animals implements AnimalsInterface {
    private AnimalTypeHome animalTypeHome;
    private Integer classId;
    private Integer idAnimal;
    private AnimalType animalType;
    public Cats(String name, String birthday, String commands) {
        super(name, birthday, commands);
        this.animalTypeHome = AnimalTypeHome.CAT;
        this.animalType = AnimalType.HOME_ANIMALS;
        this.classId = 1;
        this.idAnimal = getIdAnimal();
    }
    @Override
    public Integer getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(Integer sizeAll) {
        this.idAnimal = sizeAll+1;
    }
    @Override
    public Integer getClassId() {
        return classId;
    }

    public void setClassId() {
        this.classId = 1;
    }

    @Override
    public AnimalTypeHome getAnimalTypeHome() {
        return animalTypeHome;
    }

    public void setAnimalTypeHome() {
        this.animalTypeHome = AnimalTypeHome.CAT;
    }

    @Override
    public String toString() {
        return animalType + " " + animalTypeHome + " " + classId + " " + idAnimal
                + " " + name + " " + birthday + " " + commands;
    }
//    @Override
//    public String toString() {
//        return name + " " + birthday + " " + commands;
//    }

}
