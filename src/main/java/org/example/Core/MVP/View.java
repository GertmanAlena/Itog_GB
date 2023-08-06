package org.example.Core.MVP;

import org.example.Animals.AnimalType;
import org.example.Animals.AnimalTypeHome;
import org.example.Animals.AnimalTypePack;

public interface View {

    AnimalType getTypeAnimals();
    String getBirthday();


    AnimalTypeHome getTypeAnimalsHome();

    AnimalTypePack getTypeAnimalsPack();

    String getName();



    String getCommands();
}
