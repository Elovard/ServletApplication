package by.tms.model;

import java.util.ArrayList;
import java.util.List;

public class Basket {
    private List<Book> list = new ArrayList<>();

    public void addItem(Book book){
        list.add(book);
    }

    public List<Book> getAll(){
        return new ArrayList<>(list);
    }
}
