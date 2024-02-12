package Classes;

import AbstractClasses.AbstractLibraryItem;

public class Book extends AbstractLibraryItem {
    private String title;

    public Book(String inventoryNumber, String author, String title) {
        super(inventoryNumber, author);
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
