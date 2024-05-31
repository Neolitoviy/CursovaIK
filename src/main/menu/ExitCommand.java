package main.menu;

import main.logger.Log;
import java.util.List;

public class ExitCommand implements Command {
    @Override
    public String getKey(){
        return "exit";
    }
    @Override
    public void execute(List<String> params) {
        System.out.println("До зустрічі");
        Log.logInfo(this.getClass(), "Exit");
        System.exit(0);
    }
}
