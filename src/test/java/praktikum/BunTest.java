package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;



@RunWith(Parameterized.class)
public class BunTest {

    private final String name;
    private final float price;


           public BunTest(String name, float price){
               this.name = name;
               this.price = price;
           }

    @Parameterized.Parameters
    public static Object[][] bunParameters() {
        return new Object[][]{
                {"black bun", 100, },
                {"white bun", 200},
        };
    }


    @Test
    public void getName() {
        Bun bun = new Bun(name, price);

        String actual= bun.getName();

        Assert.assertEquals(name, actual);
    }

    @Test
    public void getPrice() {

        Bun bun = new Bun(name, price);

         float actual= bun.getPrice();
        Assert.assertEquals(price, actual, 0.1);
    }
}
