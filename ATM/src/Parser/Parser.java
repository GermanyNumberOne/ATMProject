package Parser;

import Entities.Card;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Parser {

    public List<Card> parse(List<String> info){
        List<Card> cards = new ArrayList<>();

        for (int i = 0; i < info.size(); i++){
            String[] strings = info.get(i).split(" ");

            cards.add(new Card(strings[0], Short.parseShort(strings[1]), Long.parseLong(strings[2])));
        }

        return cards;
    }
}
