package main.menu.bouquetmenu;

import main.bouquets.Bouquet;
import main.logger.Log;
import main.menu.Command;
import java.util.List;

public class DelAccessoryCommand implements Command {
    private final Bouquet bouquet;
    public DelAccessoryCommand(Bouquet bouquet) {
        this.bouquet = bouquet;
    }
    @Override
    public String getKey(){
        return "del_accessory";
    }
    @Override
    public String getParams(){
        return " 'index'";
    }
    @Override
    public void execute(List<String> params) {
        if (Integer.parseInt(params.get(0))-1 < bouquet.getAccessories().size()) {
            bouquet.getAccessories().remove(Integer.parseInt(params.get(0))-1);
            System.out.println("Accessory deleted from bouquet");
            Log.logInfo(this.getClass(), "Accessory deleted");
        } else {
            Log.logMail("Accessories index out of range");
            Log.logInfo(this.getClass(), "Accessories index out of range");
            System.out.println("Error");
        }
    }
}