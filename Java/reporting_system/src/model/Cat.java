package model;

import java.util.ArrayList;

import Exception.PetNameException;

public class Cat extends Pet {

    private Cat(int id, String name, ArrayList<String> commands, String birthdate) {
        super(id, name, commands, birthdate);
        super.family = "Cat";
    }
    
    public static Cat create(int id, String name, ArrayList<String> commands, String birthdate) throws PetNameException {
        if (name == null) throw new PetNameException("Wrong pet name: ",name);
        return new Cat(id, name, commands, birthdate);}


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
