import javax.swing.*;

/**
 * Created by Arcis Studios (Hayden and Tom) on 9/04/2017.
 */
public class Toy {
    private int durability;//out of 100, when it reaches 100 then its broken
    private String name; //toy name/type
    private int price;
    private String state;//broken/usable
    private int energyConsumption;
    private String description;
    private ImageIcon image;

    /**
     *
     * @param name String - name of the toy
     * @param price int - price of the toy
     * @param startDurability int durability of the toy when new out of 100
     * @param energyConsumption int - the amount of energy the pet uses to play with this toy
     * @param description String - description of the toy
     * @param img ImageIcon which displays the image of the toy.
     */

    public Toy(String name, int price, int startDurability, int energyConsumption, String description, ImageIcon img){
        this.name = name;
        this.price = price;
        state = "usable";
        durability = startDurability;
        this.energyConsumption = energyConsumption;
        this.description = description;
        image = img;
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
     * This method inflicts damage upon the victim toy as determined by the pet species.
     * Different species inflict different amount of damage.
     * @param dmg int - Sets the state and durability of the toy after it has been played with.
     */

    public void damage(int dmg){
        durability = round(durability - dmg);
        setState();
    }


    /**
     *Setter for the durability of the toy.
     * @param x int - Value to which the durability should be set to.
     */

    public void setDurability(int x){
        this.durability = round(x);
        setState();
    }

    /**
     *Determines whether or not the toy is broken.
     * @return boolean - True if the durability is 0, False otherwise.
     */

    public boolean isBroken(){
        if (durability > 0){return false;}
        return true;
    }

    /**
     *Setter for the state of the toy. Checks if the toy's state boolean is broken, and if so,
     * sets the toy's String state to broken.
     * (This is used for printing the state of the toy).
     */

    public void setState(){
        if (isBroken()){state = "broken";}
        else {state = "usable";}
    }

    /**
     *Returns a string representation of the toy.
     * @return String - String representation of the toy.
     */

    public String toString(){
        String str = String.format("Toy: %s\nPrice: %s\nState: Toy is %s!\nDurability: %s", name,price,state,durability);
        return str;
    }

    /**
     *Getter for the durability of the toy.
     * @return int - The durability of the toy.
     */

    public int getDurability(){
        return durability;
    }

    /**
     *Getter for the state of the toy.
     * @return String - The state of the toy.
     */

    public String getState(){
        return state;
    }

    /**
     *Getter for the name of the toy.
     * @return String - The name of the toy.
     */

    public String getName(){
        return name;
    }

    /**
     *Getter for the energy consumption a toy inflicts upon the pet.
     * @return int - Amount of energy the pet will lose after plying with this toy
     * (before further modifiers are applied).
     */

    public int getEnergyConsumption(){
        return energyConsumption;
    }

    /**
     *Getter for the price of the toy.
     * @return int - The price of the toy.
     */

    public int getPrice(){
        return price;
    }

    /**
     * Getter fo the description of the toy.
     * @return The description of the toy.
     */

    public String getDescription(){
        return description;
    }

    /**
     * Setter for the image of the toy.
     * @param img ImageIcon - The image to which the image of the toy should be set to.
     */

    public void setImage(ImageIcon img){
        image = img;
    }

    /**
     * Getter for the image of the toy.
     * @return ImageIcon - The image of the toy.
     */

    public ImageIcon getImage(){
        return image;
    }
}





