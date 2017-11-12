package pl.majorczyk.dao;

import pl.majorczyk.model.Book;

public interface BookDao {
    void save(Book book);
    Book get(Long id);
}
