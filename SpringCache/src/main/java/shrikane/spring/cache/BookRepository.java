/**
 * 
 */
package shrikane.spring.cache;

/**
 * @author shrik
 *
 */
public interface BookRepository {

	Book getByIsbn(String isbn, String bookTitle);
	
	Book updateBook(String isbn, Book book);
}
