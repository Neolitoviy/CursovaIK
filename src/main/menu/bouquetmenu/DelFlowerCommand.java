package main.menu.bouquetmenu;

import main.bouquets.Bouquet;
import main.logger.Log;
import main.menu.Command;
import java.util.List;

public class DelFlowerCommand implements Command {
    private final Bouquet bouquet;
    public DelFlowerCommand(Bouquet bouquet) {
        this.bouquet = bouquet;
    }
    @Override
    public String getKey(){
        return "del_flower";
    }
    @Override
    public String getParams(){
        return " 'index'";
    }
    @Override
    public void execute(List<String> params) {
        if (Integer.parseInt(params.get(0))-1 < bouquet.getFlowers().size()) {
            bouquet.getFlowers().remove(Integer.parseInt(params.get(0)) - 1);
            System.out.println("Flower deleted from bouquet");
            Log.logInfo(this.getClass(), "Flower deleted");
        } else {
            Log.logMail("Flower index out of range");
            Log.logInfo(this.getClass(), "Flower index out of range");
            System.out.println("Error");
        }
    }
}
