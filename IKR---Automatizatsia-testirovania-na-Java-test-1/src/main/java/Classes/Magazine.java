package Classes;

import AbstractClasses.AbstractLibraryItem;

public class Magazine extends AbstractLibraryItem {
    private String magazineName;

    public Magazine(String inventoryNumber, String author, String magazineName) {
        super(inventoryNumber, author);
        this.magazineName = magazineName;
    }

    public String getMagazineName() {
        return magazineName;
    }
}
