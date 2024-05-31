package main.menu;

import main.bouquets.Bouquet;
import main.logger.Log;
import main.menu.bouquetmenu.BouquetMenu;
import main.order.Order;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class AddBouquetMenuCommand implements Command {
    private final Order order;
    protected BouquetMenu menu;
    public AddBouquetMenuCommand(Order order) {
        this.order = order;
    }
    @Override
    public String getKey(){
        return "add_bouquet";
    }
    @Override
    public void execute(List<String> params) {
        Bouquet obj = new Bouquet();

        menu = new BouquetMenu(obj);
        Scanner scanner = new Scanner(System.in);
        Log.logInfo(this.getClass(), "Bouquet created");
        System.out.println(" _Create your bouquet_ ");
        while (true) {
            System.out.println(" Input your command: ");
            List<String> command = new ArrayList<>(Arrays.asList(scanner.nextLine().split(" ")));

            if (!command.get(0).equals("back")) {
                menu.execute(command);
            } else {
                break;
            }
        }
        order.addBouquet(obj);
    }
}
