package Actions;

import Entities.Card;
import Main.Context;
import MyExceptions.CardAlreadyExistException;
import MyExceptions.InvalidInputException;
import ScannerUtil.ScannerUtil;

import java.util.Scanner;
import java.util.List;

public class CardRegistrationAction implements Action {
    private final Action updateDataBaseAction = new UpdateDataBaseAction();

    @Override
    public void doAction() throws Exception{
        Scanner scanner = ScannerUtil.getScanner();
        List<Card> dataBase = Context.getDataBase();

        String cardNumber;
        short cardPIN;

        System.out.print("Enter card number(card number must be 16 numbers long): ");
        cardNumber = scanner.next();
        if (cardNumber.matches(".*[A-Za-zА-Яа-я]+.*") || cardNumber.length() != 16)
            throw new InvalidInputException();

        System.out.println();

        System.out.print("Enter card PIN(number must be less than 10000 and greater than 999): ");
        cardPIN = scanner.nextShort();
        if (cardPIN < 1000 || cardPIN > 9999)
            throw new InvalidInputException();

        System.out.println();


        Card currentCard = Context.getCurrentCard();

        currentCard.setCardNumber(cardNumber);
        currentCard.setCardPIN(cardPIN);
        currentCard.setMoney(0L);


        if(dataBase.stream().anyMatch(card -> card.getCardNumber().equals(currentCard.getCardNumber()))){
            currentCard.setCardNumber(null);
            currentCard.setCardPIN(null);
            currentCard.setMoney(null);
            throw new CardAlreadyExistException();
        }
        System.out.println("Card registered successfully");
        updateDataBaseAction.doAction();
    }


}
