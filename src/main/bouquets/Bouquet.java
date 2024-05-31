package main.bouquets;

import main.accessories.Accessory;
import main.flowers.Flower;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Bouquet {
    private String name = " ";
    protected List<Flower> flowers;
    protected List<Accessory> accessories;
    public Bouquet() {
        flowers = new ArrayList<>();
        accessories = new ArrayList<>();
    }
    public void addFlower(Flower flower) {
        flowers.add(flower);
    }
    public void addAccessory(Accessory accessory) {
        accessories.add(accessory);

    }
    public double getCost() {
        double totalFlowerSum = flowers.stream().mapToDouble(Flower::getCost).reduce(0, Double::sum);
        double totalAccessoriesSum = accessories.stream().mapToDouble(Accessory::getCost).reduce(0, Double::sum);
        return totalFlowerSum + totalAccessoriesSum;
    }
    public List<Flower> getFlowers() {
        return flowers;
    }
    public void showFlowers() {
        for (int i=0; i<flowers.size(); i++) {
            System.out.println("Index : " + (i+1));
            System.out.println("Flower : " + flowers.get(i));
        }
    }
    public void showAccessories() {
        for (int i = 0; i < accessories.size(); i++) {
            System.out.println("Index : " + (i+1));
            System.out.println("Accessory : " + accessories.get(i));
        }
    }
    public List<Accessory> getAccessories() {
        return accessories;
    }
    public void makeName(String type, int count) {
        this.name += type + " " + count + " ";
    }
    public void sortFlowersByFresh(){
        this.flowers.sort(new Comparator<Flower>() {
            @Override
            public int compare(Flower fl1, Flower fl2) {
                return fl1.getFresh().compareTo(fl2.getFresh());
            }
        });
    }
    public String getName() {
        return this.name;
    }
    @Override
    public String toString() {
        return "Bouquet: " + name + " cost: " + this.getCost();
    }
}