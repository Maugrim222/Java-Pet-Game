import javax.swing.*;
import java.awt.*;

/**
 * Created by Arcis (Hayden and Tom) on 8/04/2017.
 */
// we decided to have each food item as subclasses of food rather than instances of Food because it is much simplier to get all the values etc from them.
class Wish extends Food {

    /**
     *This class contains the constructer which utilises the super contructor of the Food superclass and passes
     * in parameters specific to this food item.
     */

    public Wish(){
        super("Wish", 15, 20, "Small", 10, "A magical " +
                "essence extracted in an unknown way. Fuels the magical butterfly," +
                " but beware! Feeding it to anything unworthy might have disastrous consequences…s",
                new ImageIcon(new ImageIcon("images/wish.gif").getImage().getScaledInstance(75, 75, Image.SCALE_DEFAULT)));
    }
}

class Apple extends Food {

    /**
     *This class contains the constructer which utilises the super contructor of the Food superclass and passes
     * in parameters specific to this food item.
     */

    public Apple(){
        super("Apple", 4, 20, "Small", 10, "A delicious juicy " +
                "apple from your local organic certified green grocer!",
                new ImageIcon(new ImageIcon("images/apple.png").getImage().getScaledInstance(75, 75, Image.SCALE_DEFAULT)));

    }
}

class DogFood extends Food{

    /**
     *This class contains the constructer which utilises the super contructor of the Food superclass and passes
     * in parameters specific to this food item.
     */

    public DogFood(){

        super("Dog Food", 6, 30, "Medium", 15, "Just normal " +
                "boring dog food. Don’t ask what's inside",new ImageIcon(new ImageIcon("images/dogFood.png").getImage().getScaledInstance(75, 75, Image.SCALE_DEFAULT)));
    }
}

class Cow extends Food{

    /**
     *This class contains the constructer which utilises the super contructor of the Food superclass and passes
     * in parameters specific to this food item.
     */

    public Cow(){

        super("Cow", 16, 60, "Large", 25, "A large cow, to feed the hungery",
                new ImageIcon(new ImageIcon("images/cow.gif").getImage().getScaledInstance(75, 75, Image.SCALE_DEFAULT)));
    }
}

class Honey extends Food{

    /**
     *This class contains the constructer which utilises the super contructor of the Food superclass and passes
     * in parameters specific to this food item.
     */

    public Honey(){

        super("Honey", 8, 80, "Medium",30, "A truly exquisite " +
                "mix of liquid pleasure.",new ImageIcon(new ImageIcon("images/honey.gif").getImage().getScaledInstance(75, 75, Image.SCALE_DEFAULT)));
    }
}

class IcyFish extends Food{

    /**
     *This class contains the constructer which utilises the super contructor of the Food superclass and passes
     * in parameters specific to this food item.
     */

    public IcyFish(){

        super("Icy Fish", 5, 30, "Medium", 20, "A nutritious " +
                "fish from the arctic seas.", new ImageIcon(new ImageIcon("images/fish.png").getImage().getScaledInstance(75, 75, Image.SCALE_DEFAULT)));
    }
}