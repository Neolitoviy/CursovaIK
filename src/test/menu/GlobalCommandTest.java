package test.menu;

import main.bouquets.Bouquet;
import main.flowers.Freshness;
import main.menu.MainMenu;
import main.menu.bouquetmenu.BouquetMenu;
import main.utils.BouquetUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GlobalCommandTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }
    @AfterEach
    public void restoreStreams(){
        System.setOut(new PrintStream(originalOut));
    }

    @Test
    public void addBouquetMenuCommandTest() {
        System.setIn(new ByteArrayInputStream(("add_flowers redrose 3\nback\n").getBytes()));

        MainMenu menu = new MainMenu();
        menu.execute(new ArrayList<>(List.of("add_bouquet")));
        menu.execute(new ArrayList<>(List.of("show_order")));

        Assertions.assertEquals("Bouquet:  redrose 3 ", outContent.toString().split("\r\n")[7]);
    }
    @Test
    public void addAccessorryToBouquetCommandTest(){
        Bouquet bouquet = new Bouquet();
        BouquetMenu menu = new BouquetMenu(bouquet);

        menu.execute(new ArrayList<>(List.of("add_accessory", "strip", "red")));
        menu.execute(new ArrayList<>(List.of("add_accessory", "bow", "white")));
        menu.execute(new ArrayList<>(List.of("add_accessory", "foil", "gold")));

        Assertions.assertEquals("Accessory added to bouquet\r\n"+
                "Accessory added to bouquet\r\n"+
                "Accessory added to bouquet\r\n", outContent.toString());
    }
    @Test
    public void showFlowersCommandTest(){
        System.setIn(new ByteArrayInputStream(("redrose").getBytes()));
        Bouquet bouquet = new Bouquet();
        BouquetMenu menu = new BouquetMenu(bouquet);
        menu.execute(new ArrayList<>(List.of("add_flowers", "blacktulip", "1")));
        menu.execute(new ArrayList<>(List.of("add_flowers", "unittest", "1")));
        menu.execute(new ArrayList<>(List.of("show_flowers")));

        Assertions.assertTrue(outContent.toString().contains("Freshness: MidFresh; Stalk Length: 10; Cost :22.4"));
        Assertions.assertTrue(outContent.toString().contains("Такої квітки немає. Оберіть іншу: "));
        Assertions.assertEquals(12, Arrays.asList(outContent.toString().split("\n")).size());
    }
    @Test
    public void showAccessoriesCommandTest(){
        Bouquet bouquet = new Bouquet();
        BouquetMenu menu = new BouquetMenu(bouquet);
        menu.execute(new ArrayList<>(List.of("add_accessory", "bow", "white")));
        menu.execute(new ArrayList<>(List.of("show_accessories")));
        Assertions.assertTrue(outContent.toString().contains("Accessories in your bouquet"));
        Assertions.assertTrue(outContent.toString().contains("Color: WHITE; Cost: 12.0"));
    }
    @Test
    public void payOrderCommandTest(){
        System.setIn(new ByteArrayInputStream(("add_flowers redrose 1\nback\n").getBytes()));
        MainMenu menu = new MainMenu();
        menu.execute(new ArrayList<>(List.of("add_bouquet")));
        System.setIn(new ByteArrayInputStream(("UnitTest\n").getBytes()));
        menu.execute(new ArrayList<>(List.of("pay_order")));
        Assertions.assertTrue(outContent.toString().contains("Thanks for purchase!"));
    }
    @Test
    public void findStalkLengthCommandTest(){
        Bouquet bouquet = new Bouquet();
        bouquet.addFlower(BouquetUtils.createFlower("yellowtulip", Freshness.FullFresh, 20));
        bouquet.addFlower(BouquetUtils.createFlower("yellowtulip", Freshness.FullFresh, 15));
        bouquet.addFlower(BouquetUtils.createFlower("yellowtulip", Freshness.FullFresh, 10));
        BouquetMenu menu = new BouquetMenu(bouquet);
        menu.execute(new ArrayList<>(List.of("find_stalk", "14", "16")));
        Assertions.assertTrue(outContent.toString().contains("Stalk Length: 15"));
    }

}