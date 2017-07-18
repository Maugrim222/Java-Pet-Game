import javax.swing.*;
import java.awt.*;

/**
 * Created by Arcis on 10/04/2017.
 */
class SqueakyToy extends Toy{


    /**
     *This class contains the constructor which utilises the super constructor of the Pet superclass and passes
     * in parameters specific to this toy type.
     */

    public SqueakyToy(){
        super("Squeaky Toy",2,20, 15, "looks " +
                "cute and makes sounds", new ImageIcon(new ImageIcon("images/cow.gif").getImage().getScaledInstance(75, 75, Image.SCALE_DEFAULT)));
    }

}

class MagicalFlower extends Toy{


    /**
     *This class contains the constructor which utilises the super constructor of the Pet superclass and passes
     * in parameters specific to this toy type.
     */

    public MagicalFlower(){
        super("Magical Flower",30,15,5, "It might seem like an " +
                "ordinary flower, however this flower can phase through dimensions at will. It is thus the toy of " +
                "choice for your magical butterfly", new ImageIcon(new ImageIcon("images/flower.png").getImage().getScaledInstance(75, 75, Image.SCALE_DEFAULT)));
    }
}

class Princess extends Toy{

    /**
     *This class contains the constructor which utilises the super constructor of the Pet superclass and passes
     * in parameters specific to this toy type.
     */

    public Princess(){
        super("Princess",20,30,100, "Will become the " +
                "heir to the kingdom once she is rescued by a valiant knight (or ogre)",
                new ImageIcon(new ImageIcon("images/princess.gif").getImage().getScaledInstance(75, 75, Image.SCALE_DEFAULT)));
    }

}

class PineCone extends Toy{


    /**
     *This class contains the constructor which utilises the super constructor of the Pet superclass and passes
     * in parameters specific to this toy type.
     */

    public PineCone(){
        super("Pinecone", 15, 25,15, "A super " +
                "exciting cone of the pine",new ImageIcon(new ImageIcon("images/pinecone.gif").getImage().getScaledInstance(75, 75, Image.SCALE_DEFAULT)));
    }
}

class Ball extends Toy{

    /**
     *This class contains the constructor which utilises the super constructor of the Pet superclass and passes
     * in parameters specific to this toy type.
     */

    public Ball(){
        super("Ball", 5, 15,20, "Basic ball, has " +
                "functions roll(), bounce() and getLost()",new ImageIcon(new ImageIcon("images/ball.png").getImage().getScaledInstance(75, 75, Image.SCALE_DEFAULT)));
    }
}

class IceBerg extends Toy{

    /**
     *This class contains the constructor which utilises the super constructor of the Pet superclass and passes
     * in parameters specific to this toy type.
     */

    public IceBerg(){
        super("Iceberg", 15, 20,10, "This one " +
                "proabaly won't sink the Titanic",new ImageIcon(new ImageIcon("images/iceberg.png").getImage().getScaledInstance(75, 75, Image.SCALE_DEFAULT)));
    }
}