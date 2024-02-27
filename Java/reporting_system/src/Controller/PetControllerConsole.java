package Controller;

import java.util.ArrayList;
import java.util.Arrays;

import Counter.Counter;
import Exception.CloseCounterException;
import Exception.PetException;
import model.Cat;
import model.Dog;
import model.Hamster;
import model.Pet;
import view.ConsoleView;
import view.View;

public class PetControllerConsole implements PetController {
    private Pet pet;
    private Counter count = new Counter(0);
    private Integer choise, id;
    private ArrayList<Pet> pets;
    private ArrayList<Integer> parser,idList;
    private ArrayList<Integer> maxDayMonth = new ArrayList<>(Arrays.asList(1,3,5,7,8,10,12));
    private ArrayList<Integer> minDayMonth = new ArrayList<>(Arrays.asList(4,6,9,11));
    private ArrayList<String> birthDate,commands;
    private String name,dateOfBirth;
    private View view;
    private String addPetsMenu = "\"1. Add Cat \\n" + //
            "\" + \r\n" + //
            "                \"2. Add Dog\\n" + //
            "\" + \r\n" + //
            "                \"3. Add Hamster \\n" + //
            "\" +\r\n" + //
            "                \"4. Save and exit \\n" + //
            "\";\r\n" + //
            "";
    @Override
    public void CreatePet() {
        commands = new ArrayList<>();
        view = new ConsoleView();
        view.Set(addPetsMenu);
        view.Set("Enter number of required action");
        boolean work = true;
        while (work) 
        {      
        try {
        choise = Integer.parseInt(view.Get());
        if ((choise>0)&&(choise<5)) work =false;
        else view.Set("Incorrect data: "+choise+". Enter  (1 .. 4)");
        } catch (RuntimeException e) {
           view.Set("Incorrect data: "+choise+". Enter  (1 .. 4)");
        }
        }
        work = true;
        while (work) 
        {
        try {
                choise = Integer.parseInt(view.Get());
                work = false;
                 } catch (RuntimeException e) {
                view.Set("Enter number from 1 to 4");
            }
        }
        view.Set("Enter Name");
        name = view.Get();
        while (name==null) {
            view.Set("Enter correct name");
            name = view.Get();
        }
        view.Set("Enter year of Birth (YYYY)");
        birthDate.add(view.Get());
        work = true;
        while (work) {  //Checking the correctness of the input YEAR
            if (birthDate.get(0).length()==4) {
                try {
                    parser.add(Integer.parseInt(birthDate.get(0)));
                    work = false;
                } catch (RuntimeException e) {
                    view.Set("Incorrect: "+birthDate.get(0)+". Enter correctly year");
                }
            }
            else view.Set("Incorrect: "+birthDate.get(0)+ ". Enter year (YYYY)");
        }
        view.Set("Enter month of Birth (MM)");
        birthDate.add(view.Get());
        work = true;
        while (work) { //Checking the correctness of the input MONTH
            if (birthDate.get(1).length()==2) {
                try {
                    parser.add(Integer.parseInt(birthDate.get(1)));
                    if ((parser.get(1)>0)&&(parser.get(1)<13)) work = false;
                    else view.Set("Month " + parser.get(1) + "Not Exist. Enter corect month (1 .. 12)");
                } catch (RuntimeException e) {
                    view.Set("Incorrect data: "+birthDate.get(1)+". Enter correctly month (1 .. 12)");
                }
            }
            else view.Set("Incorrect data: "+birthDate.get(1)+ ". Enter month (1 .. 12)");
        }

        view.Set("Enter day of the Birth (DD)");
        birthDate.add(view.Get());
        work = true;
        while (work) { //Checking the correctness of the input DAY
            if (birthDate.get(2).length()==2) {
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
                    view.Set("Incorrect data: "+birthDate.get(2)+". Enter correctly day from month:" +
                    birthDate.get(1));
                }
            }
            else view.Set("Incorrect data: "+birthDate.get(2)+ ". Enter correctly day from month:" +
                    birthDate.get(1));}
        dateOfBirth = birthDate.get(0)+"-"+birthDate.get(1)+"-"+birthDate.get(2);
        try {
            id = count.add();
        } catch (CloseCounterException e) {
            view.Set(e.getMessage());;
        }
        switch (choise) {
            case 1:
                try {
                pets.add(Cat.create(id, name,commands, dateOfBirth));
                } catch (PetException e) {
                    view.Set(e.getMessage());
                }
                break;
            case 2:
                try {
                pets.add(Dog.create(id, name,commands, dateOfBirth));
                } catch (PetException e) {
                    view.Set(e.getMessage());
                }
                break;
                case 3:
                try {
                pets.add(Hamster.create(id, name,commands, dateOfBirth));
                } catch (PetException e) {
                    view.Set(e.getMessage());
                }
                break;
            default:
                break;
        }

        throw new UnsupportedOperationException("Unimplemented method 'CreatePet'");
    }

    @Override
    public void AddCommand() {
        view.Set(pets.toString());
        view.Set("Enter Pets Id to ADD NEW COMMAND");
        for (Pet i : pets) {
            idList = new ArrayList<>();
            idList.add(i.getId());
        }
        boolean work = true;
        while (work) 
        {
        try {
            id = Integer.parseInt(view.Get());
            if (idList.contains(id)) work =false;
            else view.Set("Pets whith id - " + id + " not in List");
        } catch (RuntimeException e) {
            view.Set("Enter valid Id");
        }
        }
        throw new UnsupportedOperationException("Unimplemented method 'AddCommand'");
    }

}
