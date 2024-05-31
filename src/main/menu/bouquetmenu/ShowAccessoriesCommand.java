package main.menu.bouquetmenu;

import main.bouquets.Bouquet;
import main.logger.Log;
import main.menu.Command;
import java.util.List;

public class ShowAccessoriesCommand implements Command {
    private final Bouquet bouquet;
    public ShowAccessoriesCommand(Bouquet bouquet) {
        this.bouquet = bouquet;
    }
    @Override
    public String getKey(){
        return "show_accessories";
    }
    @Override
    public void execute(List<String> params) {
        System.out.println("Accessories in your bouquet");
        Log.logInfo(this.getClass(), "Show Accessories");
        bouquet.showAccessories();
    }
}
