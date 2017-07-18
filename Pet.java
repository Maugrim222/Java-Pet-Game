/**
 * Created by Arcis Studios (Hayden and Tom)  on 8/04/2017.
 */
public class Pet{

    public static final int moodIncreaseOnPlay = 20;
    private int hungerRate; //slow increase of hunger when proceeding to the next day + 15
    private int sleepRate; //slow increase of sleep when proceeding to the next day + 10
    private double playModifier; //percentage of moodOnPlay. Dragons don't like playing with toys very much (moodOnPlay*0.9)

    private String name;
    private String species;
    private int weight;
    private int hungerLevel;
    private int healthLevel;
    private int moodLevel;
    private int bathroomLevel;
    private int energy;
    private String favouriteFood;
    private String favouriteToy;
    private int damageToToys;
    private String description;
    private int revivalsLeft = 1;
    private String state = "Alive";
    private int actionCount = 2;

    /**
     *
     * @param species String - The species of the pet
     * @param name String - Name of the pet
     * @param weight int - Weight of the pet
     * @param favouriteFood String - Pet's favourite food
     * @param favouriteToy String - Pet's favourite toy
     * @param damageToToys int - How much damage the pet deals when they play with a toy
     * @param hungerRate int - The rate at which the pet becomes hungry at the end of each day
     * @param sleepRate int - The rate at which the pet becomes tired at the end of the day
     * @param playModifier double - Modifier on the amount of joy a pet gets after playing
     * @param description String - Description of the pet
     */


    public Pet(String species, String name, int weight, String favouriteFood, String favouriteToy, int damageToToys,
               int hungerRate, int sleepRate, double playModifier, String description) {

        this.species = species;
        this.name = name;
        this.weight = weight;
        this.hungerLevel = 100;
        this.healthLevel = 100;
        this.bathroomLevel = 100;
        this.moodLevel = 100;
        this.energy = 100;
        this.favouriteFood = favouriteFood;
        this.favouriteToy = favouriteToy;
        this.damageToToys = damageToToys;
        this.hungerRate = hungerRate;
        this.sleepRate = sleepRate;
        this.playModifier = playModifier;
        this.description = description;
    }

    /**
     * Since the game does not support an attribute level higher than 100 (%), this method ensures the value to be
     * assigned is within the range 0 to 100.
     * @param x int - the value to be entered into the range
     * @return int - value within the range of 0 to 100
     */

    public static int round(int x){
        if (x > 100){
            return 100;
        }else if (x < 0){
            return 0;
        }
        return x;
    }

    /**
     * This method enables the pet to play. First the toy selected is checked against the pet's favourite toy and
     * the pet's mood updates accordingly. If favourite toy, mood increase will be higher. Then the energy and hunger
     * of the pet are decreased and increased accordingly.
     * @param toy Toy - the toy with which the pet will play, different toys will have
     * different effects on the mood, energy and hunger after playing
     */

    public void play(Toy toy){
        if (toy.getName().equals(favouriteToy)){ //if the toy is its favourite toy, then mood will increase by double
            moodLevel = round((int)(1.6*(int)((Pet.moodIncreaseOnPlay)*playModifier) + moodLevel));
        }else{
            moodLevel = round(((int)((Pet.moodIncreaseOnPlay*playModifier)+ moodLevel)));
        }
        energy = round(energy - toy.getEnergyConsumption());
        toy.damage(damageToToys);
        hungerLevel = (round(hungerLevel - 10));
        calcHealth();
    }

    /**
     *A method which updates the hunger, energy and mood during the end phase of a day.
     */

    public void proccedToNextDay(){
        hungerLevel = round(hungerLevel - hungerRate);
        energy = round(energy - sleepRate);
        bathroomLevel = round(bathroomLevel - 10);
        updateMood();
        calcHealth();

    }

    /**
     * Takes a food item form the inventory and alters the mood and hunger levels accordingly.
     * @param item Food - The food to be eaten by the pet
     */

    public void eat(Food item){
        if (item.getName().equals(favouriteFood)){
            moodLevel = round(20 + item.getTastiness() + moodLevel);
        }else{
            moodLevel = round(moodLevel+item.getTastiness());
        }
        hungerLevel = round(((int)(hungerLevel+ (item.getNutritionValue()))));
        weight += 5;
        calcHealth();
    }

    /**
     *Lets the pet sleep and increases mood and energy of the pet.
     */

    public void sleep(){
        energy = round(energy + 40);
        moodLevel = round(moodLevel + 10);
        calcHealth();
    }

    /**
     *Lets the pet visit the bathroom and decrease the weight of the pet.
     */

    public void visitBathroom(){
        bathroomLevel = round(bathroomLevel + 30);
        moodLevel = round(moodLevel + 10);
        calcHealth();
        weight -= 5.00;
    }

    /**
     *Checks if the pet is hungry.
     * @return Boolean - True if pet is hungry ( below or equal to 50), False otherwise.
     */

    public boolean isHungery(){
        if (hungerLevel <= 50) {
            return true;
        }
        return false;
    }

    /**
     *Checks if the pet is tired.
     * @return Boolean - True if pet is tired ( below or equal to 50), False otherwise.
     */

    public boolean isTired(){
        if (energy <= 50){
            return true;
        }
        return false;
    }

    /**
     *Setter for the hunger level.
     * @param hungerLevel int - Hunger level to which it should be set.
     */

    public void setHungerLevel(int hungerLevel) {
        this.hungerLevel = round(hungerLevel);
    }

    /**
     *Setter for energy level.
     * @param x int - Value to which the energy level should be set.
     */

    public void setEnergy(int x){
        this.energy = round(x);
    }

    /**
     *Updates the mood by looking at the other stats of the pet, performed at the end of each day.
     */

    public void updateMood(){
        if (isTired() && isHungery()) {
            moodLevel = round(moodLevel - 50);
        }else if (isTired()){
            moodLevel = round(moodLevel - 20);
        }else if (isHungery()){
            moodLevel = round(moodLevel - 15);
        }
    }

    /**
     * Getter for the playfulness of the pet.
     * @return double - The ratio value (modifier) which represents how playful the pet is.
     */

    public double getPlayfulness(){
        return playModifier;
    }

    /**
     * Looks at all the other vitals/stats of the pet and using these calculates the reduction in the health of the pet.
     */

    public void calcHealth(){
        boolean hungry = hungerLevel < 75 && hungerLevel > 40;
        boolean superHungry = hungerLevel < 40;
        boolean tired = energy < 75 && energy > 40;
        boolean superTired =  energy < 40;

        if (hungerLevel == 0 && energy < 40 || energy < 10 && hungerLevel < 15 || energy == 0 && hungerLevel < 30){
            healthLevel = 0;
            setDeathState();
        }else if (superHungry && superTired) {
            healthLevel = 20;
        }else if (tired && hungry){
            healthLevel = 65;
        }else if (tired){
            healthLevel = 80;
        }else if (hungry){
            healthLevel = 80;
        }else if (superTired){
            healthLevel = 40;
        }else if (superHungry){
            healthLevel = 40;
        }
    }


    /**
     * Sets the state of the pet to dead.
     */

    public void setDeathState(){
        state = "Dead";
    }

    /**
     * Getter for the state of the pet.
     * @return String - returns the state of the pet.
     */

    public String getState(){
        return state;
    }

    /**
     * Setter fot eh state of the pet.
     * @param state Value to which the state of the pet should be set.
     */

    public void setState(String state){
        this.state = state;
    }

    /**
     * Setter fo the revivals a pet has left.
     * @param x int - Number of revivals a pet has left.
     */

    public void setRevivalsLeft(int x){
        revivalsLeft = x;
    }

    /**
     * Reduces the mood level after the pet is disciplined.
     */

    public void beDisciplined(){
        moodLevel = round(moodLevel - 15);
    }


    /**
     * Increases the health after the pet is cured.
     */

    public void beCured(){
        healthLevel = round(healthLevel + 15);
    }

    /**
     * Called when the pet is revived and sets all the stats of the pet to max.
     */

    public void beRevived(){
        this.hungerLevel = 100;
        this.healthLevel = 100;
        this.bathroomLevel = 100;
        this.moodLevel = 100;
        this.energy = 100;
    }

    /**
     * Getter for the revivals left.
     * @return int - Number of revivals a pet has remaining.
     */

    public int getRevivalsLeft(){
        return revivalsLeft;
    }
    /**
     *Prints a string representation of the pet.
     * @return String - The pet and its stats returned as a formatted string.
     */

    public String toString(){
        String str = String.format("Name: %s\nSpecies: %s\nTiredness: %s\nWeight: %s\nMood Level: %s\n" +
                "Hunger Level: %s", name,species,energy,weight,moodLevel,hungerLevel);
        return str;
    }

    /**
     *Getter fo the energy of the pet.
     * @return int - The value of the energy of the pet.
     */

    public int getEnergy(){
        return energy;
    }

    /**
     *The getter for the weight of the pet.
     * @return int - Value to which the weight of the pet should be set.
     */

    public int getWeight() {
        return weight;
    }

    /**
     *The setter for the weight of the pet
     * @param weight int - The value to which the weight should be set.
     */

    public void setWeight(int weight) {
        this.weight += weight;
    }

    /**
     *Getter for the species of the pet.
     * @return Sting- The species of the pet.
     */

    public String getSpecies() {
        return species;
    }

    /**
     *Setter for the species of the pet.
     * @param species String - The species to which the pet should be set.
     */

    public void setSpecies(String species) {
        this.species = species;
    }

    /**
     *Getter for the health of the pet.
     * @return int - The health level of the pet.
     */

    public int getHealthLevel() {
        return healthLevel;
    }

    /**
     *Setter for the health of the pet.
     * @param healthLevel int - The vale to which the health of the pet should be set to.
     */

    public void setHealthLevel(int healthLevel) {
        this.healthLevel = round(healthLevel);
    }

    /**
     *Getter for the mood level.
     * @return int - The mood level of the pet.
     */

    public int getMoodLevel() {
        return moodLevel;
    }

    /**
     *Setter for the mood level.
     * @param moodLevel int - The value to which the mood level should be set.
     */

    public void setMoodLevel(int moodLevel) {
        this.moodLevel = round(moodLevel);
    }

    /**
     *Getter for the name of the pet.
     * @return String - Name of the pet.
     */

    public String getName() {
        return name;
    }

    /**
     *Setter for the name of the pet.
     * @param name String - Name of the pet.
     */

    public void setName(String name) {
        this.name = name;
    }

    /**
     *Getter for the bathroom level of the pet.
     * @return int - Pet's bathroom level.
     */

    public int getBathroomLevel() {
        return bathroomLevel;
    }

    /**
     *Setter for bathroom level.
     * @param bathroomLevel int - Number to which the bathroom level should be set.
     */

    public void setBathroomLevel(int bathroomLevel) {
        this.bathroomLevel = round(bathroomLevel);
    }

    /**
     *Getter for favourite food of the pet.
     * @return String - Pet's favourite food.
     */

    public String getFavouriteFood() {
        return favouriteFood;
    }

    /**
     *Setter for favourite food of the pet.
     * @param favouriteFood String - The food to be set as the pets favourite food.
     */

    public void setFavouriteFood(String favouriteFood) {
        this.favouriteFood = favouriteFood;
    }

    /**
     *Getter for favourite toy.
     * @return Toy - Returns pets favourite toy.
     */

    public String getFavouriteToy() {
        return favouriteToy;
    }

    /**
     *Setter for favourite toy.
     * @param favouriteToy String - The toy to e set as the favourite.
     */

    public void setFavouriteToy(String favouriteToy) {
        this.favouriteToy = favouriteToy;
    }

    /**
     *Getter for damage to toys.
     * @return int - Damage the pet deals to toys.
     */

    public int getDamageToToys() {
        return damageToToys;
    }

    /**
     *Getter for damage to toys.
     * @param damageToToys int - The value to which the damage to toys should be set to.
     */

    public void setDamageToToys(int damageToToys) {
        this.damageToToys = damageToToys;
    }

    /**
     *Getter for hunger level.
     * @return int - Return the pet's hunger level.
     */

    public int getHungerLevel() {
        return hungerLevel;
    }

    /**
     *Getter for the description of the pet.
     * @return String - Returns the description of the pet.
     */

    public String getDescription(){
        return description;
    }

    /**
     *Setter fo the action count of a pet.
     * @param x int - Value to which the action count should be set.
     */

    public void setActionCount(int x){
        actionCount = x;
    }

    /**
     *Getter fo he action count of a pet.
     * @return int - How many actions the player's pet has remaining.
     */

    public int getActionCount(){
        return actionCount;
    }

    /**
     *Reduces action count of pet by one.
     */

    public void decrementActionCount(){
        actionCount--;
    }


}

