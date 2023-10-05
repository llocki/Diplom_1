package praktikum;

import org.junit.Test;


public class IngredientTypeTest {


    @Test
    public void valueOfSAUCE() {
        IngredientType.valueOf("SAUCE");

    }

    @Test
    public void valueOfFILLING() {
        IngredientType.valueOf("FILLING");

    }
}