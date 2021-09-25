package Initializers;

import Main.ApplicationClient;

public class ContextInitializer {
    public void init(){
        initEntities();
        initMenu();
        ApplicationClient applicationClient = new ApplicationClient();
        applicationClient.run();
    }
    private void initEntities(){
        EntitiesInitializer entitiesInitializer = new EntitiesInitializer();
        entitiesInitializer.init();
    }
    private void initMenu(){
        MenuInitializer menuInitializer = new MenuInitializer();
        menuInitializer.init();
    }

}
