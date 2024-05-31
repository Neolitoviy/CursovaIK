package main.menu.bouquetmenu;

import main.bouquets.Bouquet;
import main.menu.Command;
import main.menu.MainMenu;
import java.util.HashMap;

public class BouquetMenu extends MainMenu {
    private final Bouquet bouquet;
    public BouquetMenu(Bouquet bouquet) {
        this.bouquet = bouquet;
        menuItems = initializeMenu();
        help = initializeHelp();
    }
    @Override
    public HashMap<String, Command> initializeMenu() {
        HashMap<String, Command> items = new HashMap<>();

        Command newComm = new AddFlowersToBouquetCommand(bouquet);
        items.put(newComm.getKey(), newComm);

        newComm = new AddAccessoryToBouquetCommand(bouquet);
        items.put(newComm.getKey(), newComm);

        newComm = new DelFlowerCommand(bouquet);
        items.put(newComm.getKey(), newComm);

        newComm = new DelAccessoryCommand(bouquet);
        items.put(newComm.getKey(), newComm);

        newComm = new ShowFlowersCommand(bouquet);
        items.put(newComm.getKey(), newComm);

        newComm = new ShowAccessoriesCommand(bouquet);
        items.put(newComm.getKey(), newComm);

        newComm = new FindStalkLengthCommand(bouquet);
        items.put(newComm.getKey(), newComm);

        return items;
    }
}
