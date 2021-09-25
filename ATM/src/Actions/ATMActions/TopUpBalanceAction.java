package Actions.ATMActions;

import Actions.Action;
import Entities.Card;
import Main.Context;
import MyExceptions.InvalidInputException;
import ScannerUtil.ScannerUtil;

import java.util.Scanner;

public class TopUpBalanceAction implements Action {
    @Override
    public void doAction() throws Exception {
        Scanner scanner = ScannerUtil.getScanner();

        long topUpMoney;
        System.out.print("Enter the amount you want top up(it mustn't be greater than 1.000.000): ");
        topUpMoney = scanner.nextLong();
        System.out.println();

        if(topUpMoney < 0 || topUpMoney > 1000000){
            throw new InvalidInputException();
        }

        Card card = Context.getCurrentCard();
        topUpMoney += card.getMoney();
        card.setMoney(topUpMoney);
        System.out.println("Success");
    }
}
