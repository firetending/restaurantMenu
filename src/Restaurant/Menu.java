package Restaurant;

import java.lang.reflect.Array;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Menu {
    private HashMap<String,ArrayList<MenuItem>> fullMenu = new HashMap<>();
    private LocalDate lastUpdated;


    public Menu(){

    }

    public Menu(ArrayList<String> categories) {
        for (String aCategory : categories){
            this.setCategory(aCategory,new ArrayList<>());
        }
    }

    public LocalDate getLastUpdated() {
        return lastUpdated;
    }

    private void setLastUpdated(LocalDate lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public HashMap<String, ArrayList<MenuItem>> getFullMenu() {
        return fullMenu;
    }

    public void setFullMenu(HashMap<String, ArrayList<MenuItem>> fullMenu) {
        this.fullMenu = fullMenu;
    }

    public ArrayList<MenuItem> getCategory(String category) {
        if (this.fullMenu.containsKey(category)) {
            return this.fullMenu.get(category);
        } else {
            return new ArrayList<>();
        }
    }

    public void setCategory(String aCategory, ArrayList<MenuItem> items) {
        this.fullMenu.put(aCategory,items);
    }


    //instance methods
    public void addItem(String category, MenuItem item) {
        ArrayList<MenuItem> current = this.getCategory(category);
        current.add(item);
        this.setCategory(category,current);
        this.setLastUpdated(LocalDate.now());
    }

    public void removeItem(String category, MenuItem item) {
        ArrayList<MenuItem> current = this.getCategory(category);
        current.remove(item);
        this.setCategory(category,current);
    }

    public void printMenu() {
        for (String category : this.getFullMenu().keySet()) {
            ArrayList<MenuItem> items = this.getFullMenu().get(category);
            System.out.println("\n"+category.toUpperCase()+":");
            for (MenuItem dish : items) {
//                System.out.println(dish.getName()+" "+dish.getPrice());
                dish.print();
            }
        }
        System.out.println("\nLast Updated: "+this.getLastUpdated().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT)));
    }

}
