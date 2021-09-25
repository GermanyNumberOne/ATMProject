package MyExceptions;

public class CardAlreadyExistException extends Exception{
    public CardAlreadyExistException(){
        super("Card already exists");
    }
}
