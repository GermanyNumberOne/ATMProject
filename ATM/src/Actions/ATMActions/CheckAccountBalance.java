package Actions.ATMActions;

import Actions.Action;
import Main.Context;
import MyExceptions.NotAuthorizedException;

public class CheckAccountBalance implements Action {
    @Override
    public void doAction() throws Exception {
        System.out.println("Balance: " + Context.getCurrentCard().getMoney());
    }
}
