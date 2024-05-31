package main.menu;

import main.logger.Log;
import main.order.Order;
import main.utils.OrderUtils;
import java.util.List;

public class ShowOrderCommand implements Command {
    private final Order order;
    public ShowOrderCommand(Order order) {
        this.order = order;
    }
    @Override
    public String getKey() {
        return "show_order";
    }
    @Override
    public void execute(List<String> params) {
        System.out.println("This is your order");
        Log.logInfo(this.getClass(), "Show Order");
        OrderUtils.showOrder(order);
    }
}