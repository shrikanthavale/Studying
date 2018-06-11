package shrikane.spring.cache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(AppRunner.class);

    private final BookRepository bookRepository;

    public AppRunner(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info(".... Fetching books");
        logger.info("isbn-1234 -->" + bookRepository.getByIsbn("isbn-1234", "book 1"));
        logger.info("isbn-1234 -->" + bookRepository.getByIsbn("isbn-1234", "book 2"));
        bookRepository.updateBook("isbn-1234", new Book("isbn-1234", "book 2"));
        logger.info("isbn-1234 -->" + bookRepository.getByIsbn("isbn-1234", "book 1"));
    }

}