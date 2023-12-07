package guru.springframework.spring5webapp.boostrap;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.repository.AuthoryRepository;
import guru.springframework.spring5webapp.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthoryRepository authoryRepository;
    private final BookRepository bookRepository;

    public BootStrapData(AuthoryRepository authoryRepository, BookRepository bookRepository) {
        this.authoryRepository = authoryRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author eric=new Author("Eric","Evans");
        Book ddd=new Book("Domain Driven Design","123123");

        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authoryRepository.save(eric);
        bookRepository.save(ddd);

        Author rod=new Author("Rod","Johnson");
        Book noEjb=new Book("J2EE Development without EJB","1231245673");

        rod.getBooks().add(noEjb);
        noEjb.getAuthors().add(rod);

        authoryRepository.save(rod);
        bookRepository.save(noEjb);

        System.out.println("Started in BootStrap");
        System.out.println("Number of Books : " + bookRepository.count());

    }
}
