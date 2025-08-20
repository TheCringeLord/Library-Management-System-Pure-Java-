package com.pm.library.adapters.repo;

import com.pm.library.domain.Book;
import com.pm.library.domain.spec.BookSpecification;
import com.pm.library.ports.BookRepository;

import java.util.*;
import java.util.stream.Collectors;

public class InMemoryBookRepository implements BookRepository {
    private final Map<String, Book> bookDB = new HashMap<>();

    @Override
    public Book save(Book book){
        String key = book.getId();
        bookDB.put(key, book);
        return book;
    }

    @Override
    public Optional<Book> findById(String id){
        return Optional.ofNullable(bookDB.get(id));
    }

    @Override
    public Optional<Book> findByTitle(String title){
    if (title == null) return Optional.empty();
    return bookDB.values().stream()
        .filter(b -> title.equals(b.getTitle()))
        .findFirst();
    }

    @Override
    public ArrayList<Book> findAll(){
        return new ArrayList<>(bookDB.values());
    }

    @Override
    public boolean deleteById(String id){
         return bookDB.remove(id) != null;
    }

    @Override
    public List<Book> search(BookSpecification spec){
        return bookDB.values().stream()
                .filter(spec::isSatisfiedBy)
                .collect(Collectors.toList());

    }

}
