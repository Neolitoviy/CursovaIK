package main.flowers;

public class YellowTulip extends Tulip {
    public YellowTulip(Freshness fresh, int stalk) {
        super(fresh, stalk);
    }
    public String toString() {
        return "\n'Yellow " + super.toString();
    }
}