package praktikum;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class BurgerTestNotMocks {

    @Test
    public void setBuns() {
        Database database = new Database();
        Burger burger = new Burger();

        List<Bun> buns = database.availableBuns();

        burger.setBuns(buns.get(0));

        Bun bun = burger.bun;

        String actual = bun.name;
        String expected = "black bun";

        assertEquals(expected, actual);
    }

    @Test
    public void moveIngredient() {

        Database database = new Database();
        Burger burger = new Burger();

        burger.ingredients = database.availableIngredients();

        burger.moveIngredient(2, 1);

        Ingredient ingredient = burger.ingredients.get(1);

        String expected = "chili sauce";

        String actual = ingredient.name;

        assertEquals(expected, actual);
    }





}
