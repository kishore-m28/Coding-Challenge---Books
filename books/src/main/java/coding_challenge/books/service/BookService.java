package coding_challenge.books.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import coding_challenge.books.exception.InvalidIdException;
import coding_challenge.books.model.Book;
import coding_challenge.books.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;
	
	
	public Book addBook(Book book) {
		return bookRepository.save(book);
	}


	public List<Book> getAllBook() {
		return bookRepository.findAll();
	}


	public Book updateBook(Book newBook, int id) throws InvalidIdException {
		Optional<Book> optional = bookRepository.findById(id);
		if(optional.isEmpty())
			throw new InvalidIdException("Invalid ID Given"); 
		Book oldBook = optional.get();
		
		oldBook.setTitle(newBook.getTitle());
		oldBook.setAuthor(newBook.getAuthor());
		oldBook.setISBN(newBook.getISBN());
		oldBook.setPublicationYear(newBook.getPublicationYear());
		
		return bookRepository.save(oldBook);
	}
	
	
	
	
}
