package main.flowers;

public class BlackTulip extends Tulip {
    public BlackTulip(Freshness fresh, int stalk) {
        super(fresh, stalk);
    }
    public String toString() {
        return "\n'Black " + super.toString();
    }
}