package swd20.Bookstore;



import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import swd20.Bookstore.domain.Book;
import swd20.Bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	//automaattisesti generoitu main-metodi
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public static CommandLineRunner demo(BookRepository bookRepository) {
	return (args) -> {
	// Your code...add some demo data to db
		Book book1 = new Book("Harry Potter ja viisasten kiva", "J.K Rowling", 1997, 978074, 25.90);
		Book book2 = new Book("Harry Potter ja salaisuuksien kammio", "J.K Rowling", 2002, 978075, 26.90);
		bookRepository.save(book1); //tallennetaan tietokantaan
		bookRepository.save(book2); //tallennetaan tietokantaan
		
	};
	}
	
	/* @Bean
	public CommandLineRunner demo (BookRepository bookRepository) {
		return (args) -> {
			//demodata
			
			Book book1 = new Book("Harry Potter ja viisasten kiva", "J.K Rowling", 1997, 978074, 25.90);
			Book book2 = new Book("Harry Potter ja salaisuuksien kammio", "J.K Rowling", 2002, 978075, 26.90);
			bookRepository.save(book1); //tallennetaan tietokantaan
			bookRepository.save(book2); //tallennetaan tietokantaan
			
			
		}; 
	} */

}
