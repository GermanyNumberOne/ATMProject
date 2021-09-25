package Actions.ATMActions;

import Actions.Action;
import Entities.ATM;
import Entities.Card;
import Main.Context;
import MyExceptions.ATMNotEnoughMoney;
import MyExceptions.ATMOutOfMoneyException;
import MyExceptions.CardNotEnoughMoney;
import MyExceptions.InvalidInputException;
import ScannerUtil.ScannerUtil;

import java.util.Scanner;

public class WithdrawMoneyAction implements Action {
    @Override
    public void doAction() throws Exception {
        Scanner scanner = ScannerUtil.getScanner();
        ATM atm = Context.getAtm();
        Card card = Context.getCurrentCard();


        if(atm.getAtmMoney() <= 0){
            throw new ATMOutOfMoneyException();
        }

        long moneyToWithdraw;

        System.out.print("Enter the amount you want to withdraw: ");
        moneyToWithdraw = scanner.nextLong();
        System.out.println();

        if(moneyToWithdraw <= 0)
            throw new InvalidInputException();

        if(moneyToWithdraw > atm.getAtmMoney()){
            throw new ATMNotEnoughMoney();
        }

        if(moneyToWithdraw > card.getMoney()){
            throw new CardNotEnoughMoney();
        }

        card.setMoney(card.getMoney() - moneyToWithdraw);
        System.out.println("Success");
    }
}
