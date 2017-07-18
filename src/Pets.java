/**
 * Created by Arcis (Hayden and Tom) on 8/04/2017.
 */
// easier to add feature specific to all pets! thinking about maintainablility and upgradability

class Dragon extends Pet{

    /**
     *This class contains the constructor which utilises the super constructor of the Pet superclass and passes
     * in parameters specific to this species.
     * @param name
     */

    public Dragon(String name){
        super("Dragon", name, 100, "Cow","Princess", 10,45,20,0.9, "A creature of myth and legend. While many people believe they don't exist in our world, you now " +
                "have a chance to prove them wrong with your own personal monstrous beast of might and flame!");
    }
}

class Dog extends Pet{

    /**
     *This class contains the constructer which utilises the super contructor of the Pet superclass and passes
     * in parameters specific to this species.
     * @param name
     */

    public Dog(String name){
        super("Dog", name, 15, "Dog Food","Ball", 9,25,30,1.2, "This boring creature can sit by the door, walk through the park and wake up the neighbor" +
                "hood at 3am on a full moon. (although this version is even more boring and cant do any of those things).");
    }
}
class RedPanda extends Pet{

    /**
     *This class contains the constructer which utilises the super contructor of the Pet superclass and passes
     * in parameters specific to this species.
     * @param name
     */

    public RedPanda(String name){
        super("Red Panda", name, 6, "Apple","Squeaky Toy", 9,45,40,1, "Hes super cute, that's all you need to know. Also that hes cute. And also a bit cute. And sometimes he can be slightly cuter th" +
                "an the usual cute. He can rarely do this while being additionally cute while being as cute as a cute.");
    }
}

class Penguin extends Pet{

    /**
     *This class contains the constructer which utilises the super contructor of the Pet superclass and passes
     * in parameters specific to this species.
     * @param name
     */

    public Penguin(String name){
        super("Penguin", name, 5, "Icy Fish","Iceberg", 8,15,20,0.95, "Penguins are a group of aquatic, flightless birds. They live almost exclusively in the Southern" +
                " Hemisphere, with only one species, the Galapagos penguin, found north of the equator.");
    }
}
class MagicalButterfly extends Pet{

    /**
     *This class contains the constructer which utilises the super contructor of the Pet superclass and passes
     * in parameters specific to this species.
     * @param name
     */

    public MagicalButterfly(String name){
        super("Magical Butterfly", name, 1, "Wish","Magical Flower", 8,15,10,0.8, "Sit own child and let me tell you a story... in a dimension far far away... there dwelt a race " +
                "of magical being which transcended reality itself. Were they gods? Ney. Were they Jedi? Ney I say. They were more magical than anything known before... they were the Magical Butterflies.");
    }
}

class FoxyFox extends Pet{

    /**
     *This class contains the constructer which utilises the super contructor of the Pet superclass and passes
     * in parameters specific to this species.
     * @param name
     */

    public FoxyFox(String name){
        super("Foxy Fox", name, 15, "Honey","Pinecone", 9,25,20,1.2, "Foxes are majestic and elegant beings (which kill chickens) This one is the" +
                " foxiest of all the foxes. It has a bushy tail. Perhaps after owning the FoxyFox, you will be able to answer the question to rule them all... what does the fox say");
    }
}
