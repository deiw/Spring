package pl.majorczyk.dao;

import pl.majorczyk.model.Book;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


public class BookDaoImpl implements BookDao {

    private EntityManagerFactory emFactory;
    private EntityManager em;

    public BookDaoImpl() {
        emFactory= Persistence.createEntityManagerFactory("myPersistenceUnit");
        em=emFactory.createEntityManager();
    }

    @Override
    public void save(Book book) {
        EntityTransaction et=em.getTransaction();
        et.begin();
        em.persist(book);
        et.commit();
    }

    @Override
    public Book get(Long id) {
        Book book=em.find(Book.class,id);
        return book;
    }

    @Override
    public void cleanUp() {
       em.close();
       emFactory.close();
    }
}
