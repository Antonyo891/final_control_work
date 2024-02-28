package Controller;

import java.util.ArrayList;
import java.util.Arrays;

import Counter.Counter;
import Exception.CloseCounterException;
import Exception.PetException;
import Exception.PetNameException;
import model.Cat;
import model.Dog;
import model.Hamster;
import model.Pet;
import view.ConsoleView;
import view.View;

public class PetControllerConsole implements PetController {
    private Pet pet;
    private Counter count;
    private Integer choise, id;
    private ArrayList<Pet> pets;
    private ArrayList<Integer> parser,idList;
    private ArrayList<Integer> maxDayMonth;
    private ArrayList<Integer> minDayMonth;
    private ArrayList<String> birthDate,commands;
    private String name,dateOfBirth,command,newCommand;
    private View view;
    private String addPetsMenu;


    public PetControllerConsole(View view) {
        this.count = new Counter(4);
        this.view = view;
        this.id = null;
        this.pets = new ArrayList<>();
        this.maxDayMonth = new ArrayList<>(Arrays.asList(1,3,5,7,8,10,12));
        this.minDayMonth = new ArrayList<>(Arrays.asList(4,6,9,11));
        this.addPetsMenu = "1. Add Cat \n" +
            "\r\n" + "2. Add Dog\n" + 
            "\r\n" + "3. Add Hamster \n" + 
            "\r\n" +  "4. Back \n";
    }
    


    @Override
    public void CreatePet() {
        this.commands = new ArrayList<>();
        view = new ConsoleView();
        view.Set(addPetsMenu);
        view.Set("Enter number of required action");
        boolean work = true;
        while (work) 
        {      
        try {
        choise = Integer.parseInt(view.Get());
        if ((choise>0)&&(choise<4)) work =false;
        else if (choise==4) return;
        else view.Set("Incorrect data: "+choise+". Enter  (1 .. 4)");
        } catch (RuntimeException e) {
           view.Set("Incorrect data: "+choise+". Enter  (1 .. 4)");
        }
        }
        view.Set("Enter Name");
        name = view.Get();
        while (name==null) {
            view.Set("Enter correct name");
            name = view.Get();
        }
        view.Set("Enter Command");
        command = view.Get();
        while (name==null) {
            view.Set("Enter correct command");
            command  = view.Get();
        }
        commands.add(command);
        birthDate = new ArrayList<>();
        parser = new ArrayList<>();
        work = true;
        view.Set("Enter year of Birth (YYYY)");
        while (work) {
            if (birthDate.size()>0) birthDate.remove(0);
            birthDate.add(view.Get());
            if (birthDate.get(0).length()==4) { //Checking the correctness of the input YEAR
                try {
                    parser.add(Integer.parseInt(birthDate.get(0)));
                    work = false;
                } catch (RuntimeException e) {
                    view.Set(e.getMessage());
                    view.Set("Incorrect: "+birthDate.get(0)+". Enter correctly year");
                }
            }
            else view.Set("Incorrect: "+birthDate.get(0)+ ". Enter year (YYYY)");
        }
        view.Set("Enter month of the Birth (MM)");
        work = true;
        while (work) { 
            if (birthDate.size()>1) birthDate.remove(1);
            if (parser.size()>1) parser.remove(1);
            birthDate.add(view.Get());
            if (birthDate.get(1).length()==2) { //Checking the correctness of the input MONTH
                try {
                    parser.add(Integer.parseInt(birthDate.get(1)));
                    if ((parser.get(1)>0)&&(parser.get(1)<13)) work = false;
                    else view.Set("Month " + parser.get(1) + " is not Exist. Enter corect month (01 .. 12)");
                } catch (RuntimeException e) {
                    view.Set("Incorrect data: "+birthDate.get(1)+". Enter correctly month (01 .. 12)");
                }
            }
            else view.Set("Incorrect data: "+birthDate.get(1)+ ". Enter month (01 .. 12)");
        }

        view.Set("Enter day of the Birth (DD)");
        work = true;
        while (work) { 
            if (birthDate.size()>2) birthDate.remove(2); 
            if (parser.size()>2) parser.remove(2);
            birthDate.add(view.Get());
            if (birthDate.get(2).length()==2) { //Checking the correctness of the input DAY
                try {
                    parser.add(Integer.parseInt(birthDate.get(2)));
                    if (maxDayMonth.contains(parser.get(1))&&(
                    (parser.get(2)>0))&&(parser.get(2)<32)) work = false;
                    else if (minDayMonth.contains(parser.get(1))&&(
                    (parser.get(2)>0))&&(parser.get(2)<31)) work = false;
                    else if ((parser.get(1)==2)&&(
                    (parser.get(2)>0))&&(parser.get(2)<30)) work = false;
                    else view.Set("Day " + parser.get(2) + " Incorrect. Enter correct day from month:" +
                    birthDate.get(1));
                } catch (RuntimeException e) {
                    view.Set("Incorrect data: "+birthDate.get(2)+". Enter correctly day from month (DD):" +
                    birthDate.get(1));
                }
            }
            else view.Set("Incorrect data: "+birthDate.get(2)+ ". Enter correctly day from month (DD):" +
                    birthDate.get(1));}
        
        dateOfBirth = birthDate.get(0)+"-"+birthDate.get(1)+"-"+birthDate.get(2);
        
        if (pets==null) pets = new ArrayList<>();

        try {
            id = count.add();
        } catch (CloseCounterException e) {
            view.Set(e.getMessage());;
        }
        switch (choise) {
            case 1:
                try {
                this.pet = Cat.create(id, name,commands, dateOfBirth);
                pets.add(this.pet);
                } catch (PetException e) {
                    view.Set(e.getMessage());
                }
                view.Set("Cat - " + name + "add to the nursery");
                break;
            case 2:
                try {
                this.pet = Dog.create(id, name,commands, dateOfBirth);
                pets.add(this.pet);
                } catch (PetException e) {
                    view.Set(e.getMessage());
                }
                view.Set("Dog - " + name + "add to the nursery");
                break;
                case 3:
                try {
                this.pet = Hamster.create(id, name,commands, dateOfBirth);
                pets.add(this.pet);
                } catch (PetException e) {
                    view.Set(e.getMessage());
                }
                view.Set("Hamster - " + name + "add to the nursery");
                break;
        }
    }

    

    @Override
    public void AddCommand() {
        newCommand = null;
        this.id = null;
        for (Pet tempPet : pets) {
        view.Set(tempPet.toString());    
        }
        view.Set("Enter Pets Id to ADD NEW COMMAND");
        idList = new ArrayList<>();
        for (Pet i : pets) {
            idList.add(i.getId());
        }
        boolean work = true;
        while (work) 
        {
        try {
            this.id = Integer.parseInt(view.Get());
            if (idList.contains(this.id)) work =false;
            else view.Set("Pets whith id - " + id + " not in List");
        } catch (RuntimeException e) {
            view.Set("Enter valid Id");
        }
        }
        for (int i=0;i<pets.size();i++) {
          if (this.id == pets.get(i).getId()){
            view.Set(pets.get(i).getName() + " can " + pets.get(i).getCommands());
            view.Set("Enter new command");
            newCommand = view.Get();
            pets.get(i).addCommands(newCommand);
            view.Set("Pet " + pets.get(i).getName()+ " learned a new command" + newCommand);
          }    
        }
    }

    public void ViewPets(){
        view.Set(pets.toString());
    }

     public ArrayList<Pet> GetPets(){
        return this.pets;
    }

    public void GetCommands(){
        String output = "";
        for (int i=0;i<pets.size();i++) {
            output = output + "\n" + pets.get(i).getFamily() + " " + pets.get(i).getName() + " can -" +
            pets.get(i).getCommands(); 
        }
        view.Set(output);
    }

    public void AddPets(ArrayList<Pet> pets){
        for (int i=0;i<pets.size();i++) {
            this.AddPet(pets.get(i));
        }
    }

    @Override
    public void AddPet(Pet petAdd) {
        Integer idAdd = 0;
        try {
            idAdd = count.add();
        } catch (Exception e) {
            // TODO: handle exception
        }
        if (petAdd.getFamily().equals("Cat")) {
            try {
            this.pets.add(Cat.create(idAdd, petAdd.getName(), petAdd.getCommands(), petAdd.getBirthdate()));    
            } catch (PetNameException e) {
                view.Set(e.getMessage());
        }} else if (petAdd.getFamily().equals("Dog")) {
            try {
            this.pets.add(Dog.create(idAdd, petAdd.getName(), petAdd.getCommands(), petAdd.getBirthdate()));    
            } catch (PetNameException e) {
                view.Set(e.getMessage());
            }            
        }  else if (petAdd.getFamily().equals("Hamster")) {
            try {
            this.pets.add(Hamster.create(idAdd, petAdd.getName(), petAdd.getCommands(), petAdd.getBirthdate()));    
            } catch (PetNameException e) {
                view.Set(e.getMessage());
            }
    }
}}
