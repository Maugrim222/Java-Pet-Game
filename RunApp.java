/**
 * Created by Arics (Hayden and Tom) on 12/05/2017.
 */
import javax.swing.*;
public class RunApp {

    public static void main(String[] argv){
        PetApp view = new PetApp();
        Controller c = new Controller(new Game(), view);
        view.build();
        c.addListener();
    }
}
