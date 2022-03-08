package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    @Autowired
    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Bootstrap data starting");
        Publisher publisher = new Publisher();
        publisher.setName("Public Publisher");
        publisher.setCity("Lahore");
        publisher.setState("Punjab");
        publisher.setAddressLine1("Abdali Road");
        publisher.setZip("54000");
        publisherRepository.save(publisher);

        Author rod = new Author("Author First Name", "Author Last Name");
        Book book1 = new Book("Book 1", "12345678");
        book1.setPublisher(publisher);
        rod.getBooks().add(book1);
        book1.getAuthors().add(rod);
        publisher.getBooks().add(book1);
        authorRepository.save(rod);
        bookRepository.save(book1);
        publisherRepository.save(publisher);

        Author rod2 = new Author("Author First Name", "Author Last Name");
        Book book2 = new Book("Book 2", "12345678");
        book2.setPublisher(publisher);
        rod2.getBooks().add(book2);
        book2.getAuthors().add(rod2);
        publisher.getBooks().add(book2);
        authorRepository.save(rod2);
        bookRepository.save(book2);
        publisherRepository.save(publisher);

        System.out.println("Total Publishers = "+publisherRepository.count());
        System.out.println("Total books count =" + bookRepository.count());



    }
}
