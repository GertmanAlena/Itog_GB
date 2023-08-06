package org.example.Core.MVP;

import org.example.Animals.AnimalTypeHome;
import org.example.Animals.AnimalTypePack;

public interface View {

    Object getTypeAnimals();
    String getBirthday();


    AnimalTypeHome getTypeAnimalsHome();

    AnimalTypePack getTypeAnimalsPack();

    String getName();



    String getCommands();
}
