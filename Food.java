import javax.swing.*;

/**
 * Created by Arcis Studios (Hayden and Tom) on 8/04/2017.
 */
public class Food {
    private String name; //type of food
    private int price; //the retail price of the item
    private int nutritionValue; //this value will tell us how much of an effect it has on the pets hunger level
    private int tastiness; //this value will increase when its a pets favourite food, each food has a tastiness, so will increase happiness depending on this value
    private String mealSize; //should tell us how much of an affect the food has on the pets need to use the bathroom
    private String description; // description of the food
    private ImageIcon image; // image icon location of the food

    /**
     *
     * @param name String - Name/type of the food item
     * @param price int - Price of the food item
     * @param nutritionValue int - This value will tell us how much of an effect it has on the pets hunger level
     * @param mealSize String - should tell us how much of an affect the food has on the pets need to use the bathroom
     * @param tastiness int - this value will increase when its a pets favourite food, each food has a tastiness,
     *                  so will increase happiness depending on this value
     * @param description String - Description of the food item
     * @param img ImageIcon that will display the image of the food.
     */

    public Food(String name, int price, int nutritionValue, String mealSize, int tastiness, String description, ImageIcon img){
        this.name = name;
        this.price = price;
        this.nutritionValue = nutritionValue;
        this.tastiness = tastiness;
        this.mealSize = mealSize;
        this.description = description;
        image = img;
    }

    /**
     *This method determines the weight of the meal. Small is 5, Medium is 20 and Large is 50.
     * @return int - Size of the meal.
     */

    public int getMealWeight() {
        if (mealSize.equals("Small")){
            return 5;
        }else if (mealSize.equals("Medium")){
            return 20;
        }else{
            return 50;
        }
    }

    /**
     *Getter for the tastiness value of a meal.
     * @return int - The tastiness of the meal.
     */

    public int getTastiness(){
        return tastiness;
    }

    /**
     *Setter for the size of the meal.
     * @param mealSize String - Value to which the meal size should be set.
     */

    public void setMealSize(String mealSize) {
        this.mealSize = mealSize;
    }

    /**
     *Getter for the name of the meal.
     * @return String - Name of the meal.
     */

    public String getName() {
        return name;
    }

    /**
     *Setter for the name of the food item.
     * @param name String - Name of the food item.
     */

    public void setName(String name) {
        this.name = name;
    }

    /**
     *Getter for the price of the food item.
     * @return int - Price of the food item.
     */

    public int getPrice() {
        return price;
    }

    /**
     *Setter for the price of the food item.
     * @param price int - The value to which the price should be set to.
     */

    public void setPrice(int price) {
        this.price = price;
    }

    /**
     *Getter for the nutritional value of the food item.
     * @return int - Nutritional value of the meal.
     */

    public int getNutritionValue() {
        return nutritionValue;
    }

    /**
     *Setter for the nutritional value.
     * @param nutritionValue int - The value to which the nutritional value should be set.
     */

    public void setNutritionValue(int nutritionValue) {
        this.nutritionValue = nutritionValue;
    }

    /**
     *Returns the string representation of the food item.
     * @return String - String representation of the food item.
     */

    public String toString(){
        String str = String.format("Item Name: %s\nPrice of food item: %s GP\nNutritional Value: %s\nMeal Size: %s\nTastiness: %s",name,price,nutritionValue,mealSize,tastiness);
        return str;
    }

    /**
     * Getter for the meal size.
     * @return String - The meal size of the food item.
     */

    public String getMealSize(){
        return mealSize;
    }


    /**
     * Getter for the description of the food item.
     * @return String - Description of the food item.
     */

    public String getDescription(){
        return description;
    }

    /**
     * Getter for the image of the food.
     * @return ImageIcon - The image of the food item.
     */

    public ImageIcon getImage(){
        return image;
    }

    /**
     * Setter for the image of the food item.
     * @param img ImageIcon - the image which represents the food item.
     */

    public void setImage(ImageIcon img){
        image = img;
    }

}

