package pl.majorczyk.springbootjpa.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.majorczyk.springbootjpa.model.Book;

import javax.persistence.*;

@Repository
@Transactional
public class BookDaoImpl implements BookDao {

    @PersistenceContext
    private EntityManager em;

    BookDaoImpl(){}

    @Override
    public void save(Book book) {
      em.persist(book);
    }

    @Override
    public Book get(Long id) {
        Book book=em.find(Book.class,id);
        return book;
    }
}
