package Menu;

import Actions.Action;
import Main.Context;
import MyExceptions.InvalidInputException;
import ScannerUtil.ScannerUtil;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

@Getter
@Setter
public class Menu {
    private List<MenuItem> menuItems;
    private Menu anotherMenu;
    private String root;

    public void executeCommand() {
        try{
            Scanner scanner = ScannerUtil.getScanner();
            int choice = scanner.nextInt();
            if(choice > menuItems.size() || choice < 0)throw new InvalidInputException();

            menuItems.get(choice - 1).getAction().doAction();
            System.out.println();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            ScannerUtil.getScanner().nextLine();
        }
    }

    public void swapMenu(){
        this.anotherMenu.setAnotherMenu(Context.getMenu());
        Context.setMenu(this.getAnotherMenu());
    }

}
