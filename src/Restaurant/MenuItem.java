package Restaurant;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class MenuItem {
    private String name;
    private String description;
    private float price;
    private String category;
    private LocalDate dateAdded;
    private boolean isNew;
    private LocalDate compareDate = LocalDate.now().minus(30, ChronoUnit.DAYS);


    public MenuItem(String aName, float aPrice) {
        this.name = aName;
        this.price = aPrice;
        this.dateAdded = LocalDate.now();
        this.isNew = this.dateAdded.isAfter(compareDate);
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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public LocalDate getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(LocalDate dateAdded) {
        this.dateAdded = dateAdded;
    }

    public boolean isNew() {
        return isNew;
    }

    public void setNew(boolean aNew) {
        isNew = aNew;
    }

    public LocalDate getCompareDate() {
        return compareDate;
    }

    public void setCompareDate(LocalDate compareDate) {
        this.compareDate = compareDate;
    }

    //instance methods
    public void print() {
        if (this.isNew) {
            System.out.print("NEW! ");
        }
        System.out.println(this.getName()+" "+this.getPrice());
    }
}
