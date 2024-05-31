package main.menu.bouquetmenu;

import main.bouquets.Bouquet;
import main.logger.Log;
import main.menu.Command;
import main.utils.BouquetUtils;
import java.util.List;

public class AddAccessoryToBouquetCommand implements Command {
    private final Bouquet bouquet;
    public AddAccessoryToBouquetCommand(Bouquet bouquet) {
        this.bouquet = bouquet;
    }
    @Override
    public String getKey(){
        return "add_accessory";
    }
    @Override
    public String getParams(){
        return " 'type' 'color'";
    }
    @Override
    public void execute(List<String> params) {
        if (params.size() == 2) {
            BouquetUtils.addAccessoryToBouquet(bouquet, params.get(0), params.get(1));
            System.out.println("Accessory added to bouquet");
            Log.logInfo(this.getClass(), "Accessory added");
        } else {
            System.out.println("Wrong parameters added");
        }
    }
}
