package pl.majorczyk.springbootjpa.dao;

import pl.majorczyk.springbootjpa.model.Book;

public interface BookDao {
    void save(Book book);
    Book get(Long id);
}
