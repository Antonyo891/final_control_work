package Counter;
import Exception.CloseCounterException;

public class Counter implements AutoCloseable {

    private int counter;
    private boolean isOpen;

    public int add() throws CloseCounterException{
        if (!isOpen){
            throw new CloseCounterException("Counter closed");
        }
        return ++counter;
    }

    public int getCounter() {
        return counter;
    }

    public Counter(){
        isOpen = true;
    }

    public Counter(int counter) {
        this.counter = counter;
        isOpen = true;
    }

    public void closeCounter(){
        isOpen = false;
    }



    @Override
    public void close() {
        closeCounter();
    }


}
