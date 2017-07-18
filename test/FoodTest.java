import org.junit.Test;

import static org.junit.Assert.*;
/**
 * Created by Arcis (Hayden and Tom) on 18/04/2017.
 */
public class FoodTest {
    Food apple = new Apple();
    Food cow = new Cow();
    Food honey = new Honey();


    @Test
    public void getMealWeight() {
        assertEquals(5,apple.getMealWeight());
        assertEquals(20,honey.getMealWeight());
        assertEquals(50,cow.getMealWeight());
    }

}