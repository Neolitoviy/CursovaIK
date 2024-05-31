package main.menu.bouquetmenu;

import main.bouquets.Bouquet;
import main.logger.Log;
import main.menu.Command;
import main.utils.BouquetUtils;
import java.util.List;

public class AddFlowersToBouquetCommand implements Command {
    private final Bouquet bouquet;
    public AddFlowersToBouquetCommand(Bouquet bouquet) {
        this.bouquet = bouquet;
    }
    @Override
    public String getKey(){
        return "add_flowers";
    }
    @Override
    public String getParams(){
        return " 'type' 'count'";
    }
    @Override
    public void execute(List<String> params) {
        if (params.size() == 2) {
            BouquetUtils.addFlowersToBouquet(bouquet, params.get(0), Integer.parseInt(params.get(1)));
            System.out.println("Flowers added to bouquet");
            Log.logInfo(this.getClass(), "Flowers added");
        } else {
            System.out.println("Wrong parameters added");
        }
    }
}
