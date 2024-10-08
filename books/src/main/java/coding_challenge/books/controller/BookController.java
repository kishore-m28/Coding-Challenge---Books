package coding_challenge.books.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import coding_challenge.books.exception.InvalidIdException;
import coding_challenge.books.model.Book;
import coding_challenge.books.service.BookService;


@RestController
@RequestMapping("/book")
public class BookController {

	@Autowired
	private BookService bookService;
	
	@PostMapping("/add")
	public Book addBook(@RequestBody Book book){
		return bookService.addBook(book);
	}
	
	@GetMapping("/all")
	public List<Book> getAllBook() {
		return bookService.getAllBook();
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateBook(@RequestBody Book newBook,@PathVariable int id) {
		try {
			Book book = bookService.updateBook(newBook,id);
			return ResponseEntity.ok(book);
		} catch (InvalidIdException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@GetMapping("/one/{isbn}")
	public ResponseEntity<?> getByIsbn(@PathVariable String isbn) {
		try {
			Book book = bookService.getByIsbn(isbn);
			return ResponseEntity.ok(book);
		} catch (InvalidIdException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@DeleteMapping("/delete/{isbn}")
	public ResponseEntity<?> deleteBook(@PathVariable String isbn) {
		try {
			bookService.deleteBook(isbn);
			return ResponseEntity.ok("Book deleted");
		} catch (InvalidIdException e) {
			 return ResponseEntity.badRequest().body(e.getMessage());
		} 
	}
	
}
