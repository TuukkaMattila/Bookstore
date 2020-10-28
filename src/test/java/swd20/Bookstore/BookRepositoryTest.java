package swd20.Bookstore;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.assertj.core.api.Assertions.assertThat;

import swd20.Bookstore.domain.Book;
import swd20.Bookstore.domain.BookRepository;


@ExtendWith(SpringExtension.class)  
@DataJpaTest
public class BookRepositoryTest {
	
	@Autowired
	private BookRepository repository;
	
	@Test //Testataan BookRepositoryn findByTitle()-metodin toimivuutta
	public void findByTitleShouldReturnBook() {
		List <Book> books = repository.findByTitle("Harry Potter ja Viisasten kivi");
		
		assertThat(books).hasSize(1);
		assertThat(books.get(0).getAuthor()).isEqualTo("J.K Rowling");
		
	}
	
	@Test //testataan BookRepositoryn save()-medodin toimivuutta
	public void createNewBook() {
		Book book = new Book("Kalle Ahven", "T.Mattila", 2020, 198123098, 10.00, null);
		repository.save(book);
		assertThat(book.getId()).isNotNull();
	}
	
	@Test //Testataan BookRepositoryn delete()-metodin toimivuutta
	public void deleteBook() {
		Book book = new Book("Poisto kirja", "Jani", 2021, 198673098, 156.00, null);
		repository.save(book);
		
		List <Book> books = repository.findByTitle("Poisto kirja");
		assertThat(books).hasSize(1);
		
		repository.deleteById(books.get(0).getId());
		
		
		books = repository.findByTitle("Poisto kirja");
		assertThat(books).hasSize(0);
		
	}
	

}
