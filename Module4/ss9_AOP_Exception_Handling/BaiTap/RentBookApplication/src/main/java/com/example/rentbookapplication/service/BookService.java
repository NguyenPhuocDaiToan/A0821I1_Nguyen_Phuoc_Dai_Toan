package com.example.rentbookapplication.service;

import com.example.rentbookapplication.model.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BookService {
    private static Map<Integer, Book> books = new HashMap<>();

    static {
        books.put(1, new Book(1, "Tam quốc diễn nghĩa", 10));
        books.put(2, new Book(2, "Ngày chia tay", 10));
        books.put(3, new Book(3, "Ngày trở về", 10));
        books.put(4, new Book(4, "Ngày vĩnh biệt", 10));
    }

    public List<Book> getAll() {
        return new ArrayList<Book>(books.values());
    }

    public Book getBookById(int id) {
        return books.get(id);
    }

    public boolean rentBook(Book book) {
        Book temp = books.get(book.getId());
        if(temp.getAmount() == 0) {
            return false;
        } else {
            temp.setAmount(temp.getAmount() - 1);
//            books.replace(book.getId(), book);
            return true;
        }
    }

    public void giveBookBack(Book book) {
        Book temp = books.get(book.getId());
        if(temp != null) {
            temp.setAmount(temp.getAmount() + 1);
        }
    }
}

