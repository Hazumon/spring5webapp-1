package guru.springframework.spring5webapp.repositories;

import guru.springframework.spring5webapp.domain.Book;
import org.springframework.data.repository.CrudRepository;

// This sets up a CRUD Repository
public interface BookRepository extends CrudRepository<Book, Long> {
}
