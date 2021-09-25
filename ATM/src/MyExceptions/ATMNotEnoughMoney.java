package MyExceptions;

public class ATMNotEnoughMoney extends Exception{
    public ATMNotEnoughMoney(){
        super("There is not enough money in the ATM");
    }
}
