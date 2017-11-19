package pl.majorczyk.springdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.majorczyk.springdata.model.Book;

import java.util.List;


@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
    @Query(name = "Book.getByAuthorOrTitle")
    List<Book> getByAuthorOrTitle(@Param("author") String author,
                                  @Param("title") String title);
}
