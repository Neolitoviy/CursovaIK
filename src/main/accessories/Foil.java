package main.accessories;

public class Foil extends Accessory {
    public Foil(Color color) {
        super(color, 7);
    }
    @Override
    public String toString() {
        return "\n'Foil'\n" + super.toString();
    }
}