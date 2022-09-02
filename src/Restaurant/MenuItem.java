package Restaurant;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class MenuItem {
    private String name;
    private String description;
    private double price;
    private Menu.Category category;
    private LocalDate dateAdded;
    private boolean isNew;
    private static LocalDate compareDate = LocalDate.now().minus(30, ChronoUnit.DAYS);
    public static final NumberFormat USD = NumberFormat.getCurrencyInstance();

    public MenuItem(String aName, double aPrice) {
        this.name = aName;
        this.price = aPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Menu.Category getCategory() {
        return category;
    }

    public void setCategory(Menu.Category category) {
        this.category = category;
    }

    public LocalDate getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(LocalDate dateAdded) {
        this.dateAdded = dateAdded;
    }

    public boolean getIsNew() {
        this.isNew = this.dateAdded.isAfter(compareDate);
        return isNew;
    }

    public LocalDate getCompareDate() {
        return compareDate;
    }

    //instance methods
    public void addedToMenu(Menu.Category category, LocalDate dateAdded) {
        this.setCategory(category);
        this.setDateAdded(dateAdded);
    }

    public void removedFromMenu() {
        this.setCategory(null);
    }

    @Override
    public String toString() {
        String output = "";
        if (this.getIsNew()) {
            output+="NEW! ";
        }
        output+=this.getName()+" "+USD.format(this.getPrice());
        return output;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MenuItem menuItem = (MenuItem) o;
        return Double.compare(menuItem.price, price) == 0 && Objects.equals(name, menuItem.name) && Objects.equals(description, menuItem.description) && Objects.equals(category, menuItem.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, price, category);
    }
}
