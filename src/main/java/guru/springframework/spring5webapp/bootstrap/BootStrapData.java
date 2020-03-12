package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

// CommandLine Runner is an interface with one method run(String... args){} that tells spring to run any instances of of this type
@Component // detects this class as a Spring managed component with 2 properties AuthorRepository and BookRepository
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    // this will due dependency injection into the constructor for instances of these 2
    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "123123");

        Publisher publisher = new Publisher();
        publisher.setName("SFG Publishing");
        publisher.setAddress("850 S Longmore");

        publisherRepository.save(publisher);

        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        ddd.setPublisher(publisher);
        // this saves it into your repository of the h2 database
        authorRepository.save(eric);
        bookRepository.save(ddd);

        Author rod  = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "392913049");

        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noEJB);

        publisher.getBooks().add(noEJB);
        publisher.getBooks().add(ddd);
        publisherRepository.save(publisher);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println("Publisher Listed " + publisherRepository.count());
        System.out.println("Number of books in Publisher is " + publisher.getBooks().size());
    }
}
