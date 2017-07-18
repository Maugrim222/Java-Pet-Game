import jdk.nashorn.internal.scripts.JO;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.util.Arrays;

/**
 * Created by Arcis (Hayden and Tom) on 12/05/2017.
 */
public class Controller {
    private Game gameModel;
    private PetApp mainView;
    private int currentPlayerForPetSelection = 0;
    private int currentNumberPetsPlayer = 0;
    private int currentPlayerInMenu = 0;
    private int currentPet = 0;

    /**
     * Constructs a controller which handles user interactions with PetApp and gives listeners to all buttons.
     * @param g-the game logic/Model
     * @param a-the view model/Swing GUI
     */
    public Controller(Game g, PetApp a) {
        gameModel = g;
        mainView = a;
        addAddPetsButtonPlayerOneListeners();
        purchaseItems();
        addInventory();             //
        addEatActionListeners();   // SHOULD BE ADDED AS WE NEED RATHER THAN ADDING LISTENERS ON CONTROLLER INITAILISATION
        addPlayListeners();        //
        addSleepListeners();
        addBathroomListeners();
        revivePetBtnListeners();
        addPurchaseFoodListeners();
        addStoreAccessButtons();
        addHelpSectionStartUpListeners();
        addDealWithPetListeners();
        addEndDayListeners();


    }


    /////////////////////////////////////////////////////////////////////////////
    /////////////////////////CHANGE LATER BY SETTING STAIC IN OTHER CLASSES//////
    /////////////////////////////////////////////////////////////////////////////

    /**
     * Adds inventory button listener, so the button will listen for the user and proceed to the inventory screen when interacted with.
     */
    public void addInventory(){
        mainView.addInventoryListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainView.getCardLayout().show(mainView.getMainPanel(),"Inventory");
                Player[] players = gameModel.getPlayers();
                mainView.addInventoryImages(players[currentPlayerInMenu].getFoodItems(),players[currentPlayerInMenu].getToys());
            }
        });
    }





    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////FEEDING PETS/////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    /**
     * Takes Player to Inventory screen, updates the current pet being interacted with and sets all images/buttons/labels in the inventory.
     */

    public void addAddFeedListeners(){

        mainView.addFeedPetOneListeners(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                currentPet = mainView.getCurrentTab();
                mainView.getCardLayout().show(mainView.getMainPanel(),"Inventory");
                mainView.setFeedButtons(gameModel.getPlayers()[currentPlayerInMenu].getFoodItems(),gameModel.getPlayers()[currentPlayerInMenu].getToys());
            }
        });


        mainView.addFeedPetTwoListeners(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainView.getCardLayout().show(mainView.getMainPanel(),"Inventory");
                mainView.setFeedButtons(gameModel.getPlayers()[currentPlayerInMenu].getFoodItems(),gameModel.getPlayers()[currentPlayerInMenu].getToys());
                currentPet = mainView.getCurrentTab();
            }
        });

        mainView.addFeedPetThreeListeners(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainView.getCardLayout().show(mainView.getMainPanel(),"Inventory");
                mainView.setFeedButtons(gameModel.getPlayers()[currentPlayerInMenu].getFoodItems(),gameModel.getPlayers()[currentPlayerInMenu].getToys());
                currentPet = mainView.getCurrentTab();
            }
        });
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////END OF FEEDING PETS//////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////PURCHASE ITEMS/////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Adds action listeners to purchase buttons to all toys in the store. These listeners will check if player can purchase (sufficient funds and inventory space).
     */


    public void purchaseItems(){

        mainView.addMagicalFlowerListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Player[] players= gameModel.getPlayers();
                String message = "Would you like to purchase this item: ";
                MagicalFlower flower = new MagicalFlower();
                    int result = JOptionPane.showConfirmDialog(mainView.getFrame(),message+flower.getName());
                    if (result == JOptionPane.YES_OPTION){ // if the input was yes then it checks whether you can purchase or not.
                        boolean alreadyOwn = false;
                        if (players[currentPlayerInMenu].getCurrentBalance() - flower.getPrice() > 0){ // checks if player has enough currency
                            if (players[currentPlayerInMenu].getToys().size() < 6){ //checks if player has enough inventory space
                                for (int i = 0; i<players[currentPlayerInMenu].getToys().size();i++){
                                    if (players[currentPlayerInMenu].getToys().get(i).getName().equals("Magical Flower")){ //check if item is already owned
                                        alreadyOwn = true;
                                        break;
                                    }
                                }
                                if (!alreadyOwn){ // if player does not already own item then it will be added to their inventory
                                    players[currentPlayerInMenu].addToy(flower);
                                    players[currentPlayerInMenu].setCurrentBalance(players[currentPlayerInMenu].getCurrentBalance() - flower.getPrice()); // decrease their money
                                    mainView.updatePlayerCurrencyLabel(Integer.toString(players[currentPlayerInMenu].getCurrentBalance()));
                                }else {
                                    JOptionPane.showMessageDialog(mainView.getFrame(),"Sorry! Cannot purchase! Item already owned.");
                                }
                            }else{
                                JOptionPane.showMessageDialog(mainView.getFrame(),"Sorry! Your TOY inventory is full!");
                            }
                        }else{
                            JOptionPane.showMessageDialog(mainView.getFrame(),"Insufficient funds!");
                        }



                    }
                }


        });

        mainView.addIcebergListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Player[] players= gameModel.getPlayers();
                String message = "Would you like to purchase this item: ";
                IceBerg iceberg = new IceBerg();
                int result = JOptionPane.showConfirmDialog(mainView.getFrame(),message+iceberg.getName());
                if (result == JOptionPane.YES_OPTION){
                    boolean alreadyOwn = false;
                    if (players[currentPlayerInMenu].getCurrentBalance() - iceberg.getPrice() > 0) {
                        if (players[currentPlayerInMenu].getToys().size() < 6) {
                            for (int i = 0; i < players[currentPlayerInMenu].getToys().size(); i++) {
                                if (players[currentPlayerInMenu].getToys().get(i).getName().equals("Iceberg")) {
                                    alreadyOwn = true;
                                    break;
                                }
                            }
                            if (!alreadyOwn) {
                                players[currentPlayerInMenu].addToy(iceberg);
                                players[currentPlayerInMenu].setCurrentBalance(players[currentPlayerInMenu].getCurrentBalance() - iceberg.getPrice());
                                mainView.updatePlayerCurrencyLabel(Integer.toString(players[currentPlayerInMenu].getCurrentBalance()));
                            } else {
                                JOptionPane.showMessageDialog(mainView.getFrame(), "Sorry! Cannot purchase! Item already owned.");
                            }
                        } else {
                            JOptionPane.showMessageDialog(mainView.getFrame(), "Sorry! Your TOY inventory is full!");
                        }
                    }else{
                        JOptionPane.showMessageDialog(mainView.getFrame(),"Insufficient funds!");
                    }

                }
            }


        });



        mainView.addBallListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Player[] players= gameModel.getPlayers();
                String message = "Would you like to purchase this item: ";
                Ball ball = new Ball();
                int result = JOptionPane.showConfirmDialog(mainView.getFrame(),message+ball.getName());
                if (result == JOptionPane.YES_OPTION){
                    boolean alreadyOwn = false;
                    if (players[currentPlayerInMenu].getCurrentBalance() - ball.getPrice() > 0) {
                        if (players[currentPlayerInMenu].getToys().size() < 6) {
                            for (int i = 0; i < players[currentPlayerInMenu].getToys().size(); i++) {
                                if (players[currentPlayerInMenu].getToys().get(i).getName().equals("Ball")) {
                                    alreadyOwn = true;
                                    break;
                                }
                            }
                            if (!alreadyOwn) {
                                players[currentPlayerInMenu].addToy(ball);
                                players[currentPlayerInMenu].setCurrentBalance(players[currentPlayerInMenu].getCurrentBalance() - ball.getPrice());
                                mainView.updatePlayerCurrencyLabel(Integer.toString(players[currentPlayerInMenu].getCurrentBalance()));
                            } else {
                                JOptionPane.showMessageDialog(mainView.getFrame(), "Sorry! Cannot purchase! Item already owned.");
                            }
                        } else {
                            JOptionPane.showMessageDialog(mainView.getFrame(), "Sorry! Your TOY inventory is full!");
                        }
                    }else{
                        JOptionPane.showMessageDialog(mainView.getFrame(),"Insufficient funds!");
                    }

                }
            }
        });




        mainView.addSqueakyToyListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Player[] players= gameModel.getPlayers();
                String message = "Would you like to purchase this item: ";
                SqueakyToy squeakyToy = new SqueakyToy();
                int result = JOptionPane.showConfirmDialog(mainView.getFrame(),message+squeakyToy.getName());
                if (result == JOptionPane.YES_OPTION){
                    boolean alreadyOwn = false;
                    if (players[currentPlayerInMenu].getCurrentBalance() - squeakyToy.getPrice() > 0) {
                        if (players[currentPlayerInMenu].getToys().size() < 6) {
                            for (int i = 0; i < players[currentPlayerInMenu].getToys().size(); i++) {
                                if (players[currentPlayerInMenu].getToys().get(i).getName().equals("Squeaky Toy")) {
                                    alreadyOwn = true;
                                    break;
                                }
                            }
                            if (!alreadyOwn) {
                                players[currentPlayerInMenu].addToy(squeakyToy);
                                players[currentPlayerInMenu].setCurrentBalance(players[currentPlayerInMenu].getCurrentBalance() - squeakyToy.getPrice());
                                mainView.updatePlayerCurrencyLabel(Integer.toString(players[currentPlayerInMenu].getCurrentBalance()));
                            } else {
                                JOptionPane.showMessageDialog(mainView.getFrame(), "Sorry! Cannot purchase! Item already owned.");
                            }
                        } else {
                            JOptionPane.showMessageDialog(mainView.getFrame(), "Sorry! Your TOY inventory is full!");
                        }
                    }else{
                        JOptionPane.showMessageDialog(mainView.getFrame(),"Insufficient funds!");
                    }

                }
            }


        });





        mainView.addPrincessListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Player[] players= gameModel.getPlayers();
                String message = "Would you like to purchase this item: ";
                Princess princess = new Princess();
                int result = JOptionPane.showConfirmDialog(mainView.getFrame(),message+princess.getName());
                if (result == JOptionPane.YES_OPTION){
                    boolean alreadyOwn = false;
                    if (players[currentPlayerInMenu].getCurrentBalance() - princess.getPrice() > 0) {
                        if (players[currentPlayerInMenu].getToys().size() < 6) {
                            for (int i = 0; i < players[currentPlayerInMenu].getToys().size(); i++) {
                                if (players[currentPlayerInMenu].getToys().get(i).getName().equals("Princess")) {
                                    alreadyOwn = true;
                                    break;
                                }
                            }
                            if (!alreadyOwn) {
                                players[currentPlayerInMenu].addToy(princess);
                                players[currentPlayerInMenu].setCurrentBalance(players[currentPlayerInMenu].getCurrentBalance() - princess.getPrice());
                                mainView.updatePlayerCurrencyLabel(Integer.toString(players[currentPlayerInMenu].getCurrentBalance()));
                            } else {
                                JOptionPane.showMessageDialog(mainView.getFrame(), "Sorry! Cannot purchase! Item already owned.");
                            }
                        } else {
                            JOptionPane.showMessageDialog(mainView.getFrame(), "Sorry! Your TOY inventory is full!");
                        }
                    }else{
                        JOptionPane.showMessageDialog(mainView.getFrame(),"Insufficient funds!");
                    }

                }
            }


        });





        mainView.addPineConeListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Player[] players= gameModel.getPlayers();
                String message = "Would you like to purchase this item: ";
                PineCone pineCone = new PineCone();
                int result = JOptionPane.showConfirmDialog(mainView.getFrame(),message+pineCone.getName());
                if (result == JOptionPane.YES_OPTION){
                    boolean alreadyOwn = false;
                    if (players[currentPlayerInMenu].getCurrentBalance() - pineCone.getPrice() > 0) {
                        if (players[currentPlayerInMenu].getToys().size() < 6) {
                            for (int i = 0; i < players[currentPlayerInMenu].getFoodItems().size(); i++) {
                                if (players[currentPlayerInMenu].getToys().get(i).getName().equals("Pinecone")) {
                                    alreadyOwn = true;
                                    break;
                                }
                            }
                            if (!alreadyOwn) {
                                players[currentPlayerInMenu].addToy(pineCone);
                                players[currentPlayerInMenu].setCurrentBalance(players[currentPlayerInMenu].getCurrentBalance() - pineCone.getPrice());
                                mainView.updatePlayerCurrencyLabel(Integer.toString(players[currentPlayerInMenu].getCurrentBalance()));
                            } else {
                                JOptionPane.showMessageDialog(mainView.getFrame(), "Sorry! Cannot purchase! Item already owned.");
                            }
                        } else {
                            JOptionPane.showMessageDialog(mainView.getFrame(), "Sorry! Your TOY inventory is full!");
                        }
                    }else{
                        JOptionPane.showMessageDialog(mainView.getFrame(),"Insufficient funds!");
                    }

                }
            }
        });
    }

    /**
     * Adds actions listeners to all the purchase buttons of food items in the store. Checks is player has sufficient funds and or space. Then adds item to player inventory.
     */

    public void addPurchaseFoodListeners(){
        mainView.addWishListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Player[] players= gameModel.getPlayers();
                String message = "Would you like to purchase this item: ";
                Wish wish = new Wish();
                int result = JOptionPane.showConfirmDialog(mainView.getFrame(),message+wish.getName());
                if (result == JOptionPane.YES_OPTION){
                    boolean alreadyOwn = false;
                    if (players[currentPlayerInMenu].getCurrentBalance() - wish.getPrice() > 0) {
                        if (players[currentPlayerInMenu].getFoodItems().size() < 6) {
                            for (int i = 0; i < players[currentPlayerInMenu].getFoodItems().size(); i++) {
                                if (players[currentPlayerInMenu].getFoodItems().get(i).getName().equals("Wish")) {
                                    alreadyOwn = true;
                                    break;
                                }
                            }
                            if (!alreadyOwn) {
                                players[currentPlayerInMenu].addFood(wish);
                                players[currentPlayerInMenu].setCurrentBalance(players[currentPlayerInMenu].getCurrentBalance() - wish.getPrice());
                                mainView.updatePlayerCurrencyLabel(Integer.toString(players[currentPlayerInMenu].getCurrentBalance()));
                            } else {
                                JOptionPane.showMessageDialog(mainView.getFrame(), "Sorry! Cannot purchase! Item already owned.");
                            }
                        } else {
                            JOptionPane.showMessageDialog(mainView.getFrame(), "Sorry! Your FOOD inventory is full!");
                        }
                    }else{
                        JOptionPane.showMessageDialog(mainView.getFrame(),"Insufficient funds!");
                    }
                }
            }


        });

        mainView.addDogFoodListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Player[] players= gameModel.getPlayers();
                String message = "Would you like to purchase this item: ";
                DogFood dogFood = new DogFood();
                int result = JOptionPane.showConfirmDialog(mainView.getFrame(),message+dogFood.getName());
                if (result == JOptionPane.YES_OPTION){
                    boolean alreadyOwn = false;
                    if (players[currentPlayerInMenu].getCurrentBalance() - dogFood.getPrice() > 0) {
                        if (players[currentPlayerInMenu].getFoodItems().size() < 6) {
                            for (int i = 0; i < players[currentPlayerInMenu].getFoodItems().size(); i++) {
                                if (players[currentPlayerInMenu].getFoodItems().get(i).getName().equals("Dog Food")) {
                                    alreadyOwn = true;
                                    break;
                                }
                            }
                            if (!alreadyOwn) {
                                players[currentPlayerInMenu].addFood(dogFood);
                                players[currentPlayerInMenu].setCurrentBalance(players[currentPlayerInMenu].getCurrentBalance() - dogFood.getPrice());
                                mainView.updatePlayerCurrencyLabel(Integer.toString(players[currentPlayerInMenu].getCurrentBalance()));
                            } else {
                                JOptionPane.showMessageDialog(mainView.getFrame(), "Sorry! Cannot purchase! Item already owned.");
                            }
                        } else {
                            JOptionPane.showMessageDialog(mainView.getFrame(), "Sorry! Your FOOD inventory is full!");
                        }
                    }else{
                        JOptionPane.showMessageDialog(mainView.getFrame(),"Insufficient funds!");
                    }
                }
            }


        });

        mainView.addIceFishListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Player[] players = gameModel.getPlayers();
                String message = "Would you like to purchase this item: ";
                IcyFish icyFish = new IcyFish();
                int result = JOptionPane.showConfirmDialog(mainView.getFrame(),message+icyFish.getName());
                if (result == JOptionPane.YES_OPTION){
                    boolean alreadyOwn = false;
                    if (players[currentPlayerInMenu].getCurrentBalance() - icyFish.getPrice() > 0) {
                        if (players[currentPlayerInMenu].getFoodItems().size() < 6) {
                            for (int i = 0; i < players[currentPlayerInMenu].getFoodItems().size(); i++) {
                                if (players[currentPlayerInMenu].getFoodItems().get(i).getName().equals("Icy Fish")) {
                                    alreadyOwn = true;
                                    break;
                                }
                            }
                            if (!alreadyOwn) {
                                players[currentPlayerInMenu].addFood(icyFish);
                                players[currentPlayerInMenu].setCurrentBalance(players[currentPlayerInMenu].getCurrentBalance() - icyFish.getPrice());
                                mainView.updatePlayerCurrencyLabel(Integer.toString(players[currentPlayerInMenu].getCurrentBalance()));
                            } else {
                                JOptionPane.showMessageDialog(mainView.getFrame(), "Sorry! Cannot purchase! Item already owned.");
                            }
                        } else {
                            JOptionPane.showMessageDialog(mainView.getFrame(), "Sorry! Your FOOD inventory is full!");
                        }
                    }else{
                        JOptionPane.showMessageDialog(mainView.getFrame(),"Insufficient funds!");
                    }
                }
            }


        });
        mainView.addAppleListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Player[] players = gameModel.getPlayers();
                String message = "Would you like to purchase this item: ";
                Apple apple = new Apple();
                int result = JOptionPane.showConfirmDialog(mainView.getFrame(),message+apple.getName());
                if (result == JOptionPane.YES_OPTION){
                    boolean alreadyOwn = false;
                    if (players[currentPlayerInMenu].getCurrentBalance() - apple.getPrice() > 0) {
                        if (players[currentPlayerInMenu].getFoodItems().size() < 6) {
                            for (int i = 0; i < players[currentPlayerInMenu].getFoodItems().size(); i++) {
                                if (players[currentPlayerInMenu].getFoodItems().get(i).getName().equals("Apple")) {
                                    alreadyOwn = true;
                                    break;
                                }
                            }
                            if (!alreadyOwn) {
                                players[currentPlayerInMenu].addFood(apple);
                                players[currentPlayerInMenu].setCurrentBalance(players[currentPlayerInMenu].getCurrentBalance() - apple.getPrice());
                                mainView.updatePlayerCurrencyLabel(Integer.toString(players[currentPlayerInMenu].getCurrentBalance()));
                            } else {
                                JOptionPane.showMessageDialog(mainView.getFrame(), "Sorry! Cannot purchase! Item already owned.");
                            }
                        } else {
                            JOptionPane.showMessageDialog(mainView.getFrame(), "Sorry! Your FOOD inventory is full!");
                        }
                    }else{
                        JOptionPane.showMessageDialog(mainView.getFrame(),"Insufficient funds!");
                    }
                }
            }


        });

        mainView.addHoneyListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Player[] players = gameModel.getPlayers();
                String message = "Would you like to purchase this item: ";
                Honey honey = new Honey();
                int result = JOptionPane.showConfirmDialog(mainView.getFrame(),message+honey.getName());
                if (result == JOptionPane.YES_OPTION){
                    boolean alreadyOwn = false;
                    if (players[currentPlayerInMenu].getCurrentBalance() - honey.getPrice() > 0) {
                        if (players[currentPlayerInMenu].getFoodItems().size() < 6) {
                            for (int i = 0; i < players[currentPlayerInMenu].getFoodItems().size(); i++) {
                                if (players[currentPlayerInMenu].getFoodItems().get(i).getName().equals("Honey")) {
                                    alreadyOwn = true;
                                    break;
                                }
                            }
                            if (!alreadyOwn) {
                                players[currentPlayerInMenu].addFood(honey);
                                players[currentPlayerInMenu].setCurrentBalance(players[currentPlayerInMenu].getCurrentBalance() - honey.getPrice());
                                mainView.updatePlayerCurrencyLabel(Integer.toString(players[currentPlayerInMenu].getCurrentBalance()));
                            } else {
                                JOptionPane.showMessageDialog(mainView.getFrame(), "Sorry! Cannot purchase! Item already owned.");
                            }
                        } else {
                            JOptionPane.showMessageDialog(mainView.getFrame(), "Sorry! Your FOOD inventory is full!");
                        }
                    }else{
                        JOptionPane.showMessageDialog(mainView.getFrame(),"Insufficient funds!");
                    }
                }
            }
        });

        mainView.addCowListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Player[] players = gameModel.getPlayers();
                String message = "Would you like to purchase this item: ";
                Cow cow = new Cow();
                int result = JOptionPane.showConfirmDialog(mainView.getFrame(),message+cow.getName());
                if (result == JOptionPane.YES_OPTION){
                    boolean alreadyOwn = false;
                    if (players[currentPlayerInMenu].getCurrentBalance() - cow.getPrice() > 0) {
                        if (players[currentPlayerInMenu].getFoodItems().size() < 6) {
                            for (int i = 0; i < players[currentPlayerInMenu].getFoodItems().size(); i++) {
                                if (players[currentPlayerInMenu].getFoodItems().get(i).getName().equals("Cow")) {
                                    alreadyOwn = true;
                                    break;
                                }
                            }
                            if (!alreadyOwn) {
                                players[currentPlayerInMenu].addFood(cow);
                                players[currentPlayerInMenu].setCurrentBalance(players[currentPlayerInMenu].getCurrentBalance() - cow.getPrice());
                                mainView.updatePlayerCurrencyLabel(Integer.toString(players[currentPlayerInMenu].getCurrentBalance()));
                            } else {
                                JOptionPane.showMessageDialog(mainView.getFrame(), "Sorry! Cannot purchase! Item already owned.");
                            }
                        } else {
                            JOptionPane.showMessageDialog(mainView.getFrame(), "Sorry! Your FOOD inventory is full!");
                        }
                    }else{
                        JOptionPane.showMessageDialog(mainView.getFrame(),"Insufficient funds!");
                    }
                }
            }
        });
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////END OF PURCHASE ITEMS////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Checks a pet has any more turns left.
     */

    public void checkPetHasMoreTurns(){
        if (!gameModel.petHasMoreTurns(gameModel.getPlayers()[currentPlayerInMenu].getPets()[currentPet])){// if the pet has no more turns then it should disable all the action buttons
            if (currentPet == 0){
                mainView.hidePetOneActionButtons();
            }else if(currentPet == 1){
                mainView.hidePetTwoActionButtons();
            }else{
                mainView.hidePetThreeActionButtons();
            }
            mainView.getCardLayout().show(mainView.getMainPanel(),"Menu");
            JOptionPane.showMessageDialog(mainView.getFrame(),"No more actions left!");
        }
    }

    /**
     * Adds all action listeners to the eat buttons of items in the inventory. Upon user interaction the game model will feed the current pet the selected food item.
     */
    public void addEatActionListeners(){

        mainView.addWishEatListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Player[] players = gameModel.getPlayers();
                gameModel.feed(players[currentPlayerInMenu],players[currentPlayerInMenu].getPets()[currentPet],new Wish()); //calls the feed method in the game class
                showPetStats(); // update the stats of the pet on the GUI

                mainView.getCardLayout().show(mainView.getMainPanel(),"Inventory"); // keep screen in the inventory
                mainView.setFeedButtons(gameModel.getPlayers()[currentPlayerInMenu].getFoodItems(),gameModel.getPlayers()[currentPlayerInMenu].getToys()); // disables the eat button
                JOptionPane.showMessageDialog(mainView.getFrame(),"Pet has eaten a Wish!"); //prompt user that pet has eaten the item
                gameModel.getPlayers()[currentPlayerInMenu].getPets()[currentPet].decrementActionCount(); // decrement the number of actions the pet has left by 1
                mainView.setPetActionCountLabel(currentPet, gameModel.getPlayers()[currentPlayerInMenu].getPets()[currentPet]);// sets the action count label for the current pet
                checkPetHasMoreTurns();
            }
        });

        mainView.addAppleEatListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Player[] players = gameModel.getPlayers();
                gameModel.feed(players[currentPlayerInMenu],players[currentPlayerInMenu].getPets()[currentPet],new Apple());
                showPetStats();
                mainView.getCardLayout().show(mainView.getMainPanel(),"Inventory");
                mainView.setFeedButtons(gameModel.getPlayers()[currentPlayerInMenu].getFoodItems(),gameModel.getPlayers()[currentPlayerInMenu].getToys());
                JOptionPane.showMessageDialog(mainView.getFrame(),"Pet has eaten an Apple!");
                gameModel.getPlayers()[currentPlayerInMenu].getPets()[currentPet].decrementActionCount();//
                mainView.setPetActionCountLabel(currentPet, gameModel.getPlayers()[currentPlayerInMenu].getPets()[currentPet]);//
                checkPetHasMoreTurns();
            }
        });

        mainView.addCowEatListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Player[] players = gameModel.getPlayers();
                gameModel.feed(players[currentPlayerInMenu],players[currentPlayerInMenu].getPets()[currentPet],new Cow());
                showPetStats();
                mainView.getCardLayout().show(mainView.getMainPanel(),"Inventory");
                mainView.setFeedButtons(gameModel.getPlayers()[currentPlayerInMenu].getFoodItems(),gameModel.getPlayers()[currentPlayerInMenu].getToys());
                JOptionPane.showMessageDialog(mainView.getFrame(),"Pet has eaten a Cow!");
                gameModel.getPlayers()[currentPlayerInMenu].getPets()[currentPet].decrementActionCount();//
                mainView.setPetActionCountLabel(currentPet, gameModel.getPlayers()[currentPlayerInMenu].getPets()[currentPet]);//
                checkPetHasMoreTurns();
            }
        });

        mainView.addDogFoodEatListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Player[] players = gameModel.getPlayers();
                gameModel.feed(players[currentPlayerInMenu],players[currentPlayerInMenu].getPets()[currentPet],new DogFood());
                showPetStats();
                mainView.getCardLayout().show(mainView.getMainPanel(),"Inventory");
                mainView.setFeedButtons(gameModel.getPlayers()[currentPlayerInMenu].getFoodItems(),gameModel.getPlayers()[currentPlayerInMenu].getToys());
                JOptionPane.showMessageDialog(mainView.getFrame(),"Pet has eaten Dog Food!");
                gameModel.getPlayers()[currentPlayerInMenu].getPets()[currentPet].decrementActionCount();//
                mainView.setPetActionCountLabel(currentPet, gameModel.getPlayers()[currentPlayerInMenu].getPets()[currentPet]);//
                checkPetHasMoreTurns();
            }
        });


        mainView.addHoneyEatListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Player[] players = gameModel.getPlayers();
                gameModel.feed(players[currentPlayerInMenu],players[currentPlayerInMenu].getPets()[currentPet],new Honey());
                showPetStats();
                mainView.getCardLayout().show(mainView.getMainPanel(),"Inventory");
                mainView.setFeedButtons(gameModel.getPlayers()[currentPlayerInMenu].getFoodItems(),gameModel.getPlayers()[currentPlayerInMenu].getToys());
                JOptionPane.showMessageDialog(mainView.getFrame(),"Pet has eaten Honey!");
                gameModel.getPlayers()[currentPlayerInMenu].getPets()[currentPet].decrementActionCount();//
                mainView.setPetActionCountLabel(currentPet, gameModel.getPlayers()[currentPlayerInMenu].getPets()[currentPet]);//
                checkPetHasMoreTurns();
            }
        });

        mainView.addIcyFishEatListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Player[] players = gameModel.getPlayers();
                gameModel.feed(players[currentPlayerInMenu],players[currentPlayerInMenu].getPets()[currentPet],new IcyFish());
                showPetStats();
                mainView.getCardLayout().show(mainView.getMainPanel(),"Inventory");
                mainView.setFeedButtons(gameModel.getPlayers()[currentPlayerInMenu].getFoodItems(),gameModel.getPlayers()[currentPlayerInMenu].getToys());
                JOptionPane.showMessageDialog(mainView.getFrame(),"Pet has eaten an Icy Fish!");
                gameModel.getPlayers()[currentPlayerInMenu].getPets()[currentPet].decrementActionCount();//
                mainView.setPetActionCountLabel(currentPet, gameModel.getPlayers()[currentPlayerInMenu].getPets()[currentPet]);//
                checkPetHasMoreTurns();
            }
        });


    }

    /**
     * Adds the play button listeners to all the playable items in the inventory. So if interacted with, it will use the selected item to play with the pet.
     */

    public void addPlayListeners(){

        mainView.addPineConePlayListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Player[] players = gameModel.getPlayers();
                Toy toy = null;
                for (Toy t : players[currentPlayerInMenu].getToys()) {
                    if (t.getName() == "Pinecone") {
                        toy = t;
                    }
                }
                JOptionPane.showMessageDialog(mainView.getFrame(),"Pet has played with a Pinecone!");
                int i = gameModel.play(players[currentPlayerInMenu],players[currentPlayerInMenu].getPets()[currentPet],toy);
                if (i == 0){
                    JOptionPane.showMessageDialog(mainView.getFrame(),"Toy has broken!");
                }
                showPetStats();
                mainView.getCardLayout().show(mainView.getMainPanel(),"Inventory");
                mainView.setFeedButtons(gameModel.getPlayers()[currentPlayerInMenu].getFoodItems(),gameModel.getPlayers()[currentPlayerInMenu].getToys());
                gameModel.getPlayers()[currentPlayerInMenu].getPets()[currentPet].decrementActionCount();//
                mainView.setPetActionCountLabel(currentPet, gameModel.getPlayers()[currentPlayerInMenu].getPets()[currentPet]);//
                checkPetHasMoreTurns();
            }
        });

        mainView.addMagicalFlowerPlayListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Player[] players = gameModel.getPlayers();
                Toy toy = null;
                for (Toy t : players[currentPlayerInMenu].getToys()) {
                    if (t.getName() == "Magical Flower") {
                        toy = t;
                    }
                }
                JOptionPane.showMessageDialog(mainView.getFrame(),"Pet has played with a Magical Flower!");
                int i = gameModel.play(players[currentPlayerInMenu],players[currentPlayerInMenu].getPets()[currentPet],toy);
                if (i == 0){
                    JOptionPane.showMessageDialog(mainView.getFrame(),"Toy has broken!");
                }
                showPetStats();
                mainView.getCardLayout().show(mainView.getMainPanel(),"Inventory");
                mainView.setFeedButtons(gameModel.getPlayers()[currentPlayerInMenu].getFoodItems(),gameModel.getPlayers()[currentPlayerInMenu].getToys());
                gameModel.getPlayers()[currentPlayerInMenu].getPets()[currentPet].decrementActionCount();//
                mainView.setPetActionCountLabel(currentPet, gameModel.getPlayers()[currentPlayerInMenu].getPets()[currentPet]);//
                checkPetHasMoreTurns();
            }
        });

        mainView.addPrincessPlayListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Player[] players = gameModel.getPlayers();
                Toy toy = null;
                for (Toy t : players[currentPlayerInMenu].getToys()) {
                    if (t.getName() == "Princess") {
                        toy = t;
                    }
                }
                JOptionPane.showMessageDialog(mainView.getFrame(),"Pet has played with a Princess!");
                int i = gameModel.play(players[currentPlayerInMenu],players[currentPlayerInMenu].getPets()[currentPet],toy);
                if (i == 0){
                    JOptionPane.showMessageDialog(mainView.getFrame(),"Toy has broken!");
                }
                showPetStats();
                mainView.getCardLayout().show(mainView.getMainPanel(),"Inventory");
                mainView.setFeedButtons(gameModel.getPlayers()[currentPlayerInMenu].getFoodItems(),gameModel.getPlayers()[currentPlayerInMenu].getToys());
                gameModel.getPlayers()[currentPlayerInMenu].getPets()[currentPet].decrementActionCount();//
                mainView.setPetActionCountLabel(currentPet, gameModel.getPlayers()[currentPlayerInMenu].getPets()[currentPet]);//
                checkPetHasMoreTurns();
            }
        });

        mainView.addSqueakyToyPlayListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Player[] players = gameModel.getPlayers();
                Toy toy = null;
                for (Toy t : players[currentPlayerInMenu].getToys()) {
                    if (t.getName() == "Squeaky Toy") {
                        toy = t;
                    }
                }
                JOptionPane.showMessageDialog(mainView.getFrame(),"Pet has played with a Squeaky Toy!");
                int i = gameModel.play(players[currentPlayerInMenu],players[currentPlayerInMenu].getPets()[currentPet],toy);
                if (i == 0){
                    JOptionPane.showMessageDialog(mainView.getFrame(),"Toy has broken!");
                }
                showPetStats();
                mainView.getCardLayout().show(mainView.getMainPanel(),"Inventory");
                mainView.setFeedButtons(gameModel.getPlayers()[currentPlayerInMenu].getFoodItems(),gameModel.getPlayers()[currentPlayerInMenu].getToys());
                gameModel.getPlayers()[currentPlayerInMenu].getPets()[currentPet].decrementActionCount();//
                mainView.setPetActionCountLabel(currentPet, gameModel.getPlayers()[currentPlayerInMenu].getPets()[currentPet]);//
                checkPetHasMoreTurns();
            }
        });

        mainView.addBallPlayListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Player[] players = gameModel.getPlayers();
                Toy toy = null;
                for (Toy t : players[currentPlayerInMenu].getToys()) {
                    if (t.getName() == "Ball") {
                        toy = t;
                    }
                }
                JOptionPane.showMessageDialog(mainView.getFrame(),"Pet has played with a Ball!");
                int i = gameModel.play(players[currentPlayerInMenu],players[currentPlayerInMenu].getPets()[currentPet],toy);
                if (i == 0){
                    JOptionPane.showMessageDialog(mainView.getFrame(),"Toy has broken!");
                }
                showPetStats();
                mainView.getCardLayout().show(mainView.getMainPanel(),"Inventory");
                mainView.setFeedButtons(gameModel.getPlayers()[currentPlayerInMenu].getFoodItems(),gameModel.getPlayers()[currentPlayerInMenu].getToys());
                gameModel.getPlayers()[currentPlayerInMenu].getPets()[currentPet].decrementActionCount();//
                mainView.setPetActionCountLabel(currentPet, gameModel.getPlayers()[currentPlayerInMenu].getPets()[currentPet]);//
                checkPetHasMoreTurns();
            }

        });

        mainView.addIceBergPlayListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Player[] players = gameModel.getPlayers();
                Toy toy = null;
                for (Toy t : players[currentPlayerInMenu].getToys()) {
                    if (t.getName() == "Iceberg") {
                        toy = t;
                    }
                }
                JOptionPane.showMessageDialog(mainView.getFrame(),"Pet has played with a Iceberg!");
                int i = gameModel.play(players[currentPlayerInMenu],players[currentPlayerInMenu].getPets()[currentPet],toy);
                if (i == 0){
                    JOptionPane.showMessageDialog(mainView.getFrame(),"Toy has broken!");
                }
                showPetStats();
                mainView.getCardLayout().show(mainView.getMainPanel(),"Inventory");
                mainView.setFeedButtons(gameModel.getPlayers()[currentPlayerInMenu].getFoodItems(),gameModel.getPlayers()[currentPlayerInMenu].getToys());
                gameModel.getPlayers()[currentPlayerInMenu].getPets()[currentPet].decrementActionCount();//
                mainView.setPetActionCountLabel(currentPet, gameModel.getPlayers()[currentPlayerInMenu].getPets()[currentPet]);//
                checkPetHasMoreTurns();
            }
        });
    }

    /**
     * Adds the sleep button listeners for each pet. Upon user interaction with these buttons they will put the current pet to sleep and update the pets stats.
     */

    public void addSleepListeners(){
        mainView.addSleepPetOneListeners(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                gameModel.sleep(gameModel.getPlayers()[currentPlayerInMenu].getPets()[0]); // pet sleeps through the game class
                JOptionPane.showMessageDialog(mainView.getFrame(),"Pet has slept!"); // prompt user that pet has slept
                showPetStats();
                currentPet = mainView.getCurrentTab();
                gameModel.getPlayers()[currentPlayerInMenu].getPets()[0].decrementActionCount();// decrements the number of actions left for the pet
                mainView.setPetActionCountLabel(currentPet, gameModel.getPlayers()[currentPlayerInMenu].getPets()[0]);//
                if (!gameModel.petHasMoreTurns(gameModel.getPlayers()[currentPlayerInMenu].getPets()[0])){//checks if pet one has anymore actions left
                    mainView.hidePetOneActionButtons();
                    JOptionPane.showMessageDialog(mainView.getFrame(),"No more actions left!");
            }}
        });

        mainView.addSleepPetTwoListeners(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                gameModel.sleep(gameModel.getPlayers()[currentPlayerInMenu].getPets()[1]);
                JOptionPane.showMessageDialog(mainView.getFrame(),"Pet has slept!");
                showPetStats();
                currentPet = mainView.getCurrentTab();
                gameModel.getPlayers()[currentPlayerInMenu].getPets()[1].decrementActionCount();//
                mainView.setPetActionCountLabel(1, gameModel.getPlayers()[currentPlayerInMenu].getPets()[1]);//
                if (!gameModel.petHasMoreTurns(gameModel.getPlayers()[currentPlayerInMenu].getPets()[1])){//
                    mainView.hidePetTwoActionButtons();
                    JOptionPane.showMessageDialog(mainView.getFrame(),"No more actions left!");
                }
            }
        });
        mainView.addSleepPetThreeListeners(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                gameModel.sleep(gameModel.getPlayers()[currentPlayerInMenu].getPets()[2]);
                JOptionPane.showMessageDialog(mainView.getFrame(),"Pet has slept!");
                showPetStats();
                currentPet = mainView.getCurrentTab();
                gameModel.getPlayers()[currentPlayerInMenu].getPets()[2].decrementActionCount();//
                mainView.setPetActionCountLabel(2, gameModel.getPlayers()[currentPlayerInMenu].getPets()[2]);//
                if (!gameModel.petHasMoreTurns(gameModel.getPlayers()[currentPlayerInMenu].getPets()[2])){//
                    mainView.hidePetThreeActionButtons();
                    JOptionPane.showMessageDialog(mainView.getFrame(),"No more actions left!");
                }
            }
        });
    }

    /**
     * Adds the use bathroom button listeners. Upon user interaction the view and model will respond by updating the pet stats
     */

    public void addBathroomListeners(){
        mainView.addVisitBathroomPetOneListeners(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                gameModel.takeToBathroom(gameModel.getPlayers()[currentPlayerInMenu].getPets()[0]); // pet goes to the bathroom
                JOptionPane.showMessageDialog(mainView.getFrame(),"Pet has been relieved!");
                showPetStats();

                currentPet = mainView.getCurrentTab(); // set the current set in menu selection, by checking which tab the player in on

                gameModel.getPlayers()[currentPlayerInMenu].getPets()[0].decrementActionCount();//
                mainView.setPetActionCountLabel(0, gameModel.getPlayers()[currentPlayerInMenu].getPets()[0]);//
                if (!gameModel.petHasMoreTurns(gameModel.getPlayers()[currentPlayerInMenu].getPets()[0])){// checks if the pet has any more actions left, if not, will disable all of pet ones action buttons
                    mainView.hidePetOneActionButtons();
                    JOptionPane.showMessageDialog(mainView.getFrame(),"No more actions left!");
                }
            }
        });
        mainView.addVisitBathroomPetTwoListeners(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                gameModel.takeToBathroom(gameModel.getPlayers()[currentPlayerInMenu].getPets()[1]);
                JOptionPane.showMessageDialog(mainView.getFrame(),"Pet has been relieved!");
                showPetStats();

                currentPet = mainView.getCurrentTab();

                gameModel.getPlayers()[currentPlayerInMenu].getPets()[1].decrementActionCount();//
                mainView.setPetActionCountLabel(1, gameModel.getPlayers()[currentPlayerInMenu].getPets()[1]);//
                if (!gameModel.petHasMoreTurns(gameModel.getPlayers()[currentPlayerInMenu].getPets()[1])){//
                    mainView.hidePetTwoActionButtons();
                    JOptionPane.showMessageDialog(mainView.getFrame(),"No more actions left!");
                }
            }
        });
        mainView.addVisitBathroomPetThreeListeners(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                gameModel.takeToBathroom(gameModel.getPlayers()[currentPlayerInMenu].getPets()[2]);
                JOptionPane.showMessageDialog(mainView.getFrame(),"Pet has been relieved!");
                showPetStats();

                currentPet = mainView.getCurrentTab();

                gameModel.getPlayers()[currentPlayerInMenu].getPets()[2].decrementActionCount();//
                mainView.setPetActionCountLabel(2, gameModel.getPlayers()[currentPlayerInMenu].getPets()[2]);//
                if (!gameModel.petHasMoreTurns(gameModel.getPlayers()[currentPlayerInMenu].getPets()[2])){//
                    mainView.hidePetThreeActionButtons();
                    JOptionPane.showMessageDialog(mainView.getFrame(),"No more actions left!");
                }
            }
        });
    }


    /**
     * Shows and updates the GUI's player title.
     */

    public void showPlayerTitle(){
        mainView.changePlayerTitle(gameModel.getPlayers()[currentPlayerInMenu].getName());
    }

    /**
     *
     *Shows all pet stats to the GUI, and calls the view to update the ImageIcons. Also disables tabs through the view if there are less than three pets.
     * @param x Takes interger x which is the current player on the menu screen.
     */

    public void showPlayerAndPetsStatsMenu(int x){
        Player[] players = gameModel.getPlayers();
        showPetStats();
        showPlayerTitle();
        int k = 0;
        int numberPets = 0;
        while (k < 3 && players[x].getPets()[k] != null){
            numberPets++;
            k++;
        }
        mainView.setTabbedPanePetSelections(numberPets);

        for (int i = 0; i<players[x].getPets().length;i++){
            if (!(players[x].getPets()[i] == null)){
                if (players[x].getPets()[i].getSpecies().equals("Penguin")){
                    mainView.addPetIcons(mainView.getPenguinImage(),i,players[x].getPets()[i].getName());
                }else if (players[x].getPets()[i].getSpecies().equals("Dog")){
                    mainView.addPetIcons(mainView.getDogImage(),i,players[x].getPets()[i].getName());
                }else if (players[x].getPets()[i].getSpecies().equals("Foxy Fox")){
                    mainView.addPetIcons(mainView.getFoxyFoxImage(),i,players[x].getPets()[i].getName());
                }else if (players[x].getPets()[i].getSpecies().equals("Magical Butterfly")){
                    mainView.addPetIcons(mainView.getButterflyImage(),i,players[x].getPets()[i].getName());
                }else if (players[x].getPets()[i].getSpecies().equals("Dragon")){
                    mainView.addPetIcons(mainView.getDragonImage(),i,players[x].getPets()[i].getName());
                }else{
                    mainView.addPetIcons(mainView.getRedPandaImage(),i,players[x].getPets()[i].getName());
                }
            }
        }
    }

    /**
     * Updates and shows all pet stats on the GUI.
     */

    public void showPetStats(){
        Pet[] pets = gameModel.getPlayers()[currentPlayerInMenu].getPets();
        for (int i = 0; i<pets.length;i++){
            if (pets[i] != null){ // pass to view to update the stats
                mainView.showPetStats(pets[i].getHealthLevel(),pets[i].getEnergy(),pets[i].getHungerLevel(),pets[i].getMoodLevel(),pets[i].getBathroomLevel(),i);
            }else{
                break;
            }
        }
    }


    /**
     * Adds revive button listeners. Upon user interaction the current selected pet will be revived.
     */

    public void revivePetBtnListeners(){
        mainView.addRevivePetOneListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (gameModel.getPlayers()[currentPlayerInMenu].getPets()[0].getRevivalsLeft() == 1){ // checks if the current pet has anymore revivals left
                    gameModel.getPlayers()[currentPlayerInMenu].getPets()[0].beRevived();
                    showPetStats();
                    gameModel.getPlayers()[currentPlayerInMenu].getPets()[0].setState("Alive");
                    gameModel.getPlayers()[currentPlayerInMenu].getPets()[0].setRevivalsLeft(0);
                    gameModel.getPlayers()[currentPlayerInMenu].getPets()[0].setActionCount(2);
                    mainView.showPetOneActionButtons();
                    mainView.disableRevivePetOne();
                    mainView.setStatePetLabel(gameModel.getPlayers()[currentPlayerInMenu].getPets()[0],0);
                }else{
                    JOptionPane.showMessageDialog(mainView.getFrame(),"No more revivals left on this pet!");
                    mainView.disableRevivePetOne();
                }

            }
        });

        mainView.addRevivePetTwoListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (gameModel.getPlayers()[currentPlayerInMenu].getPets()[1].getRevivalsLeft() == 1){
                    gameModel.getPlayers()[currentPlayerInMenu].getPets()[1].beRevived();
                    showPetStats();
                    gameModel.getPlayers()[currentPlayerInMenu].getPets()[1].setState("Alive");
                    gameModel.getPlayers()[currentPlayerInMenu].getPets()[1].setRevivalsLeft(0);
                    gameModel.getPlayers()[currentPlayerInMenu].getPets()[1].setActionCount(2);
                    mainView.showPetTwoActionButtons();
                    mainView.disableRevivePetTwo();
                    mainView.setStatePetLabel(gameModel.getPlayers()[currentPlayerInMenu].getPets()[1],1);
                }else{
                    JOptionPane.showMessageDialog(mainView.getFrame(),"No more revivals left on this pet!");
                    mainView.disableRevivePetTwo();
                }

            }
        });

        mainView.addRevivePetThreeListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (gameModel.getPlayers()[currentPlayerInMenu].getPets()[2].getRevivalsLeft() == 1){
                    gameModel.getPlayers()[currentPlayerInMenu].getPets()[2].beRevived();
                    showPetStats();
                    gameModel.getPlayers()[currentPlayerInMenu].getPets()[2].setState("Alive");
                    gameModel.getPlayers()[currentPlayerInMenu].getPets()[2].setRevivalsLeft(0);
                    gameModel.getPlayers()[currentPlayerInMenu].getPets()[2].setActionCount(2);
                    mainView.showPetThreeActionButtons();
                    mainView.disableRevivePetThree();
                    mainView.setStatePetLabel(gameModel.getPlayers()[currentPlayerInMenu].getPets()[2],2);
                }else{
                    JOptionPane.showMessageDialog(mainView.getFrame(),"No more revivals left on this pet!");
                    mainView.disableRevivePetThree();
                }

            }
        });
    }


    /**
     * Checks pets death and state. If dead, all actions except for revive are disabled. If any other state enable buttons through the view accordingly.
     */



    public void checkDeath(){
        Player[] players = gameModel.getPlayers();
        for (int i = 0;i<players[currentPlayerInMenu].getPets().length;i++){
            if (players[currentPlayerInMenu].getPets()[i] != null){
                mainView.setStatePetLabel(players[currentPlayerInMenu].getPets()[i],i); // set each pets state labels
            }
        }
        for (int j = 0;j<players[currentPlayerInMenu].getPets().length;j++){
            if (players[currentPlayerInMenu].getPets()[j] != null){ //checks pets state, if sick or misbehaving then enable deal with pet buttons
                if (players[currentPlayerInMenu].getPets()[j].getState().equals("Sick") || players[currentPlayerInMenu].getPets()[j].getState().equals("Misbehaving")){
                    mainView.enableDealWithPetsBtns(j);
                }else{
                    mainView.disableDealWithPetsBtns(j);
                }
            }
        }

        for (int k = 0; k<players[currentPlayerInMenu].getPets().length;k++){
            if (players[currentPlayerInMenu].getPets()[k] != null && players[currentPlayerInMenu].getPets()[k].getState().equals("Dead")){ // if pet is dead then disable all the buttons
                //////////////////insert death states here also/////////////////////////////////

                if (k == 0){
                    mainView.hidePetOneActionButtons();
                    mainView.enableRevivePetOne();
                }else if (k == 1){
                    mainView.hidePetTwoActionButtons();
                    mainView.enableRevivePetTwo();
                }else if (k == 2){
                    mainView.hidePetThreeActionButtons();
                    mainView.enableRevivePetThree();
                }

            }
        }
    }


    /**
     * Adds action listeners to manage the pet when it's misbehaving or sick. Upon user interaction, will prompt for users choice to treat/disicpline pet.
     */

    public void addDealWithPetListeners(){
        mainView.addDealWithPetOneActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Player[] players = gameModel.getPlayers();
                if (players[currentPlayerInMenu].getPets()[0].getState().equals("Sick")){ // if pet is sick then prompt user for treatment
                    int j = JOptionPane.showConfirmDialog(mainView.getFrame(),"Treatment will cost 10 GP. Would you still like to treat this pet?");
                    if (j == JOptionPane.YES_OPTION){ // if yes
                        if (gameModel.getPlayers()[currentPlayerInMenu].getCurrentBalance() - 10 >  0){ // check if the current player has enough money
                            gameModel.getPlayers()[currentPlayerInMenu].setCurrentBalance(gameModel.getPlayers()[currentPlayerInMenu].getCurrentBalance() - 10); // decrease player curreny
                            JOptionPane.showMessageDialog(mainView.getFrame(),"Cured!");
                            gameModel.getPlayers()[currentPlayerInMenu].getPets()[0].beCured(); // cures pet and updates the stats
                            gameModel.getPlayers()[currentPlayerInMenu].getPets()[0].setState("Alive"); // sets the pet state to alive
                            mainView.setStatePetLabel(gameModel.getPlayers()[currentPlayerInMenu].getPets()[0],0); // set pets state label in GUI
                            showPetStats(); // updates the GUI stats
                            mainView.disableDealWithPetsBtns(0); // disable the button
                        }else{
                            JOptionPane.showMessageDialog(mainView.getFrame(),"Insuffcient funds!");
                        }

                    }
                }else{
                    int j = JOptionPane.showConfirmDialog(mainView.getFrame(),"Would you like to discipline this pet?");
                    if (j == JOptionPane.YES_OPTION){
                        gameModel.getPlayers()[currentPlayerInMenu].getPets()[0].beDisciplined(); // discipline the pet
                        gameModel.getPlayers()[currentPlayerInMenu].getPets()[0].setState("Alive");
                        showPetStats();
                        JOptionPane.showMessageDialog(mainView.getFrame(),"Disciplined!");
                        mainView.setStatePetLabel(gameModel.getPlayers()[currentPlayerInMenu].getPets()[0],0);
                        mainView.disableDealWithPetsBtns(0);
                    }
                }
                currentPet = mainView.getCurrentTab();///////adsdasdads
                showPlayerAndPetsStatsMenu(currentPlayerInMenu);
                showPetStats();
              /*  mainView.showPetOneActionButtons();
                mainView.showPetTwoActionButtons();
                mainView.showPetThreeActionButtons();
                mainView.addInventoryImages(players[currentPlayerInMenu].getFoodItems(),players[currentPlayerInMenu].getToys());*/

            }
        });
        mainView.addDealWithPetTwoActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Player[] players = gameModel.getPlayers();
                if (players[currentPlayerInMenu].getPets()[1].getState().equals("Sick")){
                    int j = JOptionPane.showConfirmDialog(mainView.getFrame(),"Treatment will cost 10 GP. Would you still like to treat this pet?");
                    if (j == JOptionPane.YES_OPTION){
                        if (gameModel.getPlayers()[currentPlayerInMenu].getCurrentBalance() - 10 >  0){
                            gameModel.getPlayers()[currentPlayerInMenu].setCurrentBalance(gameModel.getPlayers()[currentPlayerInMenu].getCurrentBalance() - 10);
                            JOptionPane.showMessageDialog(mainView.getFrame(),"Cured!");
                            gameModel.getPlayers()[currentPlayerInMenu].getPets()[1].beCured();
                            gameModel.getPlayers()[currentPlayerInMenu].getPets()[1].setState("Alive");
                            mainView.setStatePetLabel(gameModel.getPlayers()[currentPlayerInMenu].getPets()[1],1);
                            showPetStats();
                            mainView.disableDealWithPetsBtns(1);
                        }else{
                            JOptionPane.showMessageDialog(mainView.getFrame(),"Insuffcient funds!");
                        }

                    }
                }else{
                    int j = JOptionPane.showConfirmDialog(mainView.getFrame(),"Would you like to discipline this pet?");
                    if (j == JOptionPane.YES_OPTION){
                        gameModel.getPlayers()[currentPlayerInMenu].getPets()[1].beDisciplined();
                        showPetStats();
                        JOptionPane.showMessageDialog(mainView.getFrame(),"Disciplined!");
                        gameModel.getPlayers()[currentPlayerInMenu].getPets()[1].setState("Alive");
                        mainView.disableDealWithPetsBtns(1);
                        mainView.setStatePetLabel(gameModel.getPlayers()[currentPlayerInMenu].getPets()[1],1);

                    }
                }
                showPlayerAndPetsStatsMenu(currentPlayerInMenu);
                showPetStats();
                currentPet = mainView.getCurrentTab();///////adsdasdads
               /* mainView.showPetOneActionButtons();
                mainView.showPetTwoActionButtons();
                mainView.showPetThreeActionButtons();
                mainView.addInventoryImages(players[currentPlayerInMenu].getFoodItems(),players[currentPlayerInMenu].getToys());*/

            }
        });
        mainView.addDealWithPetThreeActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Player[] players = gameModel.getPlayers();
                if (players[currentPlayerInMenu].getPets()[2].getState().equals("Sick")){
                    int j = JOptionPane.showConfirmDialog(mainView.getFrame(),"Treatment will cost 10 GP. Would you still like to treat this pet?");
                    if (j == JOptionPane.YES_OPTION){
                        if (gameModel.getPlayers()[currentPlayerInMenu].getCurrentBalance() - 10 >  0){
                            gameModel.getPlayers()[currentPlayerInMenu].setCurrentBalance(gameModel.getPlayers()[currentPlayerInMenu].getCurrentBalance() - 10);
                            gameModel.getPlayers()[currentPlayerInMenu].getPets()[2].beCured();
                            showPetStats();
                            JOptionPane.showMessageDialog(mainView.getFrame(),"Cured!");
                            gameModel.getPlayers()[currentPlayerInMenu].getPets()[2].setState("Alive");
                            mainView.disableDealWithPetsBtns(2);
                            mainView.setStatePetLabel(gameModel.getPlayers()[currentPlayerInMenu].getPets()[2],2);

                        }else{
                            JOptionPane.showMessageDialog(mainView.getFrame(),"Insuffcient funds!");
                        }

                    }
                }else{
                    int j = JOptionPane.showConfirmDialog(mainView.getFrame(),"Would you like to discipline this pet?");
                    if (j == JOptionPane.YES_OPTION){
                        gameModel.getPlayers()[currentPlayerInMenu].getPets()[2].beDisciplined();
                        JOptionPane.showMessageDialog(mainView.getFrame(),"Disciplined!");
                        gameModel.getPlayers()[currentPlayerInMenu].getPets()[2].setState("Alive");
                        mainView.disableDealWithPetsBtns(2);
                        mainView.setStatePetLabel(gameModel.getPlayers()[currentPlayerInMenu].getPets()[2],2);
                        showPetStats();
                    }
                }
                showPlayerAndPetsStatsMenu(currentPlayerInMenu);
                showPetStats();
                currentPet = mainView.getCurrentTab();///////adsdasdads
               /* mainView.showPetOneActionButtons();
                mainView.showPetTwoActionButtons();
                mainView.showPetThreeActionButtons();
                mainView.addInventoryImages(players[currentPlayerInMenu].getFoodItems(),players[currentPlayerInMenu].getToys());*/

            }
        });
    }


    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////STORE THINGYS////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Adds action listeners to the store, so the enter store, exit store buttons.
     */

    public void addStoreAccessButtons(){

        mainView.addVisitStoreListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Player[] players = gameModel.getPlayers();
                mainView.addStoreImages();
                mainView.getCardLayout().show(mainView.getMainPanel(),"Store");
                mainView.updatePlayerCurrencyLabel(Integer.toString(players[currentPlayerInMenu].getCurrentBalance()));



            }
        });

        mainView.addExitStoreListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Player[] players = gameModel.getPlayers();
                mainView.getCardLayout().show(mainView.getMainPanel(),"Menu");
                mainView.addInventoryImages(players[currentPlayerInMenu].getFoodItems(),players[currentPlayerInMenu].getToys());
            }
        });
    }


    /**
     * Adds listeners to the help and start up screen buttons. Will take user to help section and back to setup screens.
     */

    public void addHelpSectionStartUpListeners(){

        mainView.addHelpSectionListeners(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainView.getCardLayout().show(mainView.getMainPanel(),"Help");
            }
        });

        mainView.addReturnToSetUpListeners(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainView.getCardLayout().show(mainView.getMainPanel(),"SetUp");
            }
        });

        mainView.addQuitButtonListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // exit game
            }
        });

        mainView.addSetUpButton(new ActionListener(){

            public void actionPerformed(ActionEvent e) {
                int playerCount = 0;
                int numberDays = 0;
                boolean accepted = false;
                try {
                    playerCount = Integer.parseInt(mainView.getPlayerCount());
                    numberDays = Integer.parseInt(mainView.getNumberDays());

                } catch (NumberFormatException expection) {
                    JOptionPane.showMessageDialog(mainView.getFrame(), "Input must be an integer.\nPlease try again");

                }
                if (playerCount < 4 && playerCount > 0 && numberDays > 0 && numberDays <= 50) {
                    gameModel.setPlayerCount(playerCount);
                    gameModel.setGameLength(numberDays);
                    mainView.getCardLayout().show(mainView.getMainPanel(), "PetSelectionPlayerOne");
                    accepted = true;
                } else if (numberDays != 0 && playerCount != 0) {
                    JOptionPane.showMessageDialog(mainView.getFrame(), "Invalid Input.\nPlease try again.");
                }
                if (accepted){
                    gameModel.initialiseGame(playerCount); //builds array for players
                }
                addPetsToPlayers("PetSelectionPlayerOne"); // PROCEED TO PLAYER ONE PET SELECTION SCREEN
                mainView.setScreenUpForPlayerPetSelection();
            }
        } );
    }

    /**
     * Adds the listeners for the end day/next player buttons.
     */

    public void addEndDayListeners(){

        mainView.addEndDayFinalListeners(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Player[] players = gameModel.getPlayers();
                if (gameModel.getCurrentDay() == gameModel.getGameLength() - 1){
                    mainView.getCardLayout().show(mainView.getMainPanel(),"Score");
                    for (int i = 0;i<players[currentPlayerInMenu].getPets().length;i++){
                        if (players[currentPlayerInMenu].getPets()[i] != null){
                            players[currentPlayerInMenu].getPets()[i].proccedToNextDay();
                        }
                    }
                    gameModel.calculateScore();
                    mainView.displayScore(gameModel.calcFinalScore());
                }else{
                    for (int i = 0;i<players[currentPlayerInMenu].getPets().length;i++){
                        if (players[currentPlayerInMenu].getPets()[i] != null){
                            players[currentPlayerInMenu].getPets()[i].proccedToNextDay();
                        }
                    }
                    currentPlayerInMenu++;
                    if (currentPlayerInMenu > gameModel.getPlayerCount() - 1){
                        currentPlayerInMenu = 0;
                    }
                    mainView.enableAllTabs();
                    if (gameModel.getPlayerCount() > 1){
                        mainView.disableEndDayFinalBtn();
                        mainView.enableNextPlayerBtn();
                    }

                    for (int k = 0; k<players.length;k++){ // reset all pet action counts
                        for (int i = 0;i < players[k].getPets().length;i++){
                            if (players[k].getPets()[i] != null){
                                players[k].getPets()[i].setActionCount(2);
                                mainView.setAllPetActionCounts();

                            }
                        }
                    }
                    gameModel.incrementDay();
                    mainView.updateDayCounter(gameModel.getCurrentDay()+1,gameModel.getGameLength());
                    showPlayerAndPetsStatsMenu(currentPlayerInMenu);
                    showPetStats();

                    gameModel.resetActionCount(gameModel.getPlayers()[currentPlayerInMenu]);
                    mainView.showPetOneActionButtons();
                    mainView.showPetTwoActionButtons();
                    mainView.showPetThreeActionButtons();
                    mainView.addInventoryImages(players[currentPlayerInMenu].getFoodItems(),players[currentPlayerInMenu].getToys());
                    for (int i = 0; i<players.length;i++){
                        players[i].setCurrentBalance(players[i].getCurrentBalance() + 20);

                    }
                    int i = 0;
                    for (int j = 0; j<players[currentPlayerInMenu].getPets().length;j++){
                        i = gameModel.triggerRandomEvent();
                        if (players[currentPlayerInMenu].getPets()[j] != null && players[currentPlayerInMenu].getPets()[j].getState().equals("Alive")){
                            if (i == 0){
                                JOptionPane.showMessageDialog(mainView.getFrame(),String.format("Uh oh! Pet %s has been misbehaving! Tend to your pet!",j+1));
                                gameModel.getPlayers()[currentPlayerInMenu].getPets()[j].setState("Misbehaving");
                                mainView.enableDealWithPetsBtns(j);
                            }else if (i == 1){
                                JOptionPane.showMessageDialog(mainView.getFrame(),String.format("Uh oh! Pet %s is sick! Tend to your pet!", j+1));
                                gameModel.getPlayers()[currentPlayerInMenu].getPets()[j].setState("Sick");
                                mainView.enableDealWithPetsBtns(j);
                            }
                        }else{
                            break;
                        }

                    }
                    mainView.disableRevivePetOne();
                    mainView.disableRevivePetThree();
                    mainView.disableRevivePetTwo();
                    checkDeath();
                    gameModel.calculateScore();



                }}
        });

        mainView.addEndDayButton(new ActionListener() {
            public void actionPerformed(ActionEvent e) {                                                                        //THIS CAN BE MADE MORE MODULAR
                Player[] players = gameModel.getPlayers();                                                                      //EASILY
                Pet[] playersPets = gameModel.getPlayers()[currentPlayerInMenu].getPets();
                for (int i = 0; i<playersPets.length;i++){
                    if (playersPets[i] != null){
                        playersPets[i].proccedToNextDay();}}
                currentPlayerInMenu++;
                if (currentPlayerInMenu > gameModel.getPlayerCount() - 1){
                    currentPlayerInMenu = 0;}
                mainView.enableAllTabs();
                for (int k = 0; k<players.length;k++){
                    for (int i = 0;i < players[k].getPets().length;i++){
                        if (players[k].getPets()[i] != null){
                            players[k].getPets()[i].setActionCount(2);
                            mainView.setAllPetActionCounts();

                        }
                    }
                }
                if (currentPlayerInMenu == (gameModel.getPlayerCount() -1)){
                    mainView.disableNextPlayerBtn();
                    mainView.enableEndDayFinalBtn();
                }
                showPlayerAndPetsStatsMenu(currentPlayerInMenu);
                showPetStats();                                                                                                         //THIS CAN BE MADE MORE MODULAR
                gameModel.resetActionCount(gameModel.getPlayers()[currentPlayerInMenu]);                                                //EASILY
                mainView.showPetOneActionButtons();
                mainView.showPetTwoActionButtons();
                mainView.showPetThreeActionButtons();

                mainView.addInventoryImages(players[currentPlayerInMenu].getFoodItems(),players[currentPlayerInMenu].getToys());
                int i = 0;
                for (int j = 0; j<players[currentPlayerInMenu].getPets().length;j++){
                    i = gameModel.triggerRandomEvent();
                    if (players[currentPlayerInMenu].getPets()[j] != null && players[currentPlayerInMenu].getPets()[j].getState().equals("Alive")){
                        if (i == 0){
                            JOptionPane.showMessageDialog(mainView.getFrame(),String.format("Uh oh! Pet %s has been misbehaving! Tend to your pet!",j+1));
                            gameModel.getPlayers()[currentPlayerInMenu].getPets()[j].setState("Misbehaving");
                            mainView.enableDealWithPetsBtns(j);
                        }else if (i == 1){
                            JOptionPane.showMessageDialog(mainView.getFrame(),String.format("Uh oh! Pet %s is sick! Tend to your pet!", j+1));
                            gameModel.getPlayers()[currentPlayerInMenu].getPets()[j].setState("Sick");
                            mainView.enableDealWithPetsBtns(j);
                        }
                    }else{
                        break;
                    }

                }
                mainView.disableRevivePetOne();
                mainView.disableRevivePetThree();
                mainView.disableRevivePetTwo();
                checkDeath();
                gameModel.calculateScore();


            }
        });
    }

    /**
     *Adds actions listeners to proceed to menu button and check player names.
     *
     */


    public void addListener() {

        mainView.addExitInventoryListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainView.getCardLayout().show(mainView.getMainPanel(),"Menu");

            }
        });

        mainView.addListener3(new ButtonListener());

        ///////////////////////////////////////////////////////////////////////////////////////
        //////////////////////////////Add Player One to Game///////////////////////////////////
        ///////////////////////////////////////////////////////////////////////////////////////

        mainView.addCheckNamePlayerOneListener(new ActionListener() { // checks for valid player name
            public void actionPerformed(ActionEvent e) {
                String name = mainView.getPlayerNameText();
                boolean valid = true;
                for (int i = 0; i < name.length(); i++) {
                    if (!Character.isLetter(name.charAt(i))) {
                        valid = false;
                    }
                }

                boolean uniq = gameModel.checkUnique(name);

                Player[] players = gameModel.getPlayers();
                if (valid && name.length() > 0 && name != " " && name.length() <= 15 && uniq) {
                    mainView.getPlayerNameField().setBackground(new Color(153, 255, 102)); //
                    mainView.getPlayerNameField().setEditable(false);
                    mainView.getCheckNameButtonPlayerOne().setText("Name Accepted!");
                    gameModel.addToNameList(name);
                    mainView.disablePlayerNameCheckBtn();
                    mainView.enablePetOneAddButton();
                    players[currentPlayerForPetSelection] = new Player(name);
                } else if (!uniq){
                    JOptionPane.showMessageDialog(mainView.getFrame(),"Player name must be unique!");
                 }else if (valid){
                    JOptionPane.showMessageDialog(mainView.getFrame(), "Player name not accepted!");
                }else if (!valid){
                    JOptionPane.showMessageDialog(mainView.getFrame(), "Player name must not contain digits, symbols or special characters!");
                }


            }
        });

        ///////////////////////////////////////////////////////////////////////////////////////
        //////////////////////////////END Add Player One to Game///////////////////////////////
        ///////////////////////////////////////////////////////////////////////////////////////

        ///////////////////////////////////////////////////////////////////////////////////////
        ////////////////////PROCEED TO NEXT PLAYER PET SELECTION SCREEN////////////////////////
        ///////////////////////////////////////////////////////////////////////////////////////
        mainView.addProceedToPlayerTwoListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Player[] players = gameModel.getPlayers();
               if (currentPlayerForPetSelection < 3){
                   currentPlayerForPetSelection++;
               }
               if (currentPlayerForPetSelection < gameModel.getPlayerCount()){
                   mainView.changePlayerTitle(currentPlayerForPetSelection); //change title/update for screen for next player
                   currentNumberPetsPlayer = 0;
                   mainView.setDefaultDisabledIcon();
                   mainView.setScreenUpForPlayerPetSelection();
               }else{
                   JOptionPane.showMessageDialog(mainView.getFrame(),"Everything is set up!! Have fun!");
                   mainView.getCardLayout().show(mainView.getMainPanel(),"Menu");
                   mainView.updateDayCounter(gameModel.getCurrentDay()+1,gameModel.getGameLength());
                   if (currentPlayerInMenu == (gameModel.getPlayerCount() -1)){
                       mainView.disableNextPlayerBtn();
                       mainView.enableEndDayFinalBtn();
                   }else{
                       mainView.disableEndDayFinalBtn();
                   }

                   mainView.setAllPetActionCounts();
                   addAddFeedListeners();
                   mainView.addInventoryImages(players[currentPlayerInMenu].getFoodItems(),players[currentPlayerInMenu].getToys());
                   showPlayerAndPetsStatsMenu(currentPlayerInMenu);

               }

            }
        });


        ///////////////////////////////////////////////////////////////////////////////////////
        ////////////////END PROCEED TO PLAYER TWO PET SELECTION SCREEN/////////////////////////
        ///////////////////////////////////////////////////////////////////////////////////////

        addPageSelectionListeners();
    }


    /**
     * Adds action listener to buttons which allow user to switch between pet selection pages.
     */

    public void addPageSelectionListeners(){

        mainView.addNextPageListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainView.getCardLayout().show(mainView.getMainPanel(),"Pets2");
            }
        });


        mainView.addPreviousPageListener1(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainView.getCardLayout().show(mainView.getMainPanel(),"Pets1");
            }
        });

        mainView.addNextPageTwoListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainView.getCardLayout().show(mainView.getMainPanel(),"Pets3");
            }
        });

        mainView.addPreviousPageThreeListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainView.getCardLayout().show(mainView.getMainPanel(),"Pets2");
            }
        });
    }


    /**
     * Adds action listeners to the add pet to player buttons. Upon user interaction the screen will go to the first page of pet selection.
     */

    public void addAddPetsButtonPlayerOneListeners(){
        //////////////////////////////////////////////////////////////////////
        ////////////////////////// ADDING PETS BUTTONS///////////////////////
        /////////////////////////////////////////////////////////////////////

        mainView.getPetOneButton().addActionListener(new ActionListener() { //when petOne button is clicked it should set the var currentPetbuttonSelected thingy and then pass
            //that var around so we know which button to add the image of the pet to.
            public void actionPerformed(ActionEvent e) {
                mainView.setCurrentPetSelectionButton(mainView.getPetOneButton());//this will make sure that the right button is selected, sets the current pet addition button
                mainView.getCardLayout().show(mainView.getMainPanel(),"Pets1");
            }
        });

        mainView.getPetTwoButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainView.setCurrentPetSelectionButton(mainView.getPetTwoButton());
                mainView.getCardLayout().show(mainView.getMainPanel(),"Pets1");
            }
        });


        mainView.getPetThreeButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainView.setCurrentPetSelectionButton(mainView.getPetThreeButton());
                mainView.getCardLayout().show(mainView.getMainPanel(),"Pets1");
            }
        });

        /////////////////////////////////////////////////////////////////////////////////
        /////////////////////END OF ADDING PETS BUTTONS//////////////////////////////////
        /////////////////////////////////////////////////////////////////////////////////
    }


    /**
     * Adds the action listeners to the buttons which add pets to the players from the pet selection pages.
     * @param screenName takes screen name so GUI knows what screen to update.
     */




    public void addPetsToPlayers(String screenName){
        /////////////////////////////////////////////////////////////////////////////////
        ///////////////////ADD TYPES OF PETS TO INTERFACE////////////////////////////////
        /////////////////////////////////////////////////////////////////////////////////

        mainView.addPenguin(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainView.getCardLayout().show(mainView.getMainPanel(),screenName);
                mainView.setPetAdditionImages(mainView.getCurrentPetSelectionButton(),mainView.getPenguinImage());
                String name = promptPetName();
                gameModel.getPlayers()[currentPlayerForPetSelection].getPets()[currentNumberPetsPlayer] = new Penguin(name);
                currentNumberPetsPlayer++;
            }
        });

        mainView.addDog(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainView.getCardLayout().show(mainView.getMainPanel(),screenName);
                mainView.setPetAdditionImages(mainView.getCurrentPetSelectionButton(),mainView.getDogImage());
                String name = promptPetName();
                gameModel.getPlayers()[currentPlayerForPetSelection].getPets()[currentNumberPetsPlayer] = new Dog(name);
                currentNumberPetsPlayer++;
            }
        });
        mainView.addFox(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainView.getCardLayout().show(mainView.getMainPanel(),screenName);
                mainView.setPetAdditionImages(mainView.getCurrentPetSelectionButton(),mainView.getFoxyFoxImage());
                String name = promptPetName();
                gameModel.getPlayers()[currentPlayerForPetSelection].getPets()[currentNumberPetsPlayer] = new FoxyFox(name);
                currentNumberPetsPlayer++;
            }
        });
        mainView.addButterfly(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainView.getCardLayout().show(mainView.getMainPanel(),screenName);
                mainView.setPetAdditionImages(mainView.getCurrentPetSelectionButton(),mainView.getButterflyImage());
                String name = promptPetName();
                gameModel.getPlayers()[currentPlayerForPetSelection].getPets()[currentNumberPetsPlayer] = new MagicalButterfly(name);
                currentNumberPetsPlayer++;
            }
        });
        mainView.addDragon(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainView.getCardLayout().show(mainView.getMainPanel(),screenName);
                mainView.setPetAdditionImages(mainView.getCurrentPetSelectionButton(),mainView.getDragonImage());
                String name = promptPetName();// GET PET NAME
                gameModel.getPlayers()[currentPlayerForPetSelection].getPets()[currentNumberPetsPlayer] = new Dragon(name); //ADD THE PET TO THE PLAYERS PET ARRAY
                currentNumberPetsPlayer++;
            }
        });
        mainView.addPanda(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainView.getCardLayout().show(mainView.getMainPanel(),screenName);
                mainView.setPetAdditionImages(mainView.getCurrentPetSelectionButton(),mainView.getRedPandaImage());
                String name = promptPetName();
                gameModel.getPlayers()[currentPlayerForPetSelection].getPets()[currentNumberPetsPlayer] = new RedPanda(name);
                currentNumberPetsPlayer++;
            }
        });

        /////////////////////////////////////////////////////////////////////////////////
        ///////////////////END ADD TYPES OF PETS TO INTERFACE////////////////////////////
        /////////////////////////////////////////////////////////////////////////////////
    }


    /**
     * Proceed to pet selection page.
     */

    class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            mainView.getCardLayout().show(mainView.getMainPanel(),"PetSelectionPlayerOne");

        }
    }


    /**
     * Checks pet name for a valid name, keep prompting until valid name is given.
     * @return String of the accepted pet name.
     */

    public String promptPetName(){
        boolean acceptableName = false;
        String name = "";
        String errorMessage = "";
        while (!acceptableName){
            name = JOptionPane.showInputDialog(mainView.getFrame(),String.format("%sPlease enter pet name (must be unqiue and contain only letters.)",errorMessage));
            boolean uniq = gameModel.checkUnique(name);
            if (name != null && uniq && !name.trim().equals("")){
                for (int i=0; i<name.length();i++){
                    if (!Character.isLetter(name.charAt(i))){
                        errorMessage = "Invalid pet name! The name must contain only letters!";

                    }
                }
                acceptableName = true;
                gameModel.addToNameList(name);
            }
        }
        //enables the right buttons after the name for the pet has been accepted
        if (currentNumberPetsPlayer == 0){
            mainView.enablePetTwoAddButton();
        }else if (currentNumberPetsPlayer == 1){
            mainView.enablePetThreeAddButton();
        }
        //place pet name under the right pet
        mainView.setPetNameLabel(currentNumberPetsPlayer, name);
        return name;
    }





}





