package main.flowers;

public class WhiteRose extends Rose {
    public WhiteRose(Freshness fresh, int stalk) {
        super(fresh, stalk);
        this.cost -= 2;
    }
    @Override
    public String toString() {
        return "\n'White " + super.toString();
    }
}
