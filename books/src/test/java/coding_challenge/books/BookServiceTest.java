package coding_challenge.books;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import coding_challenge.books.model.Book;
import coding_challenge.books.service.BookService;

@SpringBootTest
public class BookServiceTest {
	
	@Autowired
	private BookService bookService;
	
	@Test
	public void addBookTest() {
		
		Book book = new Book();
		book.setTitle("test");
		book.setAuthor("kishore");
		book.setISBN("hdh46");
		book.setPublicationYear("2024");
		
		Book dbBook = bookService.addBook(book);
		assertEquals("test", dbBook.getTitle());
		assertEquals("kishore", dbBook.getAuthor());
		assertEquals("hdh46", dbBook.getISBN());
		assertEquals("2024", dbBook.getPublicationYear());
	}
}
