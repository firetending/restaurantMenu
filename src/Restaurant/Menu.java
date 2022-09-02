package Restaurant;

import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.time.LocalDate;
import java.util.HashMap;

public class Menu {
    private String title;
    private HashMap<Category,ArrayList<MenuItem>> fullMenu = new HashMap<>();
    private LocalDate lastUpdated;

    public Menu(String title) {
        this.title = title;
        this.setCategory(Category.APPS, new ArrayList<>());
        this.setCategory(Category.MAINS, new ArrayList<>());
        this.setCategory(Category.ZERTS, new ArrayList<>());
//        for (String aCategory : categories){
//            this.setCategory(aCategory,new ArrayList<>());
//        }
    }

    public enum Category {
        APPS("Appetizers"),
        MAINS("Main Courses"),
        ZERTS("Desserts");

        private final String title;

        Category(String title) {
            this.title = title;
        }

        public String getTitle() {
            return title;
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getLastUpdated() {
        return lastUpdated;
    }

    private void setLastUpdated() {
        this.lastUpdated = LocalDate.now();
    }

    public HashMap<Category, ArrayList<MenuItem>> getFullMenu() {
        return fullMenu;
    }

    public void setFullMenu(HashMap<Category, ArrayList<MenuItem>> fullMenu) {
        this.fullMenu = fullMenu;
    }

    public ArrayList<MenuItem> getCategory(Category category) {
        if (this.fullMenu.containsKey(category)) {
            return this.fullMenu.get(category);
        } else {
            return new ArrayList<>();
        }
    }

    public void setCategory(Category aCategory, ArrayList<MenuItem> items) {
        this.fullMenu.put(aCategory,items);
    }


    //instance methods
    public void addItem(Category category, MenuItem item) {
        ArrayList<MenuItem> current = this.getCategory(category);
        if (current.contains(item)) {
            System.out.println("oops, \""+item.getName()+"\" is already on the menu!");
            return;
        }
        current.add(item);
        item.addedToMenu(category,LocalDate.now());
        this.setCategory(category,current);
        this.setLastUpdated();
    }

    public void removeItem(Category category, MenuItem item) {
        ArrayList<MenuItem> current = this.getCategory(category);
        current.remove(item);
        item.removedFromMenu();
        this.setCategory(category,current);
    }

    @Override
    public String toString() {
        String output = "\n*************";
        output+="\n"+this.title;
        for (Category category : this.getFullMenu().keySet()) {
            ArrayList<MenuItem> items = this.getFullMenu().get(category);
            output += "\n\n"+category.title.toUpperCase()+":";
            for (MenuItem dish : items) {
//                System.out.println(dish.getName()+" "+dish.getPrice());
                output += "\n> "+dish.toString();
            }
        }
        output += "\n\nLast Updated: "+this.getLastUpdated().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT));
        output += "\n*************\n";
        return output;
    }

}
