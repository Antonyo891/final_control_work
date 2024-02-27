package Exception;

public class PetNameException extends PetException {

    private final String name;

    public String getName() {
        return name;
    } 

    public PetNameException(String message, String name) {
        super(message);
        this.name = name;
    }

}
