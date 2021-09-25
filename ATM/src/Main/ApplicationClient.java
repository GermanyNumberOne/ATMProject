package Main;

import Menu.MenuItem;
import ScannerUtil.ScannerUtil;

import java.util.Scanner;

public class ApplicationClient {
    public void run(){
        Scanner scanner = ScannerUtil.getScanner();
        while(true){
                System.out.println(Context.getMenu().getRoot());
                Context.getMenu().getMenuItems().forEach(
                        menuItem -> System.out.println(Context.getMenu().getMenuItems().indexOf(menuItem) + 1 + ". "
                                + menuItem.getActionName()));
                Context.getMenu().executeCommand();
        }
    }
}
