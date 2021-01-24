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
        books.add(new Book("Warcraft: Chronicle Volume 1","Blizzard","World of Warcraft: Chronicle Volume 1 is a journey through an age of myth and legend, a time long before the Horde and the Alliance came to be.",50.0, 1));
        books.add(new Book("Tony Robbins: Unshakeable","Tony Robbins","No matter your salary, your stage of life, or when you started, this book will provide the tools to help you achieve your financial goals more rapidly than you ever thought possible.",60.0, 2));
        books.add(new Book("Harry Potter","JK Rowling","Harry Potter's summer has included the worst birthday ever, doomy warnings from a house-elf called Dobby, and rescue from the Dursleys by his friend Ron Weasley in a magical flying car!",150.0, 3));
        books.add(new Book("Head First Java", "Kathy Sierra", "If you've read a Head First book, you know what to expect - a visually rich format designed for the way your brain works. If you haven't, you're in for a treat. You'll see why people say it's unlike any other Java book you've ever read.", 100, 4));

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

