package Initializers;


import Actions.ATMActions.CheckAccountBalance;
import Actions.ATMActions.ExitATMAction;
import Actions.ATMActions.TopUpBalanceAction;
import Actions.ATMActions.WithdrawMoneyAction;
import Actions.CardRegistrationAction;
import Actions.ExitAction;
import Actions.LogInAction;
import Main.Context;
import Menu.Menu;
import Menu.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MenuInitializer {
    public void init(){
        Menu menu = initMenu();
        menu.setAnotherMenu(initATMMenu());
        Context.setMenu(menu);
    }
    private Menu initMenu(){
        Menu menu = new Menu();
        menu.setMenuItems(initMenuItems());
        menu.setRoot("Choose menu action:");
        return menu;
    }


    private Menu initATMMenu(){
        Menu atmMenu = new Menu();
        atmMenu.setMenuItems(initATMMenuItems());
        atmMenu.setRoot("Choose atm menu action:");
        return atmMenu;
    }

    private List<MenuItem> initATMMenuItems(){
        List<MenuItem> atmMenuItems = new ArrayList<>();

        MenuItem checkBalanceItem = new MenuItem();
        checkBalanceItem.setActionName("Check balance");
        checkBalanceItem.setAction(new CheckAccountBalance());

        MenuItem withdrawItem = new MenuItem();
        withdrawItem.setActionName("Withdraw");
        withdrawItem.setAction(new WithdrawMoneyAction());

        MenuItem topUpItem = new MenuItem();
        topUpItem.setActionName("Top up");
        topUpItem.setAction(new TopUpBalanceAction());

        MenuItem exitATMItem = new MenuItem();
        exitATMItem.setActionName("Exit ATM");
        exitATMItem.setAction(new ExitATMAction());

        atmMenuItems.add(checkBalanceItem);
        atmMenuItems.add(withdrawItem);
        atmMenuItems.add(topUpItem);
        atmMenuItems.add(exitATMItem);

        return atmMenuItems;
    }

    private List<MenuItem> initMenuItems(){
        List<MenuItem> menuItems = new ArrayList<>();

        MenuItem cardRegistrationItem = new MenuItem();
        cardRegistrationItem.setActionName("Register card");
        cardRegistrationItem.setAction(new CardRegistrationAction());

        MenuItem logInItem = new MenuItem();
        logInItem.setActionName("Log in");
        logInItem.setAction(new LogInAction());

        MenuItem exitItem = new MenuItem();
        exitItem.setActionName("Exit");
        exitItem.setAction(new ExitAction());

        menuItems.add(cardRegistrationItem);
        menuItems.add(logInItem);
        menuItems.add(exitItem);

        return menuItems;
    }
}
