package by.tms.storage;

import by.tms.model.Book;

import java.util.ArrayList;
import java.util.List;

public class InMemoryItemStorage {
    private static List<Book> books = new ArrayList<>();

    private static InMemoryItemStorage inMemoryItemStorage;

    private InMemoryItemStorage(){

    }

    public static InMemoryItemStorage getInstance() {
        if (inMemoryItemStorage == null){
            inMemoryItemStorage = new InMemoryItemStorage();
            return inMemoryItemStorage;
        }
        return inMemoryItemStorage;
    }

    {
        books.add(new Book("Warcraft","Blizzard","something",50.0, 1));
        books.add(new Book("Titanic","Author","desc here",60.0, 2));
        books.add(new Book("Harry Potter","JK Rowling","desc again",150.0, 3));

    }

    public List<Book> getAll(){
        return new ArrayList<>(books);
    }

    public Book getById(int id){
        for (Book book : books) {
            if (book.getId() == id) return book;
        }
        return null;
    }
}

