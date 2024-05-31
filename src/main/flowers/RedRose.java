package main.flowers;

public class RedRose extends Rose {
    public RedRose(Freshness fresh, int stalk) {
        super(fresh, stalk);
        this.cost += 2;
    }
    @Override
    public String toString() {
        return "\n'Red " + super.toString();
    }
}