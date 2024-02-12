package AbstractClasses;

import Interface.LibraryItem;

public abstract class AbstractLibraryItem implements LibraryItem {
    private String inventoryNumber;
    private String author;

    public AbstractLibraryItem(String inventoryNumber, String author) {
        this.inventoryNumber = inventoryNumber;
        this.author = author;
    }

    @Override
    public String getInventoryNumber() {
        return inventoryNumber;
    }

    @Override
    public String getAuthor() {
        return author;
    }
}
