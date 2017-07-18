import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;

/**
 * Created by Arcis (Hayden and Tom) on 26/05/2017.
 */
public class GameTest {
    Game testGame;
    Ball b;


    @Before
    public void setUpGame(){
       testGame = new Game();
       b = new Ball();
       testGame.initialiseGame(2);
       Player[] players = testGame.getPlayers();
       players[0] = new Player("PlayerOne");
       players[1] = new Player("PlayerTwo");
       players[0].getPets()[0] = new Penguin("TestPetForPlayerOne");
       players[1].getPets()[1] = new Penguin("TestPetForPlayerTwo");

    }


    @Test
    public void testCheckUnique(){
        testGame.addToNameList("Testname");
        assertFalse(testGame.checkUnique("Testname"));
        testGame.addToNameList("Anothertestname");
        assertTrue(testGame.checkUnique("Bob"));
        assertFalse(testGame.checkUnique("Anothertestname"));
    }


    @Test (expected = NullPointerException.class) // test which is expected to fail
    public  void testCalculateScoreFail(){
        testGame.getPlayers()[0] = null;
        testGame.calculateScore();
        testGame.getPlayers()[0].getScore();

    }

    // must create test method to test when if condition passes in calculateMood

    @Test
    public void testPlayNotBroken(){
        int result = testGame.play(testGame.getPlayers()[0],testGame.getPlayers()[0].getPets()[0],b); //not broken
        assertEquals(-1,result);
    }

    @Test
    public void testPlayBroken(){
        b.setDurability(1);
        int result = testGame.play(testGame.getPlayers()[0],testGame.getPlayers()[0].getPets()[0],b); // broken
        assertEquals(0,result);
    }

    @Test
    public void testPetHasMoreTurnsTrue(){
        assertTrue(testGame.petHasMoreTurns(testGame.getPlayers()[0].getPets()[0]));

    }

    @Test
    public void testPetHasMoreTurnsFalse(){
        testGame.getPlayers()[0].getPets()[0].setActionCount(0);
        testGame.petHasMoreTurns(testGame.getPlayers()[0].getPets()[0]);
        assertFalse( testGame.petHasMoreTurns(testGame.getPlayers()[0].getPets()[0]));
    }


}