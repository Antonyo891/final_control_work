package model;

import java.util.ArrayList;

public class Hamster extends Pet {

    protected Hamster(int id, String name, ArrayList<String> commands, String birthdate) {
        super(id, name, commands, birthdate);
        //TODO Auto-generated constructor stub
    }


    @Override
    public String toString() {
        return "Hamster {" +
        " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", birthdate='" + getBirthdate() + "'" +
            ", commands='" + getCommands() + "'" +
            "}";
    }


}
