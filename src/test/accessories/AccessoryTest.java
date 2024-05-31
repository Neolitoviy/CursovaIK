package test.accessories;

import main.accessories.Color;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AccessoryTest {
    @Test
    public void getColorByNameTest(){
        Color expected =  Color.valueOf("RED");
        Color actual = Color.getColorByName("red");
        Assertions.assertEquals(expected, actual);
    }
}
