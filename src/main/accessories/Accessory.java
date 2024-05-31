package main.accessories;

public abstract class Accessory {
    protected Color color;
    protected double cost;

    public Accessory(Color color, double cost) {
        this.color = color;
        this.cost = cost;
    }
    public double getCost() {
        return cost;
    }
    @Override
    public String toString() {
        return "Color: " + color + "; Cost: " + cost;
    }
}
