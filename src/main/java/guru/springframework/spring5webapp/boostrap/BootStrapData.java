package guru.springframework.spring5webapp.boostrap;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.model.Publisher;
import guru.springframework.spring5webapp.repository.AuthoryRepository;
import guru.springframework.spring5webapp.repository.BookRepository;
import guru.springframework.spring5webapp.repository.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthoryRepository authoryRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthoryRepository authoryRepository, BookRepository bookRepository,
                         PublisherRepository publisherRepository) {
        this.authoryRepository = authoryRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Publisher publisher=new Publisher();
        publisher.setCity("Baku");
        publisher.setName("USA Publisher");
        publisher.setState("fl");

        publisherRepository.save(publisher);

        System.out.println("Number Of Publisher : " + publisherRepository.count());

        Author eric=new Author("Eric","Evans");
        Book ddd=new Book("Domain Driven Design","123123");

        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        ddd.setPublisher(publisher);
        publisher.getBooks().add(ddd);

        authoryRepository.save(eric);
        bookRepository.save(ddd);
        publisherRepository.save(publisher);

        Author rod=new Author("Rod","Johnson");
        Book noEjb=new Book("J2EE Development without EJB","1231245673");

        rod.getBooks().add(noEjb);
        noEjb.getAuthors().add(rod);
        noEjb.setPublisher(publisher);
        publisher.getBooks().add(noEjb);

        authoryRepository.save(rod);
        bookRepository.save(noEjb);
        publisherRepository.save(publisher);

        System.out.println("Started in BootStrap");
        System.out.println("Number of Books : " + bookRepository.count());
        System.out.println("Publisher number of Books : " + publisher.getBooks().size());

    }
}
