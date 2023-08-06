package org.example.Animals;

public class Horses extends Animals {

    private AnimalTypePack animalTypePack;
    private Integer classId;
    private Integer idAnimal;
    public Horses(String name, String birthday, String commands) {
        super(name, birthday, commands);
        this.animalTypePack = AnimalTypePack.HORSES;
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
        this.animalTypePack = AnimalTypePack.HORSES;}


    @Override
    public String toString() {
        return name + " " + birthday + " " + commands + '\n';
    }
}
