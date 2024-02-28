import java.util.ArrayList;

import javax.swing.text.View;

import App.App;
import Controller.PetControllerConsole;
import model.*;
import view.*;


public class Main {
    public static void main(String[] args) throws Exception {
       ArrayList<Pet> petss = new ArrayList<>();
       ArrayList<String> commandss = new ArrayList<>();
       commandss.add("Run");
       Pet cat = Cat.create(1, "Barsik", commandss, "2022-01-02");
       petss.add(cat);
       commandss = new ArrayList<>();
       commandss.add("Run");
       Pet dog = Dog.create(2, "Sharik", commandss, "2021-03-02");
       petss.add(dog);
       commandss = new ArrayList<>();
       commandss.add("Run");
       Pet hamster = Hamster.create(3, "Yarik", commandss, "2024-02-01");
       petss.add(hamster);
       PetControllerConsole controllerConsole = new PetControllerConsole(new ConsoleView());
       controllerConsole.AddPets(petss);
       App app = new App(new ConsoleView(),controllerConsole);
       app.Start();
    }
}
