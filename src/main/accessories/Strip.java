package main.accessories;

public class Strip extends Accessory {
    public Strip(Color color) {
        super(color, 5);
    }
    @Override
    public String toString() {
        return "\n'Strip'\n" + super.toString();
    }
}
