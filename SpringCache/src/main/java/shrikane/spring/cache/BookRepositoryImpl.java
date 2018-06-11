/**
 * 
 */
package shrikane.spring.cache;

import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

/**
 * @author shrik
 *
 */
@Component
public class BookRepositoryImpl implements BookRepository {

	/* (non-Javadoc)
	 * @see shrikane.spring.cache.BookRepository#getByIsbn(java.lang.String)
	 */
	@Override
	@Cacheable(cacheNames="books", key="#isbn")
	public Book getByIsbn(String isbn, String bookTitle) {
		simulateSlowService();
		return new Book(isbn, bookTitle);
	}

	// Don't do this at home
	private void simulateSlowService() {
		try {
			long time = 3000L;
			Thread.sleep(time);
		} catch (InterruptedException e) {
			throw new IllegalStateException(e);
		}
	}

	@Override
	@CachePut(cacheNames="books", key="#isbn")
	public Book updateBook(String isbn, Book book) {
		Book existingBook = getByIsbn(isbn, book.getTitle());
		existingBook.setTitle(book.getTitle() + "appende one");
		return existingBook;
	}

}
