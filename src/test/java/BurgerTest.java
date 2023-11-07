import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import praktikum.*;

@RunWith(Parameterized.class)
public class BurgerTest {

    private Database database;

    @Before
    public void setUp() {
        database = new Database();
    }

    @Parameterized.Parameters
    public static List<Object[]> data() {
        return List.of(new Object[][] {
                {0}, {1}, {2}
        });
    }

    private final int bunIndex;

    public BurgerTest(int bunIndex) {
        this.bunIndex = bunIndex;
    }

    @Test
    public void testBun() {
        List<Bun> buns = database.availableBuns();
        Bun bun = buns.get(bunIndex);
        assertEquals(buns.get(bunIndex).getName(), bun.getName());
        assertEquals(buns.get(bunIndex).getPrice(), bun.getPrice(), 0);
    }

    @Test
    public void testBurger() {

        Bun bun = database.availableBuns().get(0);

        Burger burger = new Burger();
        burger.setBuns(bun);

        Ingredient sauce = Mockito.mock(Ingredient.class);
        Mockito.when(sauce.getPrice()).thenReturn(50F);

        Ingredient filling = Mockito.mock(Ingredient.class);
        Mockito.when(filling.getPrice()).thenReturn(100F);

        burger.addIngredient(sauce);
        burger.addIngredient(filling);
    }

    @Test
    public void testIngredient() {
        List<Ingredient> ingredients = database.availableIngredients();
        Ingredient ingredient = ingredients.get(0);

        assertEquals(IngredientType.SAUCE, ingredient.getType());
        assertEquals(ingredients.get(0).getName(), ingredient.getName());
        assertEquals(ingredients.get(0).getPrice(), ingredient.getPrice(), 0);
    }

    @Test
    public void testIngredientType() {
        assertEquals(2, IngredientType.values().length);
    }

    @Test
    public void testBurgerAddRemoveIngredients() {
        Burger burger = new Burger();

        List<Ingredient> ingredients = database.availableIngredients();

        burger.addIngredient(ingredients.get(0));
        burger.addIngredient(ingredients.get(1));

        assertEquals(2, burger.ingredients.size());

        burger.removeIngredient(0);

        assertEquals(1, burger.ingredients.size());
        assertEquals(ingredients.get(1), burger.ingredients.get(0));
    }

    @Test
    public void testBurgerMoveIngredient() {
        Burger burger = new Burger();

        List<Ingredient> ingredients = database.availableIngredients();

        burger.addIngredient(ingredients.get(0));
        burger.addIngredient(ingredients.get(1));
        burger.addIngredient(ingredients.get(2));

        burger.moveIngredient(0, 2);

        assertEquals(ingredients.get(1), burger.ingredients.get(0));
        assertEquals(ingredients.get(2), burger.ingredients.get(1));
        assertEquals(ingredients.get(0), burger.ingredients.get(2));
    }
}
