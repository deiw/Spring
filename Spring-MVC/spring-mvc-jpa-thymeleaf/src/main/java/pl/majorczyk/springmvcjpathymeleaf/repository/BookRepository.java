package pl.majorczyk.springmvcjpathymeleaf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.majorczyk.springmvcjpathymeleaf.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
}
