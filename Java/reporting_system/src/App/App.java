package App;

import java.util.ArrayList;

import Controller.PetController;
import Controller.PetControllerConsole;
import view.ConsoleView;
import view.View;

public class App {
    private View view;
    private PetController petController;


    public App(View view, PetController petController) {
        this.view = view;
        this.petController = petController;
    }
    
    protected void ShowMenu(){
        String menu = "1. Create Pet \n" + 
                "2. Learned commands \n" + 
                "3. Learn a new command \n" +
                "4. Exit";
        view.Set(menu);
    }

    public void Start(){
        
        Integer choise=0;
        boolean work = true;
        while (work) {
            ShowMenu();
            view.Set("Enter number of required action");
            try 
            { 
                choise = Integer.parseInt(view.Get());      
            } catch (RuntimeException e) {
                view.Set("Enter the NUMBER from 1 to 3");
            }
            switch (choise) {
                case 1:
                    petController.CreatePet();
                    view.Set("Enter any key to continue");
                    view.Get();
                    break;
                case 2:
                    petController.GetCommands();
                    view.Set("Enter any key to continue");
                    view.Get();
                    break;
                case 3:
                    petController.AddCommand();
                    view.Set("Enter any key to continue");
                    view.Get();
                    break;
                case 4:
                    work=false;
                    break;
                default:
                    view.Set("Incorrect number. Enter the NUMBER from 1 to 3");
                    break;
            }   
        }
        
    }

}
