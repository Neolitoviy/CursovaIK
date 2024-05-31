package main.menu.bouquetmenu;

import main.bouquets.Bouquet;
import main.logger.Log;
import main.menu.Command;
import java.util.List;

public class ShowFlowersCommand implements Command {
    private final Bouquet bouquet;
    public ShowFlowersCommand(Bouquet bouquet) {
        this.bouquet = bouquet;
    }
    @Override
    public String getKey(){
        return "show_flowers";
    }
    @Override
    public void execute(List<String> params) {
        Log.logInfo(this.getClass(), "Show Flowers");
        System.out.println("Flowers in your bouquet");
        bouquet.sortFlowersByFresh();
        bouquet.showFlowers();
    }
}