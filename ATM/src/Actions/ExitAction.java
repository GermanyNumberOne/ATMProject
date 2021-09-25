package Actions;

import FileActions.FileIO;
import Main.Context;

public class ExitAction implements Action{
    private final FileIO fileIO = new FileIO();

    @Override
    public void doAction() throws Exception {
        fileIO.fileOutput(Context.getDataBase());

        System.exit(0);
    }
}
