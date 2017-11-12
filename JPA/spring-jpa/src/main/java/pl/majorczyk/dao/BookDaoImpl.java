package pl.majorczyk.dao;

import org.springframework.stereotype.Repository;
import pl.majorczyk.model.Book;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;

@Repository
public class BookDaoImpl implements BookDao {

    @PersistenceUnit
    private EntityManagerFactory emFactory;

    BookDaoImpl(){}

    @Override
    public void save(Book book) {
      EntityManager em=emFactory.createEntityManager();
      EntityTransaction et=em.getTransaction();
      et.begin();
      em.persist(book);
      et.commit();
    }

    @Override
    public Book get(Long id) {
        EntityManager em=emFactory.createEntityManager();
        Book book=em.find(Book.class,id);
        return book;
    }
}
