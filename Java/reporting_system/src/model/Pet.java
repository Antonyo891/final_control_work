package model;

import java.util.ArrayList;

import Exception.PetNameException;
import model.Pet;

public class Pet {
    protected int id;
    protected String name, birthdate, command, family;
    protected ArrayList<String> commands;

    protected Pet(int id, String name, ArrayList<String> commands, String birthdate) {
        this.id = id;
        this.name = name;
        this.commands = commands;
        this.birthdate = birthdate;
        this.family = "Pet";
    }

    public static Pet create(int id, String name, ArrayList<String> commands, String birthdate) throws PetNameException {
        if (name == null) throw new PetNameException("Wrong pet name: ",name);
        return new Pet(id, name, commands, birthdate);
    }

    public String getFamily(){
        return family;
    }
    
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getCommands() {
        return this.commands;
    }

    public void setCommands(ArrayList<String> commands) {
        this.commands = commands;
    }

    public void addCommands(String commands) {
        this.commands.add(commands);
    }

    public String getBirthdate() {
        return this.birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }


    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", birthdate='" + getBirthdate() + "'" +
            ", commands='" + getCommands() + "'" +
            "}";
    }

}
