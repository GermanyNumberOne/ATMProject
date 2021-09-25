package Actions.ATMActions;

import Actions.Action;
import Actions.UpdateDataBaseAction;
import Entities.ATM;
import Entities.Card;
import Main.Context;

public class ExitATMAction implements Action {
    private final Action updateDataBaseAction = new UpdateDataBaseAction();

    @Override
    public void doAction() throws Exception {
        Context.getAtm().setAuthorized(false);

        Context.getMenu().swapMenu();

        updateDataBaseAction.doAction();
    }
}
