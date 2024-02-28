package model;

import java.util.ArrayList;

import Exception.PetNameException;

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

    public static Dog create(int id, String name, ArrayList<String> commands, String birthdate) throws PetNameException {
        if (name == null) throw new PetNameException("Wrong pet name: ",name);
        return new Dog(id, name, commands, birthdate);}



}
