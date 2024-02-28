package model;

import java.util.ArrayList;

import Exception.PetNameException;

public class Hamster extends Pet {

    protected Hamster(int id, String name, ArrayList<String> commands, String birthdate) {
        super(id, name, commands, birthdate);
        super.family="Hamster";
    }

    public static Hamster create(int id, String name, ArrayList<String> commands, String birthdate) throws PetNameException {
        if (name == null) throw new PetNameException("Wrong pet name: ",name);
        return new Hamster(id, name, commands, birthdate);}

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
