package main.menu;

import main.logger.Log;
import main.order.Order;
import java.util.List;

public class DeleteBouquetCommand implements Command {
    private final Order order;
    public DeleteBouquetCommand(Order order) {
        this.order = order;
    }
    @Override
    public String getKey(){
        return "del_bouquet";
    }
    @Override
    public String getParams(){
        return " 'index'";
    }
    @Override
    public void execute(List<String> params) {
        if (Integer.parseInt(params.get(0))-1 < order.getBouquets().size()) {
            order.delBouquet(Integer.parseInt(params.get(0))-1);
            System.out.println("Bouquet Deleted From Order");
            Log.logInfo(this.getClass(), "Bouquet Deleted From Order");
        } else {
            Log.logMail("Bouquets index out of range");
            System.out.println("Error");
        }
    }
}
