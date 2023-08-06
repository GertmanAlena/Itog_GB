package org.example.Animals;

public class Donkeys extends Animals {

    private AnimalTypePack animalTypePack;
    private Integer classId;
    private Integer idAnimal;
    AnimalTypePack animalType;
    public Donkeys(String name, String birthday, String commands) {
        super(name, birthday, commands);
        this.animalTypePack = AnimalTypePack.DONKEYS;
    }

    @Override
    public Integer getIdAnimal() {
        return idAnimal;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId() {
        this.classId = 2;
    }


    public AnimalTypePack getAnimalTypePack() {
        return animalTypePack;
    }

    public void setAnimalTypePack() {
        this.animalTypePack = AnimalTypePack.DONKEYS;}


    @Override
    public String toString() {
        return animalType + " " + animalTypeHome + " " + classId + " " + idAnimal
                + " " + name + " " + birthday + " " + commands;
    }
}
