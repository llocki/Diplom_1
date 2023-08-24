package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTest {

    private final IngredientType type;
    private final String name;
    private final float price;

    public IngredientTest(IngredientType type, String name, float price){
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getIngredient() {
        return new Object[][]{
                {IngredientType.SAUCE, "hot sauce", 100},
                {IngredientType.FILLING, "sour cream", 200},
                {null, "chili sauce", 300},
        };
    }
    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
    }



    @Test
    public void getPrice() {

        Ingredient ingredient = new Ingredient(type, name, price);

        float actual = ingredient.getPrice();

        assertEquals(price, actual, 0.1);
    }


    @Test
    public void getName() {
        Ingredient ingredient = new Ingredient(type, name, price);

        String actual = ingredient.getName();

        assertEquals(name, actual);
    }

    @Test
    public void getType() {
        Ingredient ingredient = new Ingredient(type, name, price);

        IngredientType actual = ingredient.getType();

        assertEquals(type, actual);
    }

}
