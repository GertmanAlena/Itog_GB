package org.example.Animals;

public abstract class Animals {

    protected String name;
    protected String birthday;
    protected String commands;
    protected AnimalTypeHome animalTypeHome;

    private AnimalType animalType;

    public Animals(String name, String birthday, String commands) {
        this.name = name;
        this.birthday = birthday;
        this.commands = commands;
    }

//    protected AnimalTypeHome animalTypeHome;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getCommands() {
        return commands;
    }

    public void setCommands(String commands) {
        this.commands = commands;
    }

    public void setAnimalType(AnimalType animalType) {
        this.animalType = animalType;
    }

    public AnimalType getAnimalType() {
        return animalType;
    }

    public abstract Integer getIdAnimal();

    public abstract Integer getClassId();

    public AnimalTypeHome getAnimalTypeHome() {
        return animalTypeHome;
    }

}
