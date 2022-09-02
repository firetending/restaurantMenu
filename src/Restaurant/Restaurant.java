package Restaurant;

public class Restaurant {
    public static void main(String[] args) {

        MenuItem eggs = new MenuItem("eggs",5);
        MenuItem beef = new MenuItem("cheesesteak", 9);
        MenuItem pork = new MenuItem("pork belly burnt ends",8);
        MenuItem anything = new MenuItem("anything you want",19.99);
        MenuItem potato = new MenuItem("fries",4);

//        ArrayList<Menu.Category> catg =
//                new ArrayList<>(Arrays.asList(new Menu.Category[]{Menu.Category.APPS, Menu.Category.MAINS, Menu.Category.ZERTS}));
        Menu alices = new Menu("Alice's Restaurant");
        alices.addItem(Menu.Category.APPS,eggs);
        alices.addItem(Menu.Category.MAINS,beef);
        alices.addItem(Menu.Category.MAINS,anything);
        alices.addItem(Menu.Category.ZERTS,pork);
        alices.addItem(Menu.Category.APPS,potato);
        alices.addItem(Menu.Category.MAINS,anything);
        System.out.println(alices);
        System.out.println("\nWhat do we recommend today? Try the..."+pork.toString());
        alices.removeItem(Menu.Category.APPS,potato);
        System.out.println("Uh-oh, fresh out of potatoes!");
        System.out.println(alices);
    }
}
