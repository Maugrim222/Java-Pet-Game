import org.junit.Test;

import static org.junit.Assert.*;

import javax.swing.*;


/**
 * Created by Arcis (Hayden and Tom) on 10/04/2017.
 */
class ToyTest {
    Toy t = new Toy("Test", 20,75,20,"Test description", new ImageIcon());

    @Test
    void damage() {
        t.damage(1);
        assertEquals(74,t.getDurability());
        t.damage(4);
        assertEquals(70,t.getDurability());
        t.damage(200);
        assertEquals(0,t.getDurability());
    }
    @Test
    void isBroken() {
        t.setDurability(0);
        assertTrue(t.isBroken());
        t.setDurability(100);
        assertFalse(t.isBroken());

    }

    @Test
    void setState() {
        t.setDurability(0);
        assertTrue(t.getState().equals("broken"));
        t.setDurability(100);
        assertTrue(t.getState().equals("usable"));
    }

    @Test
    void setDurability(){
        t.setDurability(-1);
        assertEquals(0,t.getDurability());
        t.setDurability(10000);
        assertEquals(100,t.getDurability());
    }
}