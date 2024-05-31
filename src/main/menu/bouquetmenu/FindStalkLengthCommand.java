package main.menu.bouquetmenu;

import main.bouquets.Bouquet;
import main.logger.Log;
import main.menu.Command;
import main.utils.BouquetUtils;
import java.util.List;

public class FindStalkLengthCommand implements Command {
    private final Bouquet bouquet;
    public FindStalkLengthCommand(Bouquet bouquet) {
        this.bouquet = bouquet;
    }
    @Override
    public String getKey(){
        return "find_stalk";
    }
    @Override
    public String getParams(){
        return " 'low limit' 'high limit'";
    }
    @Override
    public void execute(List<String> params) {
        Log.logInfo(this.getClass(), "Find Flowers By Stalk Length");
        BouquetUtils.findFlowerByStalkLength(bouquet, Integer.parseInt(params.get(0)), Integer.parseInt(params.get(1)));
    }
}
