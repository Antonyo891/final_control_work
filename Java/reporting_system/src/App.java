

import java.util.ArrayList;

import javax.swing.text.View;

import Controller.PetControllerConsole;
import model.Pet;
import view.ConsoleView;


public class App {
    public static void main(String[] args) throws Exception {
       PetControllerConsole controller = new PetControllerConsole();
       ConsoleView view = new ConsoleView();
       controller.CreatePet();
       controller.ViewPets();
       ArrayList<Pet> pets = new ArrayList<>();
       pets = controller.GetPets();
       for (Pet pet : pets) {
        view.Set(pet.getFamily()+ " " + pet);
       } 
    
    }
}
