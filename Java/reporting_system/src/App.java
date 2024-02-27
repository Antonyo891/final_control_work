import java.util.ArrayList;

import Counter.Counter;
import Exception.CloseCounterException;
import Exception.PetNameException;
import model.Cat;
import model.Dog;
import model.Pet;

public class App {
    public static void main(String[] args) throws Exception {

        try (Counter counter = new Counter(1))
        {
            counter.add();
            System.out.println(counter.getCounter());
            counter.add();
            counter.add();
            System.out.println(counter.getCounter());
            counter.close();
            counter.add();
        }
        catch (CloseCounterException e){
            System.out.println(e.getMessage());
        }

    }
}
