package main.accessories;

public class Bow extends Accessory {
    public Bow(Color color) {
        super(color, 12);
    }
    @Override
    public String toString() {
        return "\n'Bow'\n" + super.toString();
    }
}