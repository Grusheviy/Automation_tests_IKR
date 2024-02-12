import Classes.Book;
import Classes.Magazine;
import Interface.LibraryItem;
import Service.LibrarySearchService;

import java.util.ArrayList;
import java.util.List;

public class LibraryMain {
    public static void main(String[] args) {
        // Инициализация реестра
        List<LibraryItem> libraryItems = new ArrayList<>();
        libraryItems.add(new Book("123456", "Author_1", "Title_1"));
        libraryItems.add(new Magazine("789012", "Author_2", "Title_2"));

        // Инициализация сервиса поиска
        LibrarySearchService searchService = new LibrarySearchService(libraryItems);

        // Пример поиска по инвентарному номеру
        List<LibraryItem> itemsByInventoryNumber = searchService.searchByInventoryNumber("123456");
        System.out.println("Items found by inventory number:");
        for (LibraryItem item : itemsByInventoryNumber) {
            System.out.println(item.getClass().getSimpleName() + ": " + item.getAuthor());
        }

        // Пример поиска по автору
        List<LibraryItem> itemsByAuthor = searchService.searchByAuthor("Author_2");
        System.out.println("\nItems found by author:");
        for (LibraryItem item : itemsByAuthor) {
            System.out.println(item.getClass().getSimpleName() + ": " + item.getInventoryNumber());
        }

        // Пример поиска по инвентарному номеру и автору
        List<LibraryItem> itemsByBoth = searchService.searchByInventoryNumberAndAuthor("123456", "Author_1");
        System.out.println("\nItems found by both inventory number and author:");
        for (LibraryItem item : itemsByBoth) {
            System.out.println(item.getClass().getSimpleName() + ": " +
                    item.getInventoryNumber() + " - " + item.getAuthor());
        }
    }
}