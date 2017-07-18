import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by Arcis (Hayden and Tom) on 18/04/2017.
 */

public class Game {
    private Player[] players;
    private int playerCount;
    private int gameLength;
    private int currentDay;
    private Random rand;
    private ArrayList<String>  nameList;



    /**
     * Contructs a new game. Takes no params.
     */

    public Game(){
     currentDay = 0;
     rand = new Random();
     nameList = new ArrayList<String>();
    }

    /**
     * Adds a name to a list of all name seen so far by the game.
     * @param name Name to be added to the ArrayList of name seen.
     */

    public void addToNameList(String name){
        nameList.add(name);
    }


    /**
     *Checks if player name is unqiue in the game, (so no two players can the same name).
     * @param name String name which will be analysed for uniqueness.
     * @return True if name is unique, false otherwise.
     */
    public Boolean checkUnique(String name){
        Boolean uniq = true;
        for(String namer: nameList){
            if (namer.equals(name)){
                uniq = false;
            }
        }
        return uniq;
    }

    /**
     * Calculates every players score. Updates each players score with the new one.
     */

    public void calculateScore(){


        for (int i = 0; i < playerCount; i++) {
            if (players[i] != null) {
                int totalScore = 0;
                Player currentPlayer = players[i];
                int halfCash = currentPlayer.getCurrentBalance() / 2;
                totalScore += halfCash;

                for (Pet currentPet : currentPlayer.getPets()) {
                    if (currentPet != null){
                        totalScore += currentPet.getBathroomLevel();
                        totalScore += currentPet.getEnergy();
                        totalScore += currentPet.getHealthLevel();
                        totalScore += currentPet.getHungerLevel();
                        totalScore += currentPet.getMoodLevel();

                    }
                }
                currentPlayer.setScore(totalScore);

            }
        }
    }


    /**
     * Calculates the final score for the game. So takes an average score of all the rounds played.
     * @return ArrayList of string representation of the scores of all the players.
     */
    public ArrayList<String> calcFinalScore(){
        ArrayList<String> arrayScore = new ArrayList<String>();
        for (int i = 0; i<getPlayers().length;i++){
            for (int j = 0;j<getPlayers()[i].getPets().length;j++){
                if (getPlayers()[i].getPets()[j] != null){
                    if (getPlayers()[i].getPets()[j].getRevivalsLeft() == 0){
                        getPlayers()[i].setScore(getPlayers()[i].getScore() - 100);
                    }
                }
            }
            int playerScore = getPlayers()[i].getScore()/gameLength;
            arrayScore.add(String.format("Player %s (%s) has a score of: %s",i + 1,getPlayers()[i].getName(),Integer.toString(playerScore)));
        }

        return arrayScore;
    }


    /**
     * Feeds the given pet with the given food.
     * @param p Player who owns the given pet.
     * @param pet Pet to be fed.
     * @param food Food that's intended to fed to the pet.
     */

    public void feed(Player p, Pet pet, Food food){
        pet.eat(food);
        for (int i = 0;i<p.getFoodItems().size();i++){
            if (p.getFoodItems().get(i).getName().equals(food.getName())){
                p.getFoodItems().remove(i);
            }
            }
        }


    /**
     * Puts the pet to sleep.
     * @param pet Pet thats intended to be slept.
     */
    public void sleep(Pet pet) {
        pet.sleep();
    }


    /**
     *
     * Takes pet to the bathroom.
     * @param pet Pet thats intended to be taken to the bathroom.
     */
    public void takeToBathroom(Pet pet){
        pet.visitBathroom();
    }


    /**
     * Plays with a pet. Given a toy.
     * @param player Player who owns the pet.
     * @param p Pet who's intended to be played with.
     * @param t Toy that's intended to be used by the pet.
     * @return  0 for if pet has broken the toy, or -1 if the pet hasnt broken the toy.
     */
    public int play(Player player, Pet p, Toy t){
        p.play(t);
        if (t.isBroken()){
            for (int i=0;i<player.getToys().size();i++){
                if (player.getToys().get(i).getName().equals(t.getName())){
                    player.getToys().remove(i);
                }
            }
            return 0;
        }
        return -1;


    }

    /**
     *Returns whether a pet has more turns left or not.
     * @param pet Pet that is intended to be analysed whether it has any more actions left or not.
     * @return whether the pet has more actions left or not.
     */

    public boolean petHasMoreTurns(Pet pet){
        if (pet.getActionCount() != 0){
            return true;
        }
        return  false;
    }

    /**
     *Sets the action count to the default 2.
     * @param p takes the player who's action count will need to be reset
     */
    public void resetActionCount(Player p){
        p.setActionCount(2);
    }


    /**
     *Triggers a random event, has two random events that will be returned if the random number is within a certain range.
     * @return An int that is assigned to whether the random number is flipped to be within a certain range. (0 for i less than 11 ).
     */

    public int triggerRandomEvent(){
        int i = rand.nextInt(100);
        if (i < 11){
            return 0;
        }else if (i > 11 && i< 22){
            return 1;
        }
        return -1;
    }

    /**
     * Sets the player count.
     * @param x This is the value for which the player count will be set to.
     */
    public void setPlayerCount(int x){
        this.playerCount = x;
    }


    /**
     *Sets the game length.
     * @param x Value for which the game length will be set to.
     */
    public void setGameLength(int x){
        this.gameLength = x;
    }


    /**
     *Gets the number of players in the game.
     * @return Player count.
     */
    public int getPlayerCount(){
        return playerCount;
    }

    /**
     * Gets the array of players in the game.
     * @return Array of players in the game.
     */
    public Player[] getPlayers(){
        return players;
    }

    /**
     *Gets the current day the game is at.
     * @return The current day the game is at.
     */
    public int getCurrentDay(){
        return currentDay;
    }


    /**
     * Gets the game length.
     * @return The game length.
     */
    public int getGameLength(){
        return gameLength;
    }

    /**
     *Increments the current day number of the game.
     */
    public void incrementDay(){
        currentDay++;
    }

    /**
     *Sets the number of players to be in the game.
     * @param numberPlayers Value for the number of players.
     */
    public void initialiseGame(int numberPlayers){
        players = new Player[numberPlayers];
    }

}
