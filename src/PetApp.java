import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by Arcis Studios (Hayden and Tom) on 15/05/2017.
 */
public class PetApp extends JFrame {
    private JPanel mainPanel;
    private JPanel petSelectionPlayerOne;
    private JPanel gridPanel1;
    private JPanel menu;
    private JPanel anotherPanel;
    private JButton button3;
    private JButton proceedToPlayerTwo;
    private JPanel setUpPanel;
    private JTextField playerCount;
    private JTextField numberDays;
    private JButton proceedToNextStageButton;
    private JPanel topPanel;
    private JPanel questionPanel;
    private JPanel inputPanel;
    private JPanel buttonPanel;
    private JPanel centrePanel;
    private JPanel positionPanel; // this is the panel which the image should be added to
    private JTextField playerNameText;
    private JButton checkNameButtonPlayerOne;
    private JButton petOnePlayerOne;
    private JButton petTwoPlayerOne;
    private JButton petThreePlayerOne;
    private JPanel allPets;
    private JPanel gridPanelAllPets;
    private JButton addDog;
    private JButton addPenguin;
    private JButton dogButton;
    private JButton penguinButton;
    private JButton nextPageOneButton;
    private JTextArea dogDescription;
    private JTextArea penguinDescription;
    private JPanel allPetsPage2;
    private JButton previousPageButton;
    private JButton nextPageTwoButton;
    private JPanel allPetsPage3;
    private JButton previousPageThreeButton;
    private JPanel leftPanelPageThreePets;
    private JButton addPanda;
    private JLabel pageNumberLabel;
    private JButton foxButton;
    private JButton butterflyButton;
    private JButton redPandaButton;
    private JButton addFox;
    private JButton addButterfly;
    private JButton addDragon;
    private JButton nextPageButton;
    private JLabel petSelectionPlayerTitle;
    private JPanel gridMenu;
    private JTabbedPane tabbedPane1;
    private JButton petOneIcon;
    private JButton sleepPetOne;
    private JButton feedPlayPetOne;
    private JButton visitStore;
    private JButton endDayButton;
    private JButton inventoryButton;
    private JProgressBar healthProgressBarOne;
    private JProgressBar tirednessProgressBarOne;
    private JProgressBar hungerProgressBarOne;
    private JProgressBar moodProgressBarOne;
    private JPanel petOnePanelMenu;
    private JButton petTwoIcon;
    private JButton petThreeIcon;
    private JButton bathroomPetTwo;
    private JButton bathroomPetOne;
    private JLabel petThreeSpeices;
    private JLabel petTwoSpecies;
    private JLabel petOneSpecies;
    private JLabel healthPetOne;
    private JLabel tirednessPetOne;
    private JLabel hungerPetOne;
    private JLabel moodPetOne;
    private JLabel healthPetTwo;
    private JLabel tirednessPetTwo;
    private JLabel hungerPetTwo;
    private JLabel moodPetTwo;
    private JLabel healthPetThree;
    private JLabel tirednessPetThree;
    private JLabel hungerPetThree;
    private JLabel moodPetThree;
    private JButton feedPlayPetThree;
    private JButton bathroomPetThree;
    private JButton sleepPetThree;
    private JButton feedPlayPetTwo;
    private JButton sleepPetTwo;
    private JLabel playerTitle;
    private JProgressBar bathroomProgressBarOne;
    private JLabel bathroomStatPetOne;
    private JProgressBar bathroomProgressBarTwo;
    private JLabel bathroomStatPetTwo;
    private JProgressBar bathroomProgressBarPetThree;
    private JLabel bathroomStatPetThree;
    private JProgressBar healthProgessBarTwo;
    private JProgressBar tirednessProgressBarTwo;
    private JProgressBar hungerProgressBarTwo;
    private JProgressBar moodProgressBarTwo;
    private JProgressBar healthProgressBarThree;
    private JProgressBar tirednessProgressBarThree;
    private JProgressBar hungerProgressBarThree;
    private JProgressBar moodProgressBarThree;
    private JPanel store;
    private JPanel storeGridPanel;
    private JButton dragonButton;
    private JButton exitStore;
    private JPanel scrollPanelMain;
    private JButton icyFishImage;
    private JButton icyFishPurchase;
    private JButton dogFoodImage;
    private JButton dogFoodPurchase;
    private JButton wishImage;
    private JButton wishPurchase;
    private JButton cowPurchase;
    private JButton honeyImage;
    private JButton honeyPurchase;
    private JButton appleImage;
    private JButton applePurchase;
    private JButton cowImage;
    private JLabel wishDescriptionLabel;
    private JLabel dogFoodDescription;
    private JLabel icyFishDescription;
    private JLabel appleDescription;
    private JLabel honeyDescription;
    private JLabel cowDescription;
    private JButton magicalFlowerImage;
    private JLabel magicalFlowerDescriptions;
    private JButton magicalFlowerPurchase;
    private JButton icebergImage;
    private JButton ballImage;
    private JLabel icebergDescription;
    private JLabel ballDescription;
    private JButton icebergPurchase;
    private JButton ballPurchase;
    private JButton squeakyToyImage;
    private JButton princessImage;
    private JButton pineConeImage;
    private JLabel squeakyToyDescription;
    private JLabel princessDescription;
    private JLabel pineConeDescription;
    private JButton squeakyToyPurchase;
    private JButton princessPurchase;
    private JButton pineConePurchase;
    private JLabel currencyLabel;
    private JPanel inventory;
    private JPanel inventoryGrid;
    private JLabel wishLabel;
    private JLabel appleLabel;
    private JLabel cowLabel;
    private JLabel dogFoodLabel;
    private JLabel honeyLabel;
    private JLabel icyFishLabel;
    private JLabel pineConeLabel;
    private JLabel magicalFlowerLabel;
    private JLabel princessLabel;
    private JLabel squeakyToyLabel;
    private JLabel ballLabel;
    private JLabel iceBergLabel;
    private JButton exitInventoryButton;
    private JButton icyFishEat;
    private JButton honeyEat;
    private JButton dogFoodEat;
    private JButton cowEat;
    private JButton appleEat;
    private JButton wishEat;
    private JButton ballPlay;
    private JButton iceBergPlay;
    private JButton squeakyToyPlay;
    private JButton princessPlay;
    private JButton magicalFlowerPlay;
    private JButton pineConePlay;
    private JButton wishButton;
    private JButton appleButton;
    private JButton cowButton;
    private JButton dogFoodButton;
    private JButton honeyButton;
    private JButton icyFishButton;
    private JButton pineConeButton;
    private JButton magicalFlowerButton;
    private JButton princessButton;
    private JButton squeakyToyButton;
    private JButton ballButton;
    private JButton iceBergButton;
    private JTextField petNameOne;
    private JTextField petNameTwo;
    private JTextField petNameThree;
    private JLabel cowStats;
    private JLabel honeyStats;
    private JLabel appleStats;
    private JLabel icyFishStats;
    private JLabel dogFoodStats;
    private JLabel wishStats;
    private JLabel ballStats;
    private JLabel magicalFlowerStats;
    private JLabel iceBergStats;
    private JLabel pineConeStats;
    private JLabel squeakyToyStats;
    private JLabel princessStats;
    private JButton revivePetThree;
    private JLabel statePetThree;
    private JButton revivePetTwo;
    private JButton reviveButton;
    private JLabel statePetOne;
    private JLabel statePetTwo;
    private JLabel petOneActionCount;
    private JLabel petTwoActionCount;
    private JLabel petThreeActionCount;
    private JButton endDayFinal;
    private JPanel scoreScreen;
    private JPanel gridScoreScreen;
    private JLabel dayCount;
    private JButton dealWithPetThree;
    private JButton dealWithPetOne;
    private JButton dealWithPetTwo;
    private JLabel dragonFavToyLabel;
    private JLabel dragonFavFoodLabel;
    private JLabel dragonDmgToyLabel;
    private JLabel dragonPlayLabel;
    private JLabel pandaFavToyLabel;
    private JLabel pandaFavFoodLabel;
    private JLabel pandaDmgToyLabel;
    private JLabel pandaPlayLabel;
    private JTextArea dragonDescription;
    private JTextArea pandaDescription;
    private JTextArea foxDescription;
    private JTextArea butterflyDescription;
    private JLabel foxFavToyLabel;
    private JLabel foxFavFoodLabel;
    private JLabel foxDmgToysLabel;
    private JLabel foxPlayLabel;
    private JLabel butterflyFavToyLabel;
    private JLabel butterflyFavFoodLabel;
    private JLabel butterflyDmgToysLabel;
    private JLabel butterflyPlayLabel;
    private JLabel penguinFavToyLabel;
    private JLabel penguinFavFoodLabel;
    private JLabel penguinDmgToysLabel;
    private JLabel penguinPlayLabel;
    private JLabel dogFavToyLabel;
    private JLabel dogFavFoodLabel;
    private JLabel dogDmgToyLabel;
    private JLabel dogPlayLabel;
    private JLabel playerOneScoreLabel;
    private JLabel playerTwoScoreLabel;
    private JLabel playerThreeScoreLabel;
    private JButton quitButton;
    private JButton helpButton;
    private JPanel helpSection;
    private JPanel gridLayoutHelp;
    private JTextPane helpTextPane;
    private JButton setupButton;
    private JScrollPane penScrollPane;
    private JScrollPane dogScrollPane;
    private JScrollPane foxScrollPane;
    private JScrollPane butterflyScrollPane;
    private JScrollPane dragScollPane;
    private JScrollPane pandaScrollPane;

    private JButton currentPetSelectionButton;
    private Border noBorder =  new LineBorder(new Color(229,222,255), 2, true);

    private CardLayout cardLayout = new CardLayout();
    private JFrame frame = new JFrame("Pets Pets Pets!");

    ///////////////////pet images////////////////////

    private ImageIcon penguin = new ImageIcon(this.getClass().getResource("images/penguinRE.png"));
    private ImageIcon foxyFox = new ImageIcon(this.getClass().getResource("images/foxRE.png"));
    private ImageIcon dragon = new ImageIcon(this.getClass().getResource("images/dragonRE.gif"));
    private ImageIcon redPanda = new ImageIcon(this.getClass().getResource("images/pandaRE.png"));
    private ImageIcon dog = new ImageIcon(this.getClass().getResource("images/dogRE.gif"));
    private ImageIcon butterfly = new ImageIcon(this.getClass().getResource("images/butterflyRE.gif"));
    //private ImageIcon penguin = new ImageIcon(new ImageIcon("images/neutralPenguin.png").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
    //private ImageIcon dog = new ImageIcon(new ImageIcon("images/neutralDog.gif").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
    //private ImageIcon butterfly =  new ImageIcon(new ImageIcon("images/neutralButterfly.gif").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
    //private ImageIcon redPanda =  new ImageIcon(new ImageIcon("images/neutralPanda.gif").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
    //private ImageIcon foxyFox = new ImageIcon(new ImageIcon("images/neutralFox.png").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
    //private ImageIcon dragon = new ImageIcon(new ImageIcon("images/dragonStatic.gif").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));

    ////////////food images////////////////////////
    private ImageIcon icyFish = new ImageIcon(this.getClass().getResource("images/fishRe.png"));
    private ImageIcon dogFood = new ImageIcon(this.getClass().getResource("images/dogFoodRE.png"));
    private ImageIcon honey = new ImageIcon(this.getClass().getResource("images/honeyRE.gif"));
    private ImageIcon wish = new ImageIcon(this.getClass().getResource("images/wishRE.gif"));
    private ImageIcon apple = new ImageIcon(this.getClass().getResource("images/appleRE.png"));
    private ImageIcon cow = new ImageIcon(this.getClass().getResource("images/cowRE.gif"));
    //private ImageIcon icyFish = new ImageIcon(new ImageIcon("images/fish.png").getImage().getScaledInstance(75, 75, Image.SCALE_DEFAULT));
    //private ImageIcon dogFood = new ImageIcon(new ImageIcon("images/dogFood.png").getImage().getScaledInstance(75, 75, Image.SCALE_DEFAULT));
    //private ImageIcon honey = new ImageIcon(new ImageIcon("images/honey.gif").getImage().getScaledInstance(75, 75, Image.SCALE_DEFAULT));
    //private ImageIcon wish = new ImageIcon(new ImageIcon("images/wish.gif").getImage().getScaledInstance(75, 75, Image.SCALE_DEFAULT));
    //private ImageIcon apple = new ImageIcon(new ImageIcon("images/apple.png").getImage().getScaledInstance(75, 75, Image.SCALE_DEFAULT));
   // private ImageIcon cow = new ImageIcon(new ImageIcon("images/cow.gif").getImage().getScaledInstance(75, 75, Image.SCALE_DEFAULT));

    /////////////////toy images//////////////////////////
    private ImageIcon flower = new ImageIcon(this.getClass().getResource("images/flowerRE.png"));
    private ImageIcon ball = new ImageIcon(this.getClass().getResource("images/ballRE.png"));
    private ImageIcon princess = new ImageIcon(this.getClass().getResource("images/princessRE.gif"));
    private ImageIcon pinecone = new ImageIcon(this.getClass().getResource("images/pineconeRE.gif"));
    private ImageIcon iceBerg = new ImageIcon(this.getClass().getResource("images/icebergRE.png"));
    private ImageIcon squeakyToy = new ImageIcon(this.getClass().getResource("images/squeakyToyRE.gif"));
    private ImageIcon cross = new ImageIcon(this.getClass().getResource("images/crossRE.png"));
    private ImageIcon add = new ImageIcon(this.getClass().getResource("images/addRE.png"));
   //private ImageIcon flower = new ImageIcon(new ImageIcon("images/flower.png").getImage().getScaledInstance(75, 75, Image.SCALE_DEFAULT));
   //private ImageIcon ball = new ImageIcon(new ImageIcon("images/ball.png").getImage().getScaledInstance(75, 75, Image.SCALE_DEFAULT));
    //private ImageIcon princess = new ImageIcon(new ImageIcon("images/princess.gif").getImage().getScaledInstance(75, 75, Image.SCALE_DEFAULT));
    //private ImageIcon pinecone = new ImageIcon(new ImageIcon("images/pinecone.gif").getImage().getScaledInstance(75, 75, Image.SCALE_DEFAULT));
   //private ImageIcon iceBerg = new ImageIcon(new ImageIcon("images/iceberg.png").getImage().getScaledInstance(75, 75, Image.SCALE_DEFAULT));
    //private ImageIcon squeakyToy = new ImageIcon(new ImageIcon("images/squeakyToy.gif").getImage().getScaledInstance(75, 75, Image.SCALE_DEFAULT));
    //private ImageIcon cross = new ImageIcon(new ImageIcon("images/cross2.png").getImage().getScaledInstance(75, 75, Image.SCALE_DEFAULT));
    //ImageIcon img = new ImageIcon(this.getClass().getResource("images/cross2.png"));
    //private ImageIcon add = new ImageIcon(new ImageIcon("images/add.png").getImage().getScaledInstance(75, 75, Image.SCALE_DEFAULT));


    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////ADD LISTENERS TO PURCHASE BUTTONS//////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    /**
     * Adds the flower into the player's inventory after it is purchased.
     * @param a - Action Listener
     */

    public void addMagicalFlowerListener(ActionListener a){
        magicalFlowerPurchase.addActionListener(a);
    }


    /**
     *Adds the iceberg into the player's inventory after it is purchased.
     * @param a - Action Listener
     */

    public void addIcebergListener(ActionListener a){
        icebergPurchase.addActionListener(a);
    }

    /**
     *Adds the ball into the player's inventory after it is purchased.
     * @param a - Action Listener
     */

    public void addBallListener(ActionListener a){
        ballPurchase.addActionListener(a);
    }

    /**
     *Adds the squeaky toy into the player's inventory after it is purchased.
     * @param a - Action Listener
     */

    public void addSqueakyToyListener(ActionListener a){
        squeakyToyPurchase.addActionListener(a);
    }

    /**
     *Adds the princess into the player's inventory after it is purchased.
     * @param a - Action Listener
     */

    public void addPrincessListener(ActionListener a){
        princessPurchase.addActionListener(a);
    }

    /**
     *Adds the pinecone into the player's inventory after it is purchased.
     * @param a - Action Listener
     */

    public void addPineConeListener(ActionListener a){
        pineConePurchase.addActionListener(a);
    }

    /**
     *Adds the wish into the player's inventory after it is purchased.
     * @param a - Action Listener
     */

    public void addWishListener(ActionListener a){
        wishPurchase.addActionListener(a);
    }

    /**
     *Adds the dog food into the player's inventory after it is purchased.
     * @param a - Action Listener
     */

    public void addDogFoodListener(ActionListener a){
        dogFoodPurchase.addActionListener(a);
    }

    /**
     *Adds the fish into the player's inventory after it is purchased.
     * @param a - Action Listener
     */

    public void addIceFishListener(ActionListener a){
        icyFishPurchase.addActionListener(a);
    }

    /**
     *Adds the apple into the player's inventory after it is purchased.
     * @param a - Action Listener
     */

    public void addAppleListener(ActionListener a){
        applePurchase.addActionListener(a);
    }

    /**
     *Adds the honey into the player's inventory after it is purchased.
     * @param a - Action Listener
     */


    public void addHoneyListener(ActionListener a){
        honeyPurchase.addActionListener(a);
    }

    /**
     *Adds the cow into the player's inventory after it is purchased.
     * @param a - Action Listener
     */

    public void addCowListener(ActionListener a){
        cowPurchase.addActionListener(a);
    }

    /**
     *Adds the button and when it is clicked, takes the player to the inventory screen.
     * @param a - Action Listener
     */

    public void addInventoryListener(ActionListener a){
        inventoryButton.addActionListener(a);
    }



    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////END ADD LISTENERS TO PURCHASE BUTTONS/////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     *Getter for the Penguin image icon.
     * @return ImageIcon - returns the ImageIcon object of the Penguin.
     */

    public ImageIcon getPenguinImage(){
        return penguin;
    }

    /**
     *Getter for the Dog image icon.
     * @return ImageIcon - returns the ImageIcon object of the Dog.
     */

    public ImageIcon getDogImage(){
        return dog;
    }

    /**
     *Getter for the Butterfly image icon.
     * @return ImageIcon - returns the ImageIcon object of the Butterfly.
     */

    public ImageIcon getButterflyImage(){
        return butterfly;
    }

    /**
     *Getter for the Red Panda image icon.
     * @return ImageIcon - returns the ImageIcon object of the Red Panda.
     */

    public ImageIcon getRedPandaImage(){
        return redPanda;
    }

    /**
     *Getter for the Foxy Fox image icon.
     * @return ImageIcon - returns the ImageIcon object of the Foxy Fox.
     */

    public ImageIcon getFoxyFoxImage(){
        return foxyFox;
    }

    /**
     *Getter for the Dragon image icon.
     * @return ImageIcon - returns the ImageIcon object of the Dragon.
     */

    public ImageIcon getDragonImage(){
        return dragon;
    }

    /**
     *Getter for the currentPetSelectionButton.
     * @return currentPetSelectionButton.
     */

    public JButton getCurrentPetSelectionButton(){
        return currentPetSelectionButton;
    }

    /**
     *Setter for the currentPetSelectionButton.
     * @param button - currentPetSelectionButton
     */

    public void setCurrentPetSelectionButton(JButton button){
        currentPetSelectionButton = button;
    }

    /**
     *Th first listener we created, and forgot what it does, but it does something important.
     * @param a - Action Listener
     */

    public void addListener3(ActionListener a){
        button3.addActionListener(a);
    }

    /**
     *Adds the set up button which proceeds to the set up menu.
     * @param a - Action Listener
     */

    public void addSetUpButton(ActionListener a){
        proceedToNextStageButton.addActionListener(a);
    }

    /**
     *Adds the button which checks if the name input is valid.
     * @param a - Action Listener
     */

    public void addCheckNamePlayerOneListener(ActionListener a){
        checkNameButtonPlayerOne.addActionListener(a);
    }

    /**
     *Adds a button to take the player to the next page in the pet selection menu.
     * @param a - Action Listener
     */

    public void addNextPageListener(ActionListener a){
        nextPageOneButton.addActionListener(a);
    }


    /**
     *Adds a button to take the player to the previous page in the pet selection menu.
     * @param a - Action Listener
     */

    public void addPreviousPageListener1(ActionListener a){
        previousPageButton.addActionListener(a);
    }

    /**
     *Adds a button to take the player to the next page in the pet selection menu.
     * @param a - Action Listener
     */

    public void addNextPageTwoListener(ActionListener a){nextPageTwoButton.addActionListener(a);}

    /**
     *Adds a button to take the player to the previous page in the pet selection menu.
     * @param a - Action Listener
     */

    public void addPreviousPageThreeListener(ActionListener a){previousPageThreeButton.addActionListener(a);}

    /**
     *Adds the Penguin object to the player's array of pets after selection.
     * @param a - Action Listener
     */

    public void addPenguin(ActionListener a){addPenguin.addActionListener(a);}

    /**
     *Adds the Dog object to the player's array of pets after selection.
     * @param a - Action Listener
     */

    public void addDog(ActionListener a){addDog.addActionListener(a);}

    /**
     *Adds the Fox object to the player's array of pets after selection.
     * @param a - Action Listener
     */

    public void addFox(ActionListener a){addFox.addActionListener(a);}

    /**
     *Adds the Butterfly object to the player's array of pets after selection.
     * @param a - Action Listener
     */

    public void addButterfly(ActionListener a){addButterfly.addActionListener(a);}

    /**
     *Adds the Dragon object to the player's array of pets after selection.
     * @param a - Action Listener
     */

    public void addDragon(ActionListener a){addDragon.addActionListener(a);}

    /**
     *Adds the Panda object to the player's array of pets after selection.
     * @param a - Action Listener
     */

    public void addPanda(ActionListener a){addPanda.addActionListener(a);}

    /**
     *Proceeds to the next player during the pet selection screen.
     * @param a - Action Listener
     */

    public void addProceedToPlayerTwoListener(ActionListener a){proceedToPlayerTwo.addActionListener(a);}

    /**
     *Adds the end day button.
     * @param a - Action Listener
     */

    public void addEndDayButton(ActionListener a){endDayButton.addActionListener(a);}

    /**
     *Adds the feed button for pet one.
     * @param a - Action Listener
     */

    public void addFeedPetOneListeners(ActionListener a){
        feedPlayPetOne.addActionListener(a);
    }

    /**
     *Adds the feed button for pet two.
     * @param a - Action Listener
     */

    public void addFeedPetTwoListeners(ActionListener a){
        feedPlayPetTwo.addActionListener(a);
    }

    /**
     *Adds the feed button for pet three.
     * @param a - Action Listener
     */

    public void addFeedPetThreeListeners(ActionListener a){
        feedPlayPetThree.addActionListener(a);
    }

    /**
     *Adds the visit bathroom button for pet one.
     * @param a - Action Listener
     */

    public void addVisitBathroomPetOneListeners(ActionListener a){
        bathroomPetOne.addActionListener(a);
    }

    /**
     *Adds the visit bathroom button for pet two.
     * @param a - Action Listener
     */

    public void addVisitBathroomPetTwoListeners(ActionListener a){
        bathroomPetTwo.addActionListener(a);
    }

    /**
     *Adds the visit bathroom button for pet three.
     * @param a - Action Listener
     */

    public void addVisitBathroomPetThreeListeners(ActionListener a){
        bathroomPetThree.addActionListener(a);
    }

    /**
     *Adds the sleep button for pet one.
     * @param a - Action Listener
     */

    public void addSleepPetOneListeners(ActionListener a){
        sleepPetOne.addActionListener(a);
    }

    /**
     *Adds the sleep button for pet two.
     * @param a - Action Listener
     */

    public void addSleepPetTwoListeners(ActionListener a){
        sleepPetTwo.addActionListener(a);
    }

    /**
     *Adds the sleep button for pet three.
     * @param a - Action Listener
     */

    public void addSleepPetThreeListeners(ActionListener a){
        sleepPetThree.addActionListener(a);
    }

    /**
     *Adds the revive button for pet one if pet is dead and revives remaining.
     * @param a - Action Listener
     */

    public void addRevivePetOneListener(ActionListener a){
        reviveButton.addActionListener(a);
    }

    /**
     *Adds the revive button for pet two if pet is dead and revives remaining.
     * @param a - Action Listener
     */

    public void addRevivePetTwoListener(ActionListener a){
        revivePetTwo.addActionListener(a);
    }

    /**
     *Adds the revive button for pet three if pet is dead and revives remaining.
     * @param a - Action Listener
     */

    public void addRevivePetThreeListener(ActionListener a){
        revivePetThree.addActionListener(a);
    }


    /**
     *Enables the revive button for pet one.
     */

    public void enableRevivePetOne(){
        reviveButton.setEnabled(true);
    }

    /**
     *Disables the revive button for player one. For example if it has already been used.
     */

    public void disableRevivePetOne(){
        reviveButton.setEnabled(false);
    }

    /**
     *Enables the revive button for pet one.
     */

    public void enableRevivePetTwo(){
        revivePetTwo.setEnabled(true);
    }

    /**
     *Disables the revive button for player two. For example if it has already been used.
     */

    public void disableRevivePetTwo(){
        revivePetTwo.setEnabled(false);
    }

    /**
     *Enables the revive button for pet one.
     */

    public void enableRevivePetThree(){
        revivePetThree.setEnabled(true);
    }

    /**
     *Disables the revive button for player three. For example if it has already been used.
     */

    public void disableRevivePetThree(){
        revivePetThree.setEnabled(false);
    }

    /**
     *Executes methods connected to the "Treat or Discipline" button for pet one.
     * Displays their respective prompts when the button is pressed and state of pet is either Sick or Misbehaving.
     * @param a - Action Listener
     */

    public void addDealWithPetOneActionListener(ActionListener a){
        dealWithPetOne.addActionListener(a);
    }

    /**
     *Executes methods connected to the "Treat or Discipline" button for pet two.
     * Displays their respective prompts when the button is pressed and state of pet is either Sick or Misbehaving.
     * @param a - Action Listener
     */

    public void addDealWithPetTwoActionListener(ActionListener a){
        dealWithPetTwo.addActionListener(a);
    }

    /**
     *Executes methods connected to the "Treat or Discipline" button for pet three.
     * Displays their respective prompts when the button is pressed and state of pet is either Sick or Misbehaving.
     * @param a - Action Listener
     */

    public void addDealWithPetThreeActionListener(ActionListener a){
        dealWithPetThree.addActionListener(a);
    }

    /**
     *Enables the button "Treat or Discipline" if the state of the pet is "Sick" or "misbehaving".
     * @param i - The pet the button should be enabled for.
     */

    public void enableDealWithPetsBtns(int i){
        JButton[] btns = {dealWithPetOne,dealWithPetTwo,dealWithPetThree};
        btns[i].setEnabled(true);
    }

    /**
     *Disables the button "Treat or Discipline" once the state of the pet returns to Alive (or Dead).
     * @param i - The pet the button should be enabled for.
     */

    public void disableDealWithPetsBtns(int i){
        JButton[] btns = {dealWithPetOne,dealWithPetTwo,dealWithPetThree};
        btns[i].setEnabled(false);
    }

    /**
     *Sets the state of the pet to display on the JLabel. This method is run in a loop. We need to pass in the pet
     * in order to access the state of the pet and the i is the corresponding pet number which is used to set the label.
     * @param pet Pet - The pet for which the label should be updated. Necessary to pass in as parameter so its
     *            state value can be accessed.
     * @param i int - The index of the pet for which the state label should be set.
     */

    public void setStatePetLabel(Pet pet, int i) {
        JLabel[] petLabels = {statePetOne, statePetTwo, statePetThree};
        petLabels[i].setText(pet.getState());

    }

    /**
     *Listens to when player clicks the visit store button and changes the screen accordingly.
     * @param a - Action Listener
     */

    public void addVisitStoreListener(ActionListener a){
        visitStore.addActionListener(a);
    }

    /**
     *Listens to when player clicks the exit store button and changes the screen accordingly.
     * @param a - Action Listener
     */

    public void addExitStoreListener(ActionListener a){
        exitStore.addActionListener(a);
    }

    /**
     *Listens to when player clicks the exit inventory button and changes the screen accordingly.
     * @param a - Action Listener
     */

    public void addExitInventoryListener(ActionListener a){exitInventoryButton.addActionListener(a);}

    /**
     * Sets up the menu for pet selection by adding the placeholder (+) images, labels and buttons for each player.
     * Note that although the buttons are labeled "petOnePlayerOne" they are applicable to not only player one but
     * all three potential players. And it is also run for all three players during their pet selection screen
     * (which is identical for all three players).
     */

    public void addPetSelectionImages(){
        petOnePlayerOne.setBackground(new Color(242,242,242));
        petOnePlayerOne.setIcon(add);
        petOnePlayerOne.setText("");
        petTwoPlayerOne.setBackground(new Color(242,242,242));
        petTwoPlayerOne.setIcon(add);
        petTwoPlayerOne.setText("");
        petThreePlayerOne.setBackground(new Color(242,242,242));
        petThreePlayerOne.setIcon(add);
        petThreePlayerOne.setText("");
        petNameOne.setEditable(false);
        petNameOne.setEnabled(false);
        petNameTwo.setEnabled(false);
        petNameTwo.setEditable(false);
        petNameThree.setEditable(false);
        petNameThree.setEnabled(false);
        petNameOne.setText("");
        petNameTwo.setText("");
        petNameThree.setText("");
    }

    /**
     *Listener for when the quit button is pressed after the score is displayed at the end of the game.
     * @param a - Action Listener
     */

    public void addQuitButtonListener(ActionListener a){
        quitButton.addActionListener(a);
    }

    /**
     *This method disables the name check button after it has been clicked and the name has been accepted.
     */

    public void disablePlayerNameCheckBtn(){
        checkNameButtonPlayerOne.setEnabled(false);
    }

    /**
     *Changes the label of the current player in the set up screen.
     * @param currentPlayer is the currrent player in the menu screen.
     */


    public void changePlayerTitle(int currentPlayer){
        if (currentPlayer == 1){
            petSelectionPlayerTitle.setText("Player Two");
        }else{
            petSelectionPlayerTitle.setText("Player Three");
        }
        if (currentPlayer < 3){
            petOnePlayerOne.setBorder(new JButton().getBorder());
            petOnePlayerOne.setSize(new JButton().getSize());
            petOnePlayerOne.setBackground(new JButton().getBackground());
            petOnePlayerOne.setContentAreaFilled(true);
            petOnePlayerOne.setText("Add Pet");
            petOnePlayerOne.setIcon(new JButton().getIcon());
            petTwoPlayerOne.setBorder(new JButton().getBorder());
            petTwoPlayerOne.setSize(new JButton().getSize());
            petTwoPlayerOne.setBackground(new JButton().getBackground());
            petTwoPlayerOne.setContentAreaFilled(true);
            petTwoPlayerOne.setText("Add Pet");
            petTwoPlayerOne.setIcon(new JButton().getIcon());
            petThreePlayerOne.setBorder(new JButton().getBorder());
            petThreePlayerOne.setSize(new JButton().getSize());
            petThreePlayerOne.setBackground(new JButton().getBackground());
            petThreePlayerOne.setContentAreaFilled(true);
            petThreePlayerOne.setText("Add Pet");
            petThreePlayerOne.setIcon(new JButton().getIcon());
            playerNameText.setBackground(new JTextField().getBackground());
            playerNameText.setText(new JTextField().getText());
            checkNameButtonPlayerOne.setText("Check Name!");
            playerNameText.setEditable(true);
        }


    }

    /**
     *This method sets up and displays the vital statistics of each pet in the form of a series of Progress Bars.
     * It creates labels for each stat, finds the value the pet has of each stat and then sets the colour and
     * length of teh progress bar accordingly.
     * @param health int - The health of the pet.
     * @param tiredness int - How tired the pet is.
     * @param hunger int - How hungry the pet is.
     * @param mood int - The mood level of the pet. The higher the better.
     * @param bathroom int - The level of need to go to the bathroom.
     * @param i int - The index of the pet this method is being executed for. It will iterate through up to
     *          three potential pets.
     */

    public void showPetStats(double health, double tiredness, double hunger, double mood, double bathroom, int i){
        JLabel[] petHealth = {healthPetOne,healthPetTwo,healthPetThree};
        JLabel[] petTiredness = {tirednessPetOne,tirednessPetTwo,tirednessPetThree};
        JLabel[] petHunger = {hungerPetOne,hungerPetTwo,hungerPetThree};
        JLabel[] petMood = {moodPetOne,moodPetTwo,moodPetThree};
        JLabel[] petBathroom = {bathroomStatPetOne,bathroomStatPetTwo,bathroomStatPetThree};
        petHealth[i].setText(String.valueOf(health));
        petTiredness[i].setText(String.valueOf(tiredness));
        petHunger[i].setText(String.valueOf(hunger));
        petMood[i].setText(String.valueOf(mood));
        petBathroom[i].setText(String.valueOf(bathroom));
        JProgressBar[] petHealthBar = {healthProgressBarOne,healthProgessBarTwo,healthProgressBarThree};
        JProgressBar[] petTirednessBar = {tirednessProgressBarOne,tirednessProgressBarTwo,tirednessProgressBarThree};
        JProgressBar[] petHungerBar = {hungerProgressBarOne,hungerProgressBarTwo,hungerProgressBarThree};
        JProgressBar[] petMoodBar = {moodProgressBarOne,moodProgressBarTwo,moodProgressBarThree};
        JProgressBar[] petBathroomBar = {bathroomProgressBarOne,bathroomProgressBarTwo,bathroomProgressBarPetThree};
        petHealthBar[i].setValue((int)health);
        petHealthBar[i].setForeground(new Color(102,255,26));
        petHealthBar[i].setBorder(BorderFactory.createLineBorder(new Color(102,255,26)));
        petTirednessBar[i].setValue((int)tiredness);
        petTirednessBar[i].setForeground(new Color(102,255,26));
        petTirednessBar[i].setBorder(BorderFactory.createLineBorder(new Color(102,255,26)));
        petHungerBar[i].setValue((int)hunger);
        petHungerBar[i].setForeground(new Color(102,255,26));
        petHungerBar[i].setBorder(BorderFactory.createLineBorder(new Color(102,255,26)));
        petMoodBar[i].setValue((int)mood);
        petMoodBar[i].setForeground(new Color(102,255,26));
        petMoodBar[i].setBorder(BorderFactory.createLineBorder(new Color(102,255,26)));
        petBathroomBar[i].setValue((int)bathroom);
        petBathroomBar[i].setForeground(new Color(102,255,26));
        petBathroomBar[i].setBorder(BorderFactory.createLineBorder(new Color(102,255,26)));

        if (health < 70){
            petHealthBar[i].setForeground(new Color(217,255,26));
            petHealthBar[i].setBorder(BorderFactory.createLineBorder(new Color(217,255,26)));
        }if (tiredness < 70){
            petTirednessBar[i].setForeground(new Color(217,255,26));
            petTirednessBar[i].setBorder(BorderFactory.createLineBorder(new Color(217,255,26)));
        }if (hunger < 70){
            petHungerBar[i].setForeground(new Color(217,255,26));
            petHungerBar[i].setBorder(BorderFactory.createLineBorder(new Color(217,255,26)));
        }if (mood < 70){
            petMoodBar[i].setForeground(new Color(217,255,26));
            petMoodBar[i].setBorder(BorderFactory.createLineBorder(new Color(217,255,26)));
        }if (bathroom < 70){
            petBathroomBar[i].setForeground(new Color(217,255,26));
            petBathroomBar[i].setBorder(BorderFactory.createLineBorder(new Color(217,255,26)));
        }


        if (health < 30){
            petHealthBar[i].setForeground(new Color(255,64,26));
            petHealthBar[i].setBorder(BorderFactory.createLineBorder(new Color(255,64,26)));
        }if (tiredness < 30){
            petTirednessBar[i].setForeground(new Color(255,64,26));
            petTirednessBar[i].setBorder(BorderFactory.createLineBorder(new Color(255,64,26)));
        }if (hunger < 30){
            petHungerBar[i].setForeground(new Color(255,64,26));
            petHungerBar[i].setBorder(BorderFactory.createLineBorder(new Color(255,64,26)));
        }if (mood < 30){
            petMoodBar[i].setForeground(new Color(255,64,26));
            petMoodBar[i].setBorder(BorderFactory.createLineBorder(new Color(255,64,26)));
        }if (bathroom < 30){
            petBathroomBar[i].setForeground(new Color(255,64,26));
            petBathroomBar[i].setBorder(BorderFactory.createLineBorder(new Color(255,64,26)));
        }

    }

    /**
     *When a pet is selected, the button changes form a button to the icon of the pet chosen.
     * This method therefore disables the buttons.
     */

    public void setDefaultDisabledIcon(){
        petOnePlayerOne.setDisabledIcon(new JButton().getDisabledIcon());
        petThreePlayerOne.setDisabledIcon(new JButton().getDisabledIcon());
        petTwoPlayerOne.setDisabledIcon(new JButton().getDisabledIcon());
    }

    /**
     *Sets up the screen for the pet selection.
     */

    public void setScreenUpForPlayerPetSelection(){
        addPetSelectionImages();
        checkNameButtonPlayerOne.setEnabled(true);
        petOnePlayerOne.setEnabled(false);
        petTwoPlayerOne.setEnabled(false);
        petThreePlayerOne.setEnabled(false);
        proceedToPlayerTwo.setEnabled(false);


    }

    /**
     *Takes the player to the help section screen.
     * @param a - Action Listener
     */


    public void addHelpSectionListeners(ActionListener a){helpButton.addActionListener(a);}


    /**
     *Returns the screen back to the main set up section after a player has been to the help section.
     * @param a - Action Listener
     */

    public void addReturnToSetUpListeners(ActionListener a){setupButton.addActionListener(a);}

    /**
     *Enables the button to add pet one once the player name has been accepted.
     */

    public void enablePetOneAddButton(){
        petOnePlayerOne.setEnabled(true);
    }

    /**
     *Enables the button to add pet two once pet one has been added successfully.
     */

    public void enablePetTwoAddButton(){
        petTwoPlayerOne.setEnabled(true);
        proceedToPlayerTwo.setEnabled(true);
    }

    /**
     *Enables the button to add pet three once pet two has been added successfully.
     */

    public void enablePetThreeAddButton(){
        petThreePlayerOne.setEnabled(true);
        proceedToPlayerTwo.setEnabled(true);
    }

    /**
     *Changes the name of the current payer. When player one ends their turn, this method will change the name
     * displayed to the next player.
     * @param name String - The player name to which the value of the label should be changed to.
     */

    public void changePlayerTitle(String name){
        playerTitle.setText(String.format("Current Player: \n%s", name.toUpperCase()));

    }

    /**
     *Disables the next player button. For example when the last player is playing. Instead of the option to go to
     * next payer, he will only have the option to "End day" instead, ending one cycle of the game.
     */

    public void disableNextPlayerBtn(){
        endDayButton.setEnabled(false);
    }

    /**
     *Enables the next player button. For example when switching from the last player to the first,
     * the button switches from "End day" back to "next player".
     */

    public void enableNextPlayerBtn(){
        endDayButton.setEnabled(true);
    }

    /**
     *Disables the "End day" button after the game swithes from the last player back to the first.
     */

    public void disableEndDayFinalBtn(){
        endDayFinal.setEnabled(false);
    }

    /**
     *Enables the "End day" button when the game screen goes to the last player.
     */

    public void enableEndDayFinalBtn(){
        endDayFinal.setEnabled(true);
    }

    /**
     *Listens for when the "end day" button is pressed.
     * @param a - Action Listener
     */

    public void addEndDayFinalListeners(ActionListener a){
        endDayFinal.addActionListener(a);
    }

    /**
     *When the player has one pet, the other two tabs are disabled,
     *when they have two pets, only the third tab is disabled. When a player has three pets,
     *this method does nothing as no tabs have to be disabled. Since they are all being used.
     * @param x int - number of pets a player has.
     */

    public void setTabbedPanePetSelections(int x){
        if (x == 1){
            tabbedPane1.setEnabledAt(1, false);
            tabbedPane1.setEnabledAt(2, false);
        }else if(x == 2){
            tabbedPane1.setEnabledAt(2, false);
        }

    }

    /**
     *Enables all the pet tabs at the end of each round and the start of the next day runs the check
     * for how many pets each player has again. This is necessary because the screens for the players need to be reset.
     */

    public void enableAllTabs(){
        tabbedPane1.setEnabledAt(1,true);
        tabbedPane1.setEnabledAt(2,true);
        tabbedPane1.setSelectedIndex(0);
    }

    /**
     *Sets the information for the Dragon selection screen.
     */


    public void setDragonInfo(){
        Dragon drag = new Dragon("Dragon");
        JLabel[] dragLabels = {dragonFavFoodLabel,dragonFavToyLabel,dragonDmgToyLabel,dragonPlayLabel};
        dragLabels[0].setText(drag.getFavouriteFood());
        dragLabels[1].setText(drag.getFavouriteToy());
        dragLabels[2].setText(Integer.toString(drag.getDamageToToys()));
        dragLabels[3].setText(Double.toString(drag.getPlayfulness()));
        dragonDescription.setText(drag.getDescription());
        dragonDescription.setLineWrap(true);
        dragonDescription.setWrapStyleWord(true);
        dragScollPane.setBorder(noBorder);
    }

    /**
     *Sets the information for the Red Panda selection screen.
     */

    public void setPandaInfo(){
        RedPanda panda = new RedPanda("Panda");
        JLabel[] pandaLabels = {pandaFavFoodLabel,pandaFavToyLabel,pandaDmgToyLabel,pandaPlayLabel};
        pandaLabels[0].setText(panda.getFavouriteFood());
        pandaLabels[1].setText(panda.getFavouriteToy());
        pandaLabels[2].setText(Integer.toString(panda.getDamageToToys()));
        pandaLabels[3].setText(Double.toString(panda.getPlayfulness()));
        pandaDescription.setText(panda.getDescription());
        pandaDescription.setLineWrap(true);
        pandaDescription.setWrapStyleWord(true);
        pandaScrollPane.setBorder(noBorder);
    }

    /**
     *Sets the information for the Fox selection screen.
     */

    public void setFoxInfo(){
        FoxyFox fox = new FoxyFox("Fox");
        JLabel[] foxLabels = {foxFavFoodLabel,foxFavToyLabel,foxDmgToysLabel,foxPlayLabel};
        foxLabels[0].setText(fox.getFavouriteFood());
        foxLabels[1].setText(fox.getFavouriteToy());
        foxLabels[2].setText(Integer.toString(fox.getDamageToToys()));
        foxLabels[3].setText(Double.toString(fox.getPlayfulness()));
        foxDescription.setText(fox.getDescription());
        foxDescription.setLineWrap(true);
        foxDescription.setWrapStyleWord(true);
        foxScrollPane.setBorder(noBorder);
    }

    /**
     *Sets the information for the Butterfly selection screen.
     */

    public void setButterflyInfo(){
        MagicalButterfly butterfly = new MagicalButterfly("Butterfly");
        JLabel[] butterflyLabels = {butterflyFavFoodLabel,butterflyFavToyLabel,butterflyDmgToysLabel,butterflyPlayLabel};
        butterflyLabels[0].setText(butterfly.getFavouriteFood());
        butterflyLabels[1].setText(butterfly.getFavouriteToy());
        butterflyLabels[2].setText(Integer.toString(butterfly.getDamageToToys()));
        butterflyLabels[3].setText(Double.toString(butterfly.getPlayfulness()));
        butterflyDescription.setText(butterfly.getDescription());
        butterflyDescription.setLineWrap(true);
        butterflyDescription.setWrapStyleWord(true);
        butterflyScrollPane.setBorder(noBorder);
    }

    /**
     *Sets the information for the Dog selection screen.
     */

    public void setDogInfo(){
        Dog dog = new Dog("Dog");
        JLabel[] dogLabels = {dogFavFoodLabel,dogFavToyLabel,dogDmgToyLabel,dogPlayLabel};
        dogLabels[0].setText(dog.getFavouriteFood());
        dogLabels[1].setText(dog.getFavouriteToy());
        dogLabels[2].setText(Integer.toString(dog.getDamageToToys()));
        dogLabels[3].setText(Double.toString(dog.getPlayfulness()));
        dogDescription.setText(dog.getDescription());
        dogDescription.setLineWrap(true);
        dogDescription.setWrapStyleWord(true);
        dogScrollPane.setBorder(noBorder);
    }

    /**
     *Sets the information for the Penguin selection screen.
     */

    public void setPenguinInfo(){
        Penguin penguin = new Penguin("Penguin");
        JLabel[] penguinLabels = {penguinFavFoodLabel,penguinFavToyLabel,penguinDmgToysLabel,penguinPlayLabel};
        penguinLabels[0].setText(penguin.getFavouriteFood());
        penguinLabels[1].setText(penguin.getFavouriteToy());
        penguinLabels[2].setText(Integer.toString(penguin.getDamageToToys()));
        penguinLabels[3].setText(Double.toString(penguin.getPlayfulness()));
        penguinDescription.setText(penguin.getDescription());
        penguinDescription.setLineWrap(true);
        penguinDescription.setWrapStyleWord(true);
        penScrollPane.setBorder(noBorder);
    }

    /**
     *Builds the GUI window. Sets the main panel and sets the Card Layout. Also adds cards to the card layout.
     */


    public void build(){
        frame.add(mainPanel);
        frame.pack();
        frame.setSize(850,500);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainPanel.setBounds(0,0,201,201);
        mainPanel.setBorder(BorderFactory.createLineBorder(new Color(234,234,234),20));
        //set all panels on the setup panel to be transparent
        topPanel.setOpaque(false);
        buttonPanel.setOpaque(false);
        questionPanel.setOpaque(false);
        inputPanel.setOpaque(false);
        centrePanel.setOpaque(false);
        setDragonInfo();
        setPandaInfo();
        setFoxInfo();
        setButterflyInfo();
        setDogInfo();
        setPenguinInfo();


        ////////////////////////////////////////////////////////
        /////////////Make buttons look nice/////////////////////
        ////////////////////////////////////////////////////////


        proceedToNextStageButton.setFocusPainted(false);
        proceedToPlayerTwo.setFocusPainted(false);
        checkNameButtonPlayerOne.setFocusPainted(false);
        petOnePlayerOne.setFocusPainted(false);
        petTwoPlayerOne.setFocusPainted(false);
        petThreePlayerOne.setFocusPainted(false);
        previousPageButton.setFocusPainted(false);
        nextPageOneButton.setFocusPainted(false);
        nextPageTwoButton.setFocusPainted(false);



        /////////////////////////////////////////////////////////
        //////////END Make buttons look nice/////////////////////
        /////////////////////////////////////////////////////////






        /////////////////////////////////////////////////////////////////////////////
        ///////////////////////////ADD PET IMAGES TO BUTTONS/////////////////////////
        /////////////////////////////////////////////////////////////////////////////

        penguinButton.setFocusPainted(false);
        penguinButton.setContentAreaFilled(false);
        penguinButton.setBorder(new EmptyBorder(0,0,0,0));
        penguinButton.setIcon(penguin);



        dogButton.setFocusPainted(false);
        dogButton.setContentAreaFilled(false);
        dogButton.setBorder(new EmptyBorder(0,0,0,0));
        dogButton.setIcon(dog);

        dragonButton.setFocusPainted(false);
        dragonButton.setContentAreaFilled(false);
        dragonButton.setBorder(new EmptyBorder(0,0,0,0));
        dragonButton.setIcon(dragon);


        butterflyButton.setFocusPainted(false);
        butterflyButton.setContentAreaFilled(false);
        butterflyButton.setBorder(new EmptyBorder(0,0,0,0));
        butterflyButton.setIcon(butterfly);


        foxButton.setFocusPainted(false);
        foxButton.setContentAreaFilled(false);
        foxButton.setBorder(new EmptyBorder(0,0,0,0));
        foxButton.setIcon(foxyFox);

        redPandaButton.setFocusPainted(false);
        redPandaButton.setContentAreaFilled(false);
        redPandaButton.setBorder(new EmptyBorder(0,0,0,0));
        redPandaButton.setIcon(redPanda);

        /////////////////////////////////////////////////////////////////////////////
        ///////////////////////END ADD PET IMAGES TO BUTTONS/////////////////////////
        /////////////////////////////////////////////////////////////////////////////
        disableRevivePetOne();
        disableRevivePetTwo();
        disableRevivePetThree();

        disableDealWithPetsBtns(0);
        disableDealWithPetsBtns(1);
        disableDealWithPetsBtns(2);


        //add cards to layout
        mainPanel.setLayout(cardLayout);
        mainPanel.add(setUpPanel,"SetUp");
        mainPanel.add(petSelectionPlayerOne,"PetSelectionPlayerOne");
        mainPanel.add(menu,"Menu");
        mainPanel.add(anotherPanel, "Another");
        mainPanel.add(allPets,"Pets1");
        mainPanel.add(allPetsPage2,"Pets2");
        mainPanel.add(allPetsPage3,"Pets3");
        mainPanel.add(store, "Store");
        mainPanel.add(inventory,"Inventory");
        mainPanel.add(scoreScreen,"Score");
        mainPanel.add(helpSection,"Help");
    }

    /**
     *Updates day counter.
     * @param currentDay int - Current Day.
     * @param numberDays int - Total number of days to be played.
     */

    public void updateDayCounter(int currentDay,int numberDays){
        dayCount.setText(String.format("Day %s/%s",currentDay,numberDays));
    }

    /**
     *Sets the name label of pet.
     * @param x int - Index o the pet in the Pet ArrayList.
     * @param name String - Name of the pet.
     */


    public void setPetNameLabel(int x, String name){
        String prefix = "NAME: ";
        if (x == 0){
            petNameOne.setText(prefix + name);
            petNameOne.setEnabled(true);
            petOnePlayerOne.setEnabled(false);
        }else if (x == 1){
            petNameTwo.setText( prefix + name);
            petNameTwo.setEnabled(true);
            petTwoPlayerOne.setEnabled(false);

        }else{
            petNameThree.setText(prefix + name);
            petNameThree.setEnabled(true);
            petThreePlayerOne.setEnabled(false);
        }
    }

    /**
     *When a player selects a pet, the placeholder icon image is replaced with the icon of the pet selected.
     * @param buttonToUpdate JButton - The button for which the image needs to be updated.
     * @param img ImageIcon - The icon which needs to be displayed on the button.
     */

    public void setPetAdditionImages(JButton buttonToUpdate, ImageIcon img){
        buttonToUpdate.setDisabledIcon(img);
        buttonToUpdate.setFocusPainted(true);
        buttonToUpdate.setContentAreaFilled(false);
        buttonToUpdate.setBorder(new EmptyBorder(0,0,0,0));
        buttonToUpdate.setIcon(img);
        buttonToUpdate.setText("");
    }



    ////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////ADD PET ICONS////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////


    /**
     *Adds the image to the main game screen after the payers have selected their pets.
     * @param img ImageIcon - The image which should be set
     * @param i int - Index of the pet for which this should be changed.
     * @param petName String - Name of the pet to be set to the label.

     */

    public void addPetIcons(ImageIcon img, int i,String petName){
        JButton[] buttonArray = {petOneIcon,petTwoIcon,petThreeIcon};
        JLabel[] labelArray = {petOneSpecies,petTwoSpecies,petThreeSpeices};
        buttonArray[i].setFocusPainted(true);
        buttonArray[i].setContentAreaFilled(false);
        buttonArray[i].setBorder(new EmptyBorder(0,0,0,0));
        buttonArray[i].setIcon(img);
        labelArray[i].setText(petName);

    }



    ////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////END ADD PET ICONS////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////


    /**
     *Adds image icons to all the items in a players inventory if they own them. Otherwise a placeholder icon is used.
     * @param foodInven ArrayList - Players food inventory.
     * @param toyInven ArrayList - Players toy inventory.
     */

    public void addInventoryImages(ArrayList<Food> foodInven, ArrayList<Toy> toyInven){
        JLabel[] slotLabels = {wishLabel, appleLabel, cowLabel, dogFoodLabel, honeyLabel, icyFishLabel, pineConeLabel, magicalFlowerLabel, princessLabel, squeakyToyLabel, ballLabel, iceBergLabel};
        JButton[] slotButtons2 = {wishButton, appleButton, cowButton, dogFoodButton, honeyButton, icyFishButton, pineConeButton, magicalFlowerButton, princessButton, squeakyToyButton, ballButton, iceBergButton};
        JButton[] slotButtons = {wishEat, appleEat, cowEat, dogFoodEat, honeyEat, icyFishEat, pineConePlay, magicalFlowerPlay, princessPlay, squeakyToyPlay, ballPlay, iceBergPlay};
        for (int x = 0; x<slotButtons2.length;x++){
            slotButtons2[x].setContentAreaFilled(false);
            slotButtons2[x].setFocusPainted(false);
            slotButtons2[x].setIcon(cross);
            slotButtons[x].setEnabled(false);
        }


        for (int i = 0; i<slotLabels.length;i++){
            for (int k = 0; k<foodInven.size();k++){
                if (foodInven.get(k).getName().equals(slotLabels[i].getText())){
                    ImageIcon img = getCorrectImage(foodInven.get(k).getName());
                    slotButtons2[i].setIcon(img);
                    slotButtons2[i].setFocusPainted(false);
                    slotButtons2[i].setContentAreaFilled(false);
                }
            }

            for (int x = 0; x<toyInven.size();x++){
                if (toyInven.get(x).getName().equals(slotLabels[i].getText())){
                    ImageIcon img = getCorrectImage(toyInven.get(x).getName());
                    slotButtons2[i].setIcon(img);
                    slotButtons2[i].setIcon(img);
                    slotButtons2[i].setFocusPainted(false);
                    slotButtons2[i].setContentAreaFilled(false);
                }
            }


        }




    }

    /**
     *Checks which image to retrieve.
     * @param name String - Name of the image.
     * @return ImageIcon - The image icon of the object called by the input name.
     */

    public ImageIcon getCorrectImage(String name){
        if (name.equals("Wish")){
            return wish;
        }else if (name.equals("Dog Food")){
            return dogFood;
        }else if (name.equals("Apple")){
            return apple;
        }else if (name.equals("Cow")){
            return cow;
        }else if (name.equals("Honey")){
            return honey;
        }else if (name.equals("Icy Fish")){
            return icyFish;
        }else if (name.equals("Squeaky Toy")){
            return squeakyToy;
        }else if (name.equals("Magical Flower")){
            return flower;
        }else if (name.equals("Princess")){
            return princess;
        }else if (name.equals("Pinecone")){
            return pinecone;
        }else if (name.equals("Ball")){
            return ball;
        }else{
            return iceBerg;
        }

    }

    /**
     *Listens to when pet eats the wish.
     * @param a - Action Listener
     */

    public void addWishEatListener(ActionListener a){
        wishEat.addActionListener(a);
    }

    /**
     *Listens to when pet eats the apple.
     * @param a - Action Listener
     */

    public void addAppleEatListener(ActionListener a){
        appleEat.addActionListener(a);
    }

    /**
     *Listens to when pet eats the cow.
     * @param a - Action Listener
     */

    public void addCowEatListener(ActionListener a){
        cowEat.addActionListener(a);
    }

    /**
     *Listens to when pet eats the dog food.
     * @param a - Action Listener
     */


    public void addDogFoodEatListener(ActionListener a){
        dogFoodEat.addActionListener(a);
    }

    /**
     *Listens to when pet eats the honey.
     * @param a - Action Listener
     */


    public void addHoneyEatListener(ActionListener a){
        honeyEat.addActionListener(a);
    }

    /**
     *Listens to when pet eats the fish.
     * @param a - Action Listener
     */

    public void addIcyFishEatListener(ActionListener a){
        icyFishEat.addActionListener(a);
    }

    /**
     *Listens to when pet plays with the pinecone.
     * @param a - Action Listener
     */

    public void addPineConePlayListener(ActionListener a){
        pineConePlay.addActionListener(a);
    }

    /**
     *Listens to when pet plays with the magical flower.
     * @param a - Action Listener
     */

    public void addMagicalFlowerPlayListener(ActionListener a){
        magicalFlowerPlay.addActionListener(a);
    }

    /**
     *Listens to when pet plays with the princess.
     * @param a - Action Listener
     */

    public void addPrincessPlayListener(ActionListener a){
        princessPlay.addActionListener(a);
    }

    /**
     *Listens to when pet plays with the squeaky toy.
     * @param a - Action Listener
     */

    public void addSqueakyToyPlayListener(ActionListener a){
        squeakyToyPlay.addActionListener(a);
    }

    /**
     *Listens to when pet plays with the ball.
     * @param a - Action Listener
     */

    public void addBallPlayListener(ActionListener a){
        ballPlay.addActionListener(a);
    }

    /**
     *Listens to when pet plays with the iceberg.
     * @param a - Action Listener
     */

    public void addIceBergPlayListener(ActionListener a){
        iceBergPlay.addActionListener(a);
    }

    /**
     *Sets up the feed buttons in the inventory if the item is a food and the player owns one.
     * @param foodInven ArrayList - The food inventory of the player.
     * @param toyInven ArrayList - The toy inventory of the player.
     */


    public void setFeedButtons(ArrayList<Food> foodInven, ArrayList<Toy> toyInven){
        JButton[] slotButtons = {wishEat, appleEat, cowEat, dogFoodEat, honeyEat, icyFishEat, pineConePlay, magicalFlowerPlay, princessPlay, squeakyToyPlay, ballPlay, iceBergPlay};
        JButton[] slotButtons2 = {wishButton, appleButton, cowButton, dogFoodButton, honeyButton, icyFishButton, pineConeButton, magicalFlowerButton, princessButton, squeakyToyButton, ballButton, iceBergButton};
        JLabel[] slotLabels = {wishLabel, appleLabel, cowLabel, dogFoodLabel, honeyLabel, icyFishLabel, pineConeLabel, magicalFlowerLabel, princessLabel, squeakyToyLabel, ballLabel, iceBergLabel};

        for (int x = 0; x<slotButtons2.length;x++){
            slotButtons2[x].setContentAreaFilled(false);
            slotButtons2[x].setFocusPainted(false);
            slotButtons2[x].setIcon(cross);
            slotButtons[x].setEnabled(false);
        }


        for (int i = 0; i<slotLabels.length;i++){
            for (int k = 0; k<foodInven.size();k++){
                if (foodInven.get(k).getName().equals(slotLabels[i].getText())){
                    ImageIcon img = getCorrectImage(foodInven.get(k).getName());
                    slotButtons2[i].setIcon(img);
                    slotButtons2[i].setFocusPainted(false);
                    slotButtons2[i].setContentAreaFilled(false);
                    slotButtons[i].setEnabled(true);
                }
            }

            for (int x = 0; x<toyInven.size();x++){
                if (toyInven.get(x).getName().equals(slotLabels[i].getText())){
                    ImageIcon img = getCorrectImage(toyInven.get(x).getName());
                    slotButtons2[i].setIcon(img);
                    slotButtons2[i].setIcon(img);
                    slotButtons2[i].setFocusPainted(false);
                    slotButtons2[i].setContentAreaFilled(false);
                    slotButtons[i].setEnabled(true);
                }
            }


        }

    }

    /**
     *Getter for the current tab the player is on.
     * @return int - index of the current tab, 0, 1 or 2.
     */


    public int getCurrentTab(){
        if (tabbedPane1.getSelectedIndex() == 0){
            return 0;
        }else if (tabbedPane1.getSelectedIndex() == 1){
            return 1;
        }else {
            return 2;
        }
    }

    /**
     *Adds all the images and labels to the store items.
     */

    public void addStoreImages() {

        Wish wishOne = new Wish();
        DogFood dogFoodOne = new DogFood();
        IcyFish icyFishOne = new IcyFish();
        Apple appleOne = new Apple();
        Cow cowOne = new Cow();
        Honey honeyOne = new Honey();

        String spaceConstants = "&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp ";

        /////////////////////////// WISH /////////////////////////////////////////

        wishImage.setIcon(wish);
        wishImage.setFocusPainted(true);
        wishDescriptionLabel.setText("<html>A magical " +
                "essence extracted<br>in an unknown way.</html>");
        wishDescriptionLabel.setFont(new Font("Serif", Font.ITALIC, 14));

        //wishStats.setFont(new Font());
        wishStats.setText(String.format("<html>Nutrition: %s %s <br>Tastiness: %s %s<br>Meal Size: %s %s<br></html>", spaceConstants,
                wishOne.getNutritionValue(), spaceConstants, wishOne.getTastiness(), spaceConstants, wishOne.getMealWeight()));
        wishStats.setHorizontalAlignment(SwingConstants.CENTER);
        wishStats.setVerticalAlignment(SwingConstants.CENTER);
        wishImage.setContentAreaFilled(false);
        wishImage.setBorder(new EmptyBorder(0, 0, 0, 0));

        //////////////////////// DOG FOOD ///////////////////////////////////////

        dogFoodImage.setIcon(dogFood);
        dogFoodDescription.setText("<html>Just normal boring dog food.<br>Don’t ask what's inside<br></html>");

        dogFoodImage.setContentAreaFilled(false);
        dogFoodImage.setBorder(new EmptyBorder(0, 0, 0, 0));

        dogFoodDescription.setFont(new Font("Serif", Font.ITALIC, 14));
        dogFoodStats.setText(String.format("<html>Nutrition: %s %s <br>Tastiness: %s %s<br>Meal Size: %s %s<br></html>", spaceConstants,
                dogFoodOne.getNutritionValue(), spaceConstants, dogFoodOne.getTastiness(), spaceConstants, dogFoodOne.getMealWeight()));
        dogFoodStats.setHorizontalAlignment(SwingConstants.CENTER);
        dogFoodStats.setVerticalAlignment(SwingConstants.CENTER);
        dogFoodImage.setContentAreaFilled(false);
        dogFoodImage.setBorder(new EmptyBorder(0, 0, 0, 0));

        ///////////////////////// ICY FISH/////////////////////////////

        icyFishImage.setIcon(icyFish);
        icyFishDescription.setText("<html>A nutritious " +
                "fish from the arctic<br> seas.</html>");
        icyFishImage.setContentAreaFilled(false);
        icyFishImage.setBorder(new EmptyBorder(0, 0, 0, 0));

        icyFishDescription.setFont(new Font("Serif", Font.ITALIC, 14));
        icyFishStats.setText(String.format("<html>Nutrition: %s %s <br>Tastiness: %s %s<br>Meal Size: %s %s<br></html>", spaceConstants,
                icyFishOne.getNutritionValue(), spaceConstants, icyFishOne.getTastiness(), spaceConstants, icyFishOne.getMealWeight()));
        icyFishStats.setHorizontalAlignment(SwingConstants.CENTER);
        icyFishStats.setVerticalAlignment(SwingConstants.CENTER);
        icyFishImage.setContentAreaFilled(false);
        icyFishImage.setBorder(new EmptyBorder(0, 0, 0, 0));

        /////////////////////////////////// APPLE /////////////////////////////////////////

        appleImage.setIcon(apple);
        appleDescription.setText("<html>A delicious juicy " +
                "apple from<br>your local organic certified<br>green grocer!</html>");
        appleImage.setContentAreaFilled(false);
        appleImage.setBorder(new EmptyBorder(0, 0, 0, 0));

        appleDescription.setFont(new Font("Serif", Font.ITALIC, 14));
        appleStats.setText(String.format("<html>Nutrition: %s %s <br>Tastiness: %s %s<br>Meal Size: %s %s<br></html>", spaceConstants,
                appleOne.getNutritionValue(), spaceConstants, appleOne.getTastiness(), spaceConstants, appleOne.getMealWeight()));
        appleStats.setHorizontalAlignment(SwingConstants.CENTER);
        appleStats.setVerticalAlignment(SwingConstants.CENTER);
        appleImage.setContentAreaFilled(false);
        appleImage.setBorder(new EmptyBorder(0, 0, 0, 0));

        ///////////////////////////////////// COW ///////////////////////////////////////////

        cowImage.setIcon(cow);
        cowDescription.setText(String.format("<html>A large cow to feed the hungry.<html>"));
        cowImage.setContentAreaFilled(false);
        cowImage.setBorder(new EmptyBorder(0, 0, 0, 0));

        cowDescription.setFont(new Font("Serif", Font.ITALIC, 14));
        cowStats.setText(String.format("<html>Nutrition: %s %s <br>Tastiness: %s %s<br>Meal Size: %s %s<br></html>", spaceConstants,
                cowOne.getNutritionValue(), spaceConstants, cowOne.getTastiness(), spaceConstants, cowOne.getMealWeight()));
        cowStats.setHorizontalAlignment(SwingConstants.CENTER);
        cowStats.setVerticalAlignment(SwingConstants.CENTER);
        cowImage.setContentAreaFilled(false);
        cowImage.setBorder(new EmptyBorder(0, 0, 0, 0));

        ////////////////////////////////// HONEY ////////////////////////////////

        honeyImage.setIcon(honey);
        honeyImage.setContentAreaFilled(false);
        honeyDescription.setText("<html>A truly exquisite " +
                "mix of liquid<br>pleasure</html>");
        honeyImage.setBorder(new EmptyBorder(0, 0, 0, 0));

        honeyDescription.setFont(new Font("Serif", Font.ITALIC, 14));
        honeyStats.setText(String.format("<html>Nutrition: %s %s <br>Tastiness: %s %s<br>Meal Size: %s %s<br></html>", spaceConstants,
                honeyOne.getNutritionValue(), spaceConstants, honeyOne.getTastiness(), spaceConstants, honeyOne.getMealWeight()));
        honeyStats.setHorizontalAlignment(SwingConstants.CENTER);
        honeyStats.setVerticalAlignment(SwingConstants.CENTER);
        honeyImage.setContentAreaFilled(false);
        honeyImage.setBorder(new EmptyBorder(0, 0, 0, 0));

        //////////////////////////////// MAGICAL FLOWER ////////////////////////////////////

        magicalFlowerImage.setIcon(flower);
        magicalFlowerImage.setContentAreaFilled(false);
        magicalFlowerDescriptions.setText("<html>This flower can phase <br> through dimensions at will.<html>");
        magicalFlowerImage.setBorder(new EmptyBorder(0, 0, 0, 0));

        magicalFlowerDescriptions.setFont(new Font("Serif", Font.ITALIC, 14));
        magicalFlowerStats.setText(String.format("<html>Favourite toy of the Magical<br>Butterfly.</html>"));
        magicalFlowerStats.setHorizontalAlignment(SwingConstants.CENTER);
        magicalFlowerStats.setVerticalAlignment(SwingConstants.CENTER);
        magicalFlowerImage.setContentAreaFilled(false);
        magicalFlowerImage.setBorder(new EmptyBorder(0, 0, 0, 0));

        ///////////////////////////////// ICEBERG ////////////////////////////////////////////

        icebergImage.setIcon(iceBerg);
        icebergImage.setContentAreaFilled(false);
        icebergDescription.setText("<html>This one probabaly won't sink<br> the Titanic</html>");
        icebergImage.setBorder(new EmptyBorder(0, 0, 0, 0));

        icebergDescription.setFont(new Font("Serif", Font.ITALIC, 14));
        iceBergStats.setText(String.format("<html>Favourite toy of the penguin!</html>"));
        iceBergStats.setHorizontalAlignment(SwingConstants.CENTER);
        iceBergStats.setVerticalAlignment(SwingConstants.CENTER);
        icebergImage.setContentAreaFilled(false);
        icebergImage.setBorder(new EmptyBorder(0, 0, 0, 0));

        ////////////////////////////////// BALL /////////////////////////////////////////////

        ballImage.setIcon(ball);
        ballImage.setContentAreaFilled(false);
        ballDescription.setText("<html>Basic ball, has functions <br> roll(), bounce() and getLost()</html>");
        ballImage.setBorder(new EmptyBorder(0, 0, 0, 0));

        ballDescription.setFont(new Font("Serif", Font.ITALIC, 14));
        ballStats.setText(String.format("<html>Favourite toy of the boring<br>Dog.</html>"));
        ballStats.setHorizontalAlignment(SwingConstants.CENTER);
        ballStats.setVerticalAlignment(SwingConstants.CENTER);
        ballImage.setContentAreaFilled(false);
        ballImage.setBorder(new EmptyBorder(0, 0, 0, 0));

        ///////////////////////////////// SQUEAKYTOY //////////////////////////////////////////

        squeakyToyImage.setIcon(squeakyToy);
        squeakyToyImage.setContentAreaFilled(false);
        squeakyToyDescription.setText("<html>Looks cute and makes sounds</html>");
        squeakyToyImage.setBorder(new EmptyBorder(0, 0, 0, 0));

        squeakyToyDescription.setFont(new Font("Serif", Font.ITALIC, 14));
        squeakyToyStats.setText(String.format("<html>Favourite toy of the Red<br>Panda.</html>"));
        squeakyToyStats.setHorizontalAlignment(SwingConstants.CENTER);
        squeakyToyStats.setVerticalAlignment(SwingConstants.CENTER);
        squeakyToyImage.setContentAreaFilled(false);
        squeakyToyImage.setBorder(new EmptyBorder(0, 0, 0, 0));

        /////////////////////////////////// PRINCESS ////////////////////////////////////////////

        princessImage.setIcon(princess);
        princessImage.setContentAreaFilled(false);
        princessDescription.setText("<html>Will become the heir to <br> the kingdom once she is rescued.</html>");
        princessImage.setBorder(new EmptyBorder(0, 0, 0, 0));

        princessDescription.setFont(new Font("Serif", Font.ITALIC, 14));
        princessStats.setText(String.format("<html>Favourite toy of the mighty<br>Dragon.</html>"));
        princessStats.setHorizontalAlignment(SwingConstants.CENTER);
        princessStats.setVerticalAlignment(SwingConstants.CENTER);
        princessImage.setContentAreaFilled(false);
        princessImage.setBorder(new EmptyBorder(0, 0, 0, 0));

        /////////////////////////////////// PINECONE ////////////////////////////////////////

        pineConeImage.setIcon(pinecone);
        pineConeImage.setContentAreaFilled(false);
        pineConeDescription.setText("<html>A super exciting cone of the<br>pine.</html>");
        pineConeImage.setBorder(new EmptyBorder(0, 0, 0, 0));

        pineConeDescription.setFont(new Font("Serif", Font.ITALIC, 14));
        pineConeStats.setText(String.format("<html>Favourite toy of the Foxy Fox.</html>"));
        pineConeStats.setHorizontalAlignment(SwingConstants.CENTER);
        pineConeStats.setVerticalAlignment(SwingConstants.CENTER);
        pineConeImage.setContentAreaFilled(false);
        pineConeImage.setBorder(new EmptyBorder(0, 0, 0, 0));
    }

    /**
     *Updates the currency label of the player.
     * @param currentCurrency String - The current currency the player has.
     */

    public void updatePlayerCurrencyLabel(String currentCurrency){
        currencyLabel.setText(String.format("Current GP: %s",currentCurrency));
    }

    /**
     *Hides the action buttons if the pet has already used up all their actions.
     */


    public void hidePetOneActionButtons(){
        feedPlayPetOne.setEnabled(false);
        sleepPetOne.setEnabled(false);
        bathroomPetOne.setEnabled(false);
    }

    /**
     *Shows the action buttons if the pet has actions remaining.
     */

    public void showPetOneActionButtons(){
        feedPlayPetOne.setEnabled(true);
        sleepPetOne.setEnabled(true);
        bathroomPetOne.setEnabled(true);

    }

    /**
     *Hides the action buttons if the pet has already used up all their actions.
     */

    public void hidePetTwoActionButtons(){
        feedPlayPetTwo.setEnabled(false);
        sleepPetTwo.setEnabled(false);
        bathroomPetTwo.setEnabled(false);
    }

    /**
     *Shows the action buttons if the pet has actions remaining.
     */

    public void showPetTwoActionButtons(){
        feedPlayPetTwo.setEnabled(true);
        sleepPetTwo.setEnabled(true);
        bathroomPetTwo.setEnabled(true);
    }

    /**
     *Hides the action buttons if the pet has already used up all their actions.
     */

    public void hidePetThreeActionButtons(){
        feedPlayPetThree.setEnabled(false);
        bathroomPetThree.setEnabled(false);
        sleepPetThree.setEnabled(false);
    }

    /**
     *Shows the action buttons if the pet has actions remaining.
     */

    public void showPetThreeActionButtons(){
        feedPlayPetThree.setEnabled(true);
        bathroomPetThree.setEnabled(true);
        sleepPetThree.setEnabled(true);
    }

    /**
     *Sets up the action count label for each pet.
     * @param x int - index of the pet
     * @param p Pet - Pet object from which to retrieve the value of actions left.
     */

    public void setPetActionCountLabel(int x, Pet p){
        if (x == 0){
            petOneActionCount.setText(String.format("Actions Left: %s",p.getActionCount()));
        }else if (x==1){
            petTwoActionCount.setText(String.format("Actions Left: %s",p.getActionCount()));
        }else{
            petThreeActionCount.setText(String.format("Actions Left: %s",p.getActionCount()));
        }
    }

    /**
     *Sets the labels of actions remaining for all three pets.
     */

    public void setAllPetActionCounts(){
        petOneActionCount.setText(String.format("Actions Left: %s",2));
        petTwoActionCount.setText(String.format("Actions Left: %s",2));
        petThreeActionCount.setText(String.format("Actions Left: %s",2));
    }

    /**
     *Displays the scores of all the players.
     * @param scores ArrayList - The list containing the player numbers, names and their scores.
     */


    public void displayScore(ArrayList<String> scores){
        JLabel[] playerScoreLabels = {playerOneScoreLabel,playerTwoScoreLabel,playerThreeScoreLabel};
        for (int i = 0; i < scores.size();i++){
            playerScoreLabels[i].setText(scores.get(i));
        }
    }

    /**
     *Getter for the cardLayout
     * @return cardLayout
     */

    public CardLayout getCardLayout(){
        return cardLayout;
    }

    /**
     *Getter for the main panel.
     * @return mainPanel
     */

    public JPanel getMainPanel(){
        return mainPanel;
    }

    /**
     *Getter for the player count.
     * @return String - Number of players retrieved from the text input.
     */

    public String getPlayerCount(){
        return playerCount.getText().trim();
    }

    /**
     *Getter for the number of days the game is to be played for.
     * @return String - Number of days retrieved form the text input.
     */

    public String getNumberDays(){
        return numberDays.getText().trim();
    }

    /**
     *Getter for a JFrame.
     * @return frame
     */

    public JFrame getFrame(){
        return frame;
    }

    /**
     *Reads the player name from the text area input (on the set up screen).
     * @return String - the name chosen by the player.
     */

    public String getPlayerNameText(){
        return playerNameText.getText().trim();
    }

    /**
     *Builds the field for the name text input.
     * @return JTextField - The field containing the name input by the player.
     */

    public JTextField getPlayerNameField(){
        return playerNameText;
    }

    /**
     *Returns the checkNameButtonPlayerOne.
     * @return checkNameButtonPlayerOne.
     */

    public JButton getCheckNameButtonPlayerOne(){
        return checkNameButtonPlayerOne;
    }

    /**
     *Returns the PetOneButton.
     * @return PetOneButton.
     */

    public JButton getPetOneButton(){return petOnePlayerOne;}

    /**
     *Returns the petTwoPlayerOne.
     * @return petTwoPlayerOne.
     */

    public JButton getPetTwoButton(){return petTwoPlayerOne;}

    /**
     *returns the petThreePlayerOne.
     * @return petThreePlayerOne.
     */

    public JButton getPetThreeButton(){return petThreePlayerOne;}

}

