package Actions;

import Entities.Card;
import Main.Context;

import java.util.List;
import java.util.stream.Collectors;

public class UpdateDataBaseAction implements Action{
    @Override
    public void doAction() throws Exception {
        List<Card> dataBase = Context.getDataBase();
        Card currentCard = Context.getCurrentCard();

        if(currentCard.getCardNumber() == null){
            return;
        }

        List<Card> cards = dataBase.stream().filter(card -> card.getCardNumber().equals(currentCard.getCardNumber())).collect(Collectors.toList());

        if(cards.size() == 0){
            dataBase.add(new Card(currentCard.getCardNumber(),currentCard.getCardPIN(),currentCard.getMoney()));
            currentCard.setCardNumber(null);
            currentCard.setCardPIN(null);
            currentCard.setMoney(null);
            return;
        }

        cards.get(0).setMoney(currentCard.getMoney());
        currentCard.setCardNumber(null);
        currentCard.setCardPIN(null);
        currentCard.setMoney(null);
    }
}
