package Restaurant;

import java.util.ArrayList;
import java.util.Arrays;

public class Admin {
    public static void main(String[] args) {

        MenuItem eggs = new MenuItem("eggs",5);
        MenuItem beef = new MenuItem("cheesesteak", 8);

        ArrayList<String> catg =
                new ArrayList<>(Arrays.asList(new String[]{"appetizers", "main courses", "desserts"}));
        Menu alices = new Menu();
        alices.addItem("appetizers",eggs);
        alices.addItem("entrees",beef);
        alices.printMenu();
    }
}
