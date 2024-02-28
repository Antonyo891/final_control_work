package model;

import java.util.ArrayList;

public class Dog extends Pet {

    @Override
    public String toString() {
        return "Dog {" +
        " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", birthdate='" + getBirthdate() + "'" +
            ", commands='" + getCommands() + "'" +
            "}";
    }

    private Dog(int id, String name, ArrayList<String> commands, String birthdate) {
        super(id, name, commands, birthdate);
        super.family = "Dog";
    }



}
