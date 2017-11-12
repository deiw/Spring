package pl.majorczyk.main;

import pl.majorczyk.dao.BookDao;
import pl.majorczyk.dao.BookDaoImpl;
import pl.majorczyk.model.Book;

public class Main {
    public static void main(String[] args) {
        Book book=new Book("123456789","Cloud Atlas","David Mitchell");
        BookDao bookDao=new BookDaoImpl();
        bookDao.save(book);
        System.out.println("Book saved");
        Book book1=bookDao.get(1L);
        System.out.println(book1);
        bookDao.cleanUp();
    }
}
