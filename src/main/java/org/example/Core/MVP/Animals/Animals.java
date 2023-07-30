package org.example.Core.MVP.Animals;

public class Animals {

    public String name  = "Unknown";
    public String birthday;
    public String commmands;
    protected  Integer idClassAnimal;


    public Animals(String name, String birthday, String commmands) {
        this.name = name;
        this.birthday = birthday;
        this.commmands = commmands;
    }
}
