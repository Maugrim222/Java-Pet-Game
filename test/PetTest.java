import org.junit.Test;


import static org.junit.Assert.*;

/**
 * Created by Arcis on 15/04/2017.
 */
public class PetTest {
    Pet testPet = new Pet("test","test",10,"Food", "Ball", 12,1,2,3,"asf");
    Pet testPet1 = new Dog("Test Dog");
    Pet testPet2 = new FoxyFox("Test Fox");
    Toy testToy1 = new Ball();
    Toy testToy2 =  new Ball();
    Food testFood1 = new DogFood();


    @Test
    public void testRound() {
        int x = 101;
        int y = -1;
        int z = 49;
        assertEquals(100,Pet.round(x));
        assertEquals(0,Pet.round(y));
        assertEquals(49, Pet.round(z));
    }

    @Test
    public void testPlayHungerLevel() {
        testPet1.play(testToy1); //testing against favourite toy
        testPet2.play(testToy1); //testing against 'normal' toy
        assertEquals(90,testPet1.getHungerLevel()); //tests hunger level decrease
        assertEquals(90,testPet2.getHungerLevel()); //should be same as playing with non-fav toy
    }

    @Test
    public void testPlayMoodLevel(){
        testPet1.setMoodLevel(0); //set to 0 so can see increase to mood when playing with toys
        testPet2.setMoodLevel(0);
        testPet1.play(testToy1); //play with fav toy
        testPet2.play(testToy1); //play with non-fav toy
        assertEquals(38,testPet1.getMoodLevel()); //test against fav toy
        assertEquals(24,testPet2.getMoodLevel()); //test against non-fav toy

    }

    @Test
    public void testPlayEnergyLevel(){
        testPet1.play(testToy1); //play with favourite toy
        testPet2.play(testToy1); //non-fav toy
        assertEquals(80,testPet1.getEnergy());
        assertEquals(80,testPet2.getEnergy());


    }
    @Test
    public void testPlayToyDamage(){
        testPet.play(testToy1);
        assertEquals(3,testToy1.getDurability());
        testPet1.play(testToy1); //test with two different pets same toy
        testPet2.play(testToy2);
        assertEquals(0,testToy1.getDurability());
        assertEquals(6,testToy2.getDurability());

    }


    @Test
    public void testEatMoodLevel() {
        testPet1.setMoodLevel(0);
        testPet2.setMoodLevel(0);
        testPet1.eat(testFood1);
        testPet2.eat(testFood1);
        assertEquals(35,testPet1.getMoodLevel());//favourite food
        assertEquals(15,testPet2.getMoodLevel());//non favourite food
    }

    @Test
    public void testEatHungerLevel() {
        testPet1.setHungerLevel(0);
        testPet2.setHungerLevel(0);
        testPet1.eat(testFood1);
        testPet2.eat(testFood1);
        assertEquals(30,testPet1.getHungerLevel());//fav food
        assertEquals(30, testPet2.getHungerLevel()); //non fav food
    }
    @Test
    public void testEatWeight() {
        testPet1.eat(testFood1);
        testPet2.eat(testFood1);
        assertEquals(20,testPet1.getWeight());//fav food
        assertEquals(20, testPet2.getWeight()); //non fav food
    }



    @Test
    public void testSleepEnergy() {
        testPet1.setEnergy(0);
        testPet1.sleep();
        assertEquals(40,testPet1.getEnergy());
        testPet1.sleep();
        assertEquals(80,testPet1.getEnergy());
    }

    @Test
    public void testSleepMoodLevel(){
        testPet1.setMoodLevel(0);
        testPet1.sleep();
        assertEquals(10,testPet1.getMoodLevel());
        testPet1.sleep();
        assertEquals(20,testPet1.getMoodLevel());
    }

    @Test
    public void testUpdateMoodHunger(){
        testPet1.setHungerLevel(49);
        testPet1.updateMood();
        assertEquals(85,testPet1.getMoodLevel());
        testPet1.setHungerLevel(99);
        testPet1.updateMood();
        assertEquals(85,testPet1.getMoodLevel());
    }

    @Test
    public void testUpdateMoodTiredness(){
        testPet1.setEnergy(49);
        testPet1.updateMood();
        assertEquals(80,testPet1.getMoodLevel());
        testPet1.setEnergy(99);
        testPet1.updateMood();
        assertEquals(80,testPet1.getMoodLevel());
    }

    @Test
    public void testUpdateMoodHungerTired(){
        testPet1.setHungerLevel(49);
        testPet1.setEnergy(49);
        testPet1.updateMood();
        assertEquals(50,testPet1.getMoodLevel());
        testPet1.setHungerLevel(99);
        testPet1.setEnergy(99);
        testPet1.updateMood();
        assertEquals(50,testPet1.getMoodLevel());
    }

    @Test
    public void testVisitBathroomBathroomLevel(){
        testPet1.visitBathroom();
        assertEquals(100,testPet1.getBathroomLevel());
        testPet1.setBathroomLevel(0);
        testPet1.visitBathroom();
        assertEquals(30,testPet1.getBathroomLevel());
        testPet1.setBathroomLevel(50);
        testPet1.visitBathroom();
        assertEquals(80,testPet1.getBathroomLevel());
    }

    @Test
    public void testVisitBathroomMoodLevel(){
        testPet1.visitBathroom();
        assertEquals(100,testPet1.getMoodLevel());
        testPet1.setMoodLevel(0);
        testPet1.visitBathroom();
        assertEquals(10,testPet1.getMoodLevel());
        testPet1.setMoodLevel(50);
        testPet1.visitBathroom();
        assertEquals(60,testPet1.getMoodLevel());
    }

    @Test
    public void testVisitBathroomWeight(){
        testPet1.visitBathroom();
        assertEquals(10,testPet1.getWeight());
    }

    @Test
    public void testProceedToNextDayHungerLevel(){
        testPet1.proccedToNextDay();
        assertEquals(75,testPet1.getHungerLevel());
        testPet1.setHungerLevel(0);
        assertEquals(0,testPet1.getHungerLevel());
    }

    @Test
    public void testProceedToNextDayEnergyLevel(){
        testPet1.proccedToNextDay();
        assertEquals(70,testPet1.getEnergy());
        testPet1.setEnergy(0);
        assertEquals(0,testPet1.getEnergy());
    }

    @Test
    public void testProceedToNextDayBathroomLevel(){
        testPet1.proccedToNextDay();
        assertEquals(75,testPet1.getHungerLevel());
        testPet1.setHungerLevel(0);
        assertEquals(0,testPet1.getHungerLevel());
        testPet1.setHungerLevel(50);
        assertEquals(50,testPet1.getHungerLevel());
    }

    @Test
    public void testIsHungry(){
        assertFalse(testPet1.isHungery());
        testPet1.setHungerLevel(51);
        assertFalse(testPet1.isHungery());
        testPet1.setHungerLevel(49);
        assertTrue(testPet1.isHungery());
        testPet1.setHungerLevel(0);
        assertTrue(testPet1.isHungery());

    }


    @Test
    public void testIsTired(){
        assertFalse(testPet1.isTired());
        testPet1.setEnergy(51);
        assertFalse(testPet1.isTired());
        testPet1.setEnergy(49);
        assertTrue(testPet1.isTired());
        testPet1.setEnergy(0);
        assertTrue(testPet1.isTired());

    }

    @Test
    public void testUpdateMood(){
        testPet1.setEnergy(49);
        testPet1.setHungerLevel(49); // pet is both hungery and tired
        testPet1.updateMood();
        assertEquals(50,testPet1.getMoodLevel());
        testPet1.setMoodLevel(100);
        testPet1.setHungerLevel(100);
        testPet1.updateMood();
        assertEquals(80,testPet1.getMoodLevel());
        testPet1.setEnergy(100);
        testPet1.setHungerLevel(49);
        testPet1.setMoodLevel(100);
        testPet1.updateMood();
        assertEquals(85,testPet1.getMoodLevel());
        testPet1.setEnergy(100);
        testPet1.setHungerLevel(100);
        testPet1.setMoodLevel(100);
        testPet1.updateMood();
        assertEquals(100,testPet1.getMoodLevel());
    }

    @Test
    public void testCalcHealthFirstCondition(){
        testPet1.setHungerLevel(0);
        testPet1.setEnergy(0);
        testPet1.calcHealth();
        assertEquals(0,testPet1.getHealthLevel());
        testPet1.setHungerLevel(0);
        testPet1.setEnergy(0);
        testPet1.calcHealth();
        assertEquals(0,testPet1.getHealthLevel());
    }
}