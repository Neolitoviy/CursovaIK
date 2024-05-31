package main.flowers;

public class Tulip extends Flower {
    public Tulip(Freshness fresh, int stalk) {
        super(fresh, stalk, 32);
        switch (this.fresh) {
            case FullFresh -> super.cost = getCost();
            case MidFresh -> super.cost = getCost() * 0.7;
            case OldFresh -> super.cost = getCost() * 0.5;
        }
    }
    @Override
    public String toString() {
        return "Tulip'\n" + super.toString();
    }
}