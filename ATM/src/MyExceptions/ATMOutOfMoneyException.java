package MyExceptions;

public class ATMOutOfMoneyException extends Exception {
    public ATMOutOfMoneyException(){
        super("Atm is out of money");
    }
}
