package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.Assert.assertEquals;


@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient;


    @Test
    public void addIngredient() {
        Burger burger = new Burger();

        burger.addIngredient(ingredient);

        int expected = 1;
        int actual = burger.ingredients.size();

        assertEquals(expected, actual);
    }

    @Test
    public void removeIngredient() {
        Burger burger = new Burger();

        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);

        burger.removeIngredient(1);

        int expected = 1;
        int actual = burger.ingredients.size();

        assertEquals(expected, actual);
    }


    @Test
    public void getPrice() {

        Burger burger = new Burger();

        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        Mockito.when(bun.getPrice()).thenReturn(100f);
        Mockito.when(ingredient.getPrice()).thenReturn(100f);

        float expected = 300f;
        float actual = burger.getPrice();

        assertEquals(expected, actual, 0.1);
    }



    @Test
    public void getReceipt() {

        Burger burger = new Burger();

        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);

        Mockito.when(ingredient.getType()).thenReturn(IngredientType.valueOf("SAUCE"));
        Mockito.when(ingredient.getName()).thenReturn("cream");
        Mockito.when(bun.getName()).thenReturn("Bun");


        Mockito.when(bun.getPrice()).thenReturn(100f);
        Mockito.when(ingredient.getPrice()).thenReturn(100f);
        burger.getPrice();

        String actual = burger.getReceipt();

        String expected = "(==== Bun ====)\r\n" + "= sauce cream =\r\n" + "= sauce cream =\r\n" + "(==== Bun ====)\r\n" + "\r\n" + "Price: 400,000000\r\n";

        assertEquals(expected, actual);

    }
}