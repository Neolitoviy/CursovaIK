package test.bouquets;

import main.bouquets.Bouquet;
import main.flowers.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class BouquetTest {
    private final Flower fl1 = new RedRose(Freshness.FullFresh, 10);
    private final Flower fl2 = new WhiteRose(Freshness.MidFresh, 10);
    private final Flower fl3 = new YellowTulip(Freshness.OldFresh, 10);
    @Test
    public void sortFlowersByFreshTest(){
        Bouquet actual = new Bouquet();
        actual.addFlower(fl1);
        actual.addFlower(fl3);
        actual.addFlower(fl2);
        actual.sortFlowersByFresh();

        Assertions.assertEquals(fl1, actual.getFlowers().get(0));
        Assertions.assertEquals(fl2, actual.getFlowers().get(1));
        Assertions.assertEquals(fl3, actual.getFlowers().get(2));
    }
}
