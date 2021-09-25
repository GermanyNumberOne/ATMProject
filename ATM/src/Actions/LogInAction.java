package Actions;

import Entities.Card;
import Main.Context;
import MyExceptions.CardNotFoundException;
import MyExceptions.InvalidInputException;
import ScannerUtil.ScannerUtil;

import java.util.Scanner;
import java.util.List;
import java.util.stream.Collectors;

public class LogInAction implements Action{
    @Override
    public void doAction() throws Exception {
        Scanner scanner = ScannerUtil.getScanner();
        Card userCard = Context.getCurrentCard();
        String cardNumber;
        short cardPIN;

        System.out.print("Enter card number(card number must be 16 numbers long): ");
        if((cardNumber = scanner.next()).length() != 16 || cardNumber.matches(".*[A-Za-zА-Яа-я]+.*"))
            throw new InvalidInputException();

        System.out.println();

        System.out.print("Enter card PIN: ");
        if((cardPIN = scanner.nextShort()) < 1000 || cardPIN > 9999)
            throw new InvalidInputException();

        System.out.println();

        userCard.setCardNumber(cardNumber);
        userCard.setCardPIN(cardPIN);

        if(!checkCard(userCard)) {
            userCard.setCardNumber(null);
            userCard.setCardPIN(null);
            userCard.setMoney(null);
            throw new CardNotFoundException();
        }
        List<Card> currentCard = Context.getDataBase().stream().filter(card -> card.getCardNumber().equals(userCard.getCardNumber())).collect(Collectors.toList());
        userCard.setMoney(currentCard.get(0).getMoney());
        System.out.println(Context.getCurrentCard().toString());

        Context.getAtm().setAuthorized(true);

        Context.getMenu().swapMenu();
        System.out.println("You logged in");
    }

    private boolean checkCard(Card card){
        if(Context.getDataBase().stream().anyMatch(card1 -> card1.getCardNumber().equals(card.getCardNumber()) && card1.getCardPIN().equals(card.getCardPIN())))
        {
            return true;
        }
        return false;
    }
}
