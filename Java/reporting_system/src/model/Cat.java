package model;

import java.util.ArrayList;

public class Cat extends Pet {

    private Cat(int id, String name, ArrayList<String> commands, String birthdate) {
        super(id, name, commands, birthdate);
    }

    @Override
    public String toString() {
        return "Cat {" +
        " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", birthdate='" + getBirthdate() + "'" +
            ", commands='" + getCommands() + "'" +
            "}";
    }


}
