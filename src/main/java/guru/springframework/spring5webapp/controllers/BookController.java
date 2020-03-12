package guru.springframework.spring5webapp.controllers;

import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // this makes the class into a Spring MVC Controller
public class BookController {

    private final BookRepository bookRepository;

    // with this constructor, once spring instantiates this, it ill inject an instance of Book repository into the controller
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @RequestMapping(path = "/books")
    public String getBooks(Model model){ // this returns a copy of the model to the view

//       model.addAttribute("books", bookRepository.findAll());
        return "books";
    }
}
