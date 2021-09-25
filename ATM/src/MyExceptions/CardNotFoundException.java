package MyExceptions;

import java.util.InputMismatchException;

public class CardNotFoundException extends Exception{
    public CardNotFoundException(){
        super("Card not found");
    }
}
