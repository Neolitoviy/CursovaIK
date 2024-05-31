package main;

import main.menu.MainMenu;
import org.apache.log4j.PropertyConfigurator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        PropertyConfigurator.configure("log4j.properties");
        Scanner scanner = new Scanner(System.in);
        MainMenu mainMenu = new MainMenu();
        while (true) {
            System.out.println("  __ Main Menu __");
            System.out.println("Input your command: ");
            List<String> command = new ArrayList<>(Arrays.asList(scanner.nextLine().split(" ")));
            mainMenu.execute(command);
        }
    }
}
