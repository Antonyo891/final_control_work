package Controller;

import java.util.ArrayList;

import model.Pet;

public interface PetController {
    void CreatePet();
    void AddCommand();
    void GetCommands();
    ArrayList<Pet> GetPets();
    void AddPets(ArrayList<Pet> pets);
    void AddPet(Pet pet);
}
