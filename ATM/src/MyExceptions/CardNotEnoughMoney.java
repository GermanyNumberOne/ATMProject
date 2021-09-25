package MyExceptions;

public class CardNotEnoughMoney extends Exception{
    public CardNotEnoughMoney(){
        super("There is not enough money on the card");
    }
}
