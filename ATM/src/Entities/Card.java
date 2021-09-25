package Entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Card {
    private String cardNumber;
    private Short cardPIN;
    private Long money;

    @Override
    public String toString() {
        return  cardNumber + " " +
                cardPIN + " "
                + money + "\n";
    }

    public Card(String cardNumber, Short cardPIN, Long money) {
        this.cardNumber = cardNumber;
        this.cardPIN = cardPIN;
        this.money = money;
    }

    public Card(){

    }
}
