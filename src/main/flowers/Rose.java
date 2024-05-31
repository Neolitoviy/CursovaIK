package main.flowers;

public class Rose extends Flower {
    public Rose(Freshness fresh, int stalk) {
        super(fresh, stalk, 30);
        switch (this.fresh) {
            case FullFresh -> super.cost = getCost();
            case MidFresh -> super.cost = getCost() * 0.8;
            case OldFresh -> super.cost = getCost() * 0.5;
        }
    }
    @Override
    public String toString() {
        return "Rose'\n" + super.toString();
    }
}