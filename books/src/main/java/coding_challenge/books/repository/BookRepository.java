package coding_challenge.books.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import coding_challenge.books.model.Book;
import jakarta.transaction.Transactional;

@Transactional
public interface BookRepository extends JpaRepository<Book, Integer>{

	Optional<Book> findByISBN(String isbn);

	void deleteByISBN(String isbn);

}
