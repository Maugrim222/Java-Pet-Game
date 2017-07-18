import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Arcis (Hayden and Tom) on 14/04/2017.
 */
public class Player {
    private String name;
    private ArrayList<Toy> toys;
    private Pet[] pets = new Pet[3];
    private ArrayList<Food> foodItems;
    private int score;
    private int currentBalance = 100;
    private int actionCount;


    /**
     * Constructs a new pet and gives it the inputted name.
     * @param name Takes a string name, which will be the pet name.
     */
    public Player(String name){
        this.name = name;
        toys = new ArrayList<Toy>();
        foodItems = new ArrayList<Food>();
        score = 0;
        currentBalance = 100;
        actionCount = 2;
    }


    /**
     * Decrements the action count for a pet.
     */
    public void decrementActionCount(){
        actionCount--;
    }

    /**
     * Sets teh action count for the pet.
     * @param x Takes int x which will be the new action count.
     */
    public void setActionCount(int x){
        actionCount = x;
    }

    /**
     * Returns the pets current action count.
     * @return Pets action count.
     */
    public int getActionCount(){ return actionCount;}

    /**
     *Adds Toy to players toy inventory.
     * @param t Takes param Toy.
     */
    public void addToy(Toy t){
        toys.add(t);
    }

    /**
     * Returns the string representation of a player.
     * @return String formatted representation of a player.
     */
    public String toString(){
        String str = String.format("Player name: %s\nToys: %S\nPets: %s\nBalance: %s", name, toys,pets,currentBalance);
        return str;
    }

    /**
     * Adds food to the players food inventory.
     * @param f Food item.
     */
    public void addFood(Food f){
        foodItems.add(f);
    }


    /**
     * Return food inventory of player.
     * @return Food items as an ArrayList.
     */
    public ArrayList<Food> getFoodItems(){
        return foodItems;
    }


    /**
     * Sets score player score to specified value.
     * @param x int x.
     */
    public void setScore(int x){
        score = x;
    }

    /**
     * Returns player score.
     * @return Player score as int.
     */
    public int getScore(){
        return score;
    }

    /**
     * Gets players toy inventory.
     * @return Toys ArrayList as players inventory.
     */

    public ArrayList<Toy> getToys(){
        return toys;
    }


    /**
     * Return players pets.
     * @return Array of pets the play has.
     */
    public Pet[] getPets(){
        return pets;
    }


    /**
     * Sets player current balance.
     * @param x Value to be set as players current balance.
     */

    public void setCurrentBalance(int x){
        currentBalance = x;
    }


    /**
     * Gets players current balance.
     * @return Players current balance.
     */
    public int getCurrentBalance(){
        return currentBalance;
    }


    /**
     * Gets player name.
     * @return String of the players name.
     */
    public String getName(){
        return name;
    }


    /**
     *Sets the players name.
     * @param name String for which the players name will be set to.
     */
    public void setName(String name){
        this.name = name;
    }

}
