package Initializers;

import Entities.ATM;
import Entities.Card;
import FileActions.FileIO;
import Main.Context;
import Parser.Parser;

import java.util.ArrayList;
import java.util.List;


public class EntitiesInitializer {
    private final FileIO fileIO = new FileIO();
    private final Parser parser = new Parser();

    public void init(){
       Context.setAtm(atmInit());
       Context.setDataBase(dataBaseInit());
       Context.setCurrentCard(currentCardInit());
    }

    private ATM atmInit(){
        ATM atm = new ATM();
        atm.setAtmMoney(100000000L);
        return atm;
    }

    private List<Card> dataBaseInit(){
        List<Card> dataBase = new ArrayList<>();

        List<String> file = fileIO.fileInput();

        if(file.size() == 1 && file.get(0).length() < 21){
            file.clear();
        }

        if(file.size() != 0)
            dataBase = parser.parse(file);

        return dataBase;
    }

    private Card currentCardInit(){
        Card card = new Card();

        return card;
    }
}
