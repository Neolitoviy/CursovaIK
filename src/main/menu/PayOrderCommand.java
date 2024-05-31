package main.menu;

import main.logger.Log;
import main.order.Order;
import main.utils.OrderUtils;
import java.util.List;

public class PayOrderCommand implements Command {
    private final Order order;
    public PayOrderCommand(Order order) {
        this.order = order;
    }
    @Override
    public String getKey(){
        return "pay_order";
    }
    @Override
    public void execute(List<String> params) {
        OrderUtils.payOrder(order);
        OrderUtils.saveCheck(order);
        OrderUtils.saveOrder(order);
        OrderUtils.cancelOrder(order);
        Log.logInfo(this.getClass(), "Order payed, Check gived, Order saved, Order canceled");
        System.out.println("Thanks for purchase!");
        Log.logInfo(this.getClass(), "order payed");
    }
}
