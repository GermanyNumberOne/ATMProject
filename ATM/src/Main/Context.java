package Main;

import Entities.ATM;
import Entities.Card;
import Menu.Menu;
import lombok.Getter;
import lombok.Setter;


import java.util.List;


public class Context {
    @Getter
    @Setter
    private static ATM atm;

    @Getter
    @Setter
    private static Card currentCard;

    @Getter
    @Setter
    private static List<Card> dataBase;

    @Getter
    @Setter
    private static Menu menu;

}
