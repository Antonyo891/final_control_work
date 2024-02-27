import java.util.ArrayList;

import Exception.PetNameException;
import model.Cat;
import model.Dog;
import model.Pet;

public class App {
    public static void main(String[] args) throws Exception {

        ArrayList<String> commands = new ArrayList<>();
        commands.add("Jump");
        Pet Barsik;
        try {
            Barsik = Dog.create(0, "null", commands, "2022-10-11");
            System.out.println(Barsik.toString());
        } catch (PetNameException e) {
            System.out.println(e.getMessage()+" "+ e.getName());
        }

    }
}
