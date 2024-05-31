package main.menu;

import java.util.List;

public interface Command {
    void execute(List<String> params);
    String getKey();
    default String getParams(){
        return " ";
    };
}