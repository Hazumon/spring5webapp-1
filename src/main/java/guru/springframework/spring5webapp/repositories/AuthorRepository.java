package guru.springframework.spring5webapp.repositories;

import guru.springframework.spring5webapp.domain.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.CrudRepositoryExtensionsKt;

// extended class shows 1.) type 2.) ID value
// This sets up a CRUD Repo
public interface AuthorRepository extends CrudRepository<Author, Long> {
}
