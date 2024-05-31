package gui;

import org.apache.log4j.PropertyConfigurator;

public class GUIStart {
    public static void main(final String[] args) {
        PropertyConfigurator.configure("log4j.properties");
        AppMainMenu.main(args);
    }
}
