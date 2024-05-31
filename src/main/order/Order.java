package main.order;

import main.bouquets.Bouquet;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private double cost;
    protected List<Bouquet> bouquets;
    private String cardNumber;
    public Order() {
        bouquets = new ArrayList<>();
    }
    public void addBouquet(Bouquet bouquet) {
        bouquets.add(bouquet);
        this.cost += bouquet.getCost();
    }
    public void delBouquet(int index) {
        this.cost -= bouquets.get(index).getCost();
        bouquets.remove(index);

    }
    public void setCost(double cost) {
        this.cost = cost;
    }
    public void setBouquets(List<Bouquet> bouquets) {
        this.bouquets = bouquets;
    }
    public double getCost() {
        return cost;
    }
    public List<Bouquet> getBouquets() {
        return bouquets;
    }
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
    public String getCardNumber() {
        return cardNumber;
    }
}