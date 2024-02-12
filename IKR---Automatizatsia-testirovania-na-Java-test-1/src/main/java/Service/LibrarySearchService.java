package Service;

import Interface.LibraryItem;
import Interface.LibrarySearchServiceInterface;

import java.util.ArrayList;
import java.util.List;

public class LibrarySearchService implements LibrarySearchServiceInterface {
    private List<LibraryItem> libraryItems;

    public LibrarySearchService(List<LibraryItem> libraryItems) {
        this.libraryItems = libraryItems;
    }

    @Override
    public List<LibraryItem> searchByInventoryNumber(String inventoryNumber) {
        List<LibraryItem> result = new ArrayList<>();
        for (LibraryItem item : libraryItems) {
            if (item.getInventoryNumber().equals(inventoryNumber)) {
                result.add(item);
            }
        }
        return result;
    }

    @Override
    public List<LibraryItem> searchByAuthor(String author) {
        List<LibraryItem> result = new ArrayList<>();
        for (LibraryItem item : libraryItems) {
            if (item.getAuthor().equals(author)) {
                result.add(item);
            }
        }
        return result;
    }

    public List<LibraryItem> searchByInventoryNumberAndAuthor(String inventoryNumber, String author) {
        List<LibraryItem> result = new ArrayList<>();
        for (LibraryItem item : libraryItems) {
            if (item.getInventoryNumber().equals(inventoryNumber) && item.getAuthor().equals(author)) {
                result.add(item);
            }
        }
        return result;
    }
}
