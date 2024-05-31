package main.utils;

import main.bouquets.Bouquet;
import main.order.Order;
import main.logger.Log;
import database.SQLDatabaseConnection;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderUtils {

    public static void showOrder(Order order) {
        System.out.println("Total Cost: " + order.getCost());
        System.out.println("Bouquets: ");
        List<Bouquet> bouquets = order.getBouquets();
        for (int i = 1; i <= bouquets.size(); i++) {
            System.out.println("Bouquet: " + bouquets.get(i-1).getName());
            System.out.println("Cost: " + bouquets.get(i-1).getCost());
        }
    }

    public static void saveCheck(Order order) {
        try (FileWriter fw = new FileWriter("check.txt")) {
            fw.write("Card Number: " + order.getCardNumber());
            fw.write("\nBouquets: ");
            for (int i = 1; i <= order.getBouquets().size(); i++) {
                fw.write("Bouquet: " + order.getBouquets().get(i-1).getName());
                fw.write("Cost: " + order.getBouquets().get(i-1).getCost());
            }
            fw.write("\nTotal Cost: " + order.getCost());
        } catch (IOException e) {
            Log.logMail("Error writing check to file: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public static void payOrder(Order order) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть номер картки: ");
        order.setCardNumber(scanner.nextLine());
    }

    public static void cancelOrder(Order order){
        order.setCost(0);
        order.setBouquets(new ArrayList<>());
    }

    public static void saveOrder(Order order){
        try (Connection conn = SQLDatabaseConnection.getConnection()) {
            String sql = "INSERT INTO orders (cost, card_num) VALUES (?, ?)";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setDouble(1, order.getCost());
                pstmt.setString(2, order.getCardNumber());
                pstmt.executeUpdate();
                Log.logInfo(OrderUtils.class, "Order saved successfully");
            }
        } catch (SQLException e) {
            Log.logMail("Database connection failed: " + e.getMessage());
            System.out.println("Connection to database failed, contact with admin");
            e.printStackTrace();
        }
    }
}
