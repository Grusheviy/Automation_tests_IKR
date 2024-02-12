package Interface;

import java.util.List;

public interface LibrarySearchServiceInterface {
    List<LibraryItem> searchByInventoryNumber(String inventoryNumber);
    List<LibraryItem> searchByAuthor(String author);
}
