package main.menu;

import main.order.Order;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainMenu {
    protected HashMap<String, Command> menuItems;
    protected List<String> help;
    private final Order order = new Order();

    public MainMenu() {
        menuItems = initializeMenu();
        help = initializeHelp();
    }
    protected List<String> initializeHelp() {
        List<String> initialize = new ArrayList<>();
        menuItems.forEach((k, v) -> initialize.add(k + v.getParams()));
        return initialize;
    }
    protected HashMap<String, Command> initializeMenu() {

        HashMap<String, Command> items = new HashMap<>();

        Command newComm = new AddBouquetMenuCommand(order);
        items.put(newComm.getKey(), newComm);

        newComm = new ShowOrderCommand(order);
        items.put(newComm.getKey(), newComm);

        newComm = new DeleteBouquetCommand(order);
        items.put(newComm.getKey(), newComm);

        newComm = new PayOrderCommand(order);
        items.put(newComm.getKey(), newComm);

        newComm = new CancelOrderCommand(order);
        items.put(newComm.getKey(), newComm);

        newComm = new ExitCommand();
        items.put(newComm.getKey(), newComm);

        return items;
    }
    public void execute(List<String> commandWithParams) {

        String command = commandWithParams.get(0);
        commandWithParams.remove(0);
        if (menuItems.containsKey(command)) {
            menuItems.get(command).execute(commandWithParams);
        } else if (command.equals("help")) {
            System.out.println(help);
        } else {
            System.out.println("Incorrect command! Try again or execute 'help' command ");
        }
    }
}

