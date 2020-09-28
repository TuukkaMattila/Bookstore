package swd20.Bookstore;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import swd20.Bookstore.domain.Book;
import swd20.Bookstore.domain.BookRepository;
import swd20.Bookstore.domain.Category;
import swd20.Bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {
	
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);  // uusi loggeriattribuutti

	//automaattisesti generoitu main-metodi
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public static CommandLineRunner demo(BookRepository bookRepository) {
	return (args) -> {
	
		Book book1 = new Book("Harry Potter ja Viisasten kivi", "J.K Rowling", 1998, 978074, 25.90);
		Book book2 = new Book("Harry Potter ja Salaisuuksien kammio", "J.K Rowling", 1999, 978075, 26.90);
		Book book3 = new Book("Harry Potter ja Azkabanin vanki", "J.K Rowling", 2000, 978076, 26.50);
		Book book4 = new Book("Harry Potter ja Liekehtivä pikari", "J.K Rowling", 2001, 978077, 24.90);
		Book book5 = new Book("Harry Potter ja Feeniksin kilta", "J.K Rowling", 2004, 978078, 27.90);
		Book book6 = new Book("Harry Potter ja Puoliverinen prinssi", "J.K Rowling", 2006, 978079, 28.90);
		Book book7 = new Book("Harry Potter ja Kuoleman varjelukset", "J.K Rowling", 2008, 978080, 30.00);
		
		bookRepository.save(book1); //tallennetaan tietokantaan
		bookRepository.save(book2); 
		bookRepository.save(book3); 
		bookRepository.save(book4);
		bookRepository.save(book5); 
		bookRepository.save(book6); 
		bookRepository.save(book7);
		
		log.info("Fetch all Books");
		for (Book book : bookRepository.findAll()) {
			log.info(book.toString());
		}
		
	
		
		
	};
	}
	
	@Bean
	public static CommandLineRunner democat(CategoryRepository categoryRepository) {
		return (args) -> {
			Category category1 = new Category("Fantasy");
			Category category2 = new Category("Drama");
			Category category3 = new Category("Horror");
			Category category4 = new Category("Cooking");
			
			categoryRepository.save(category1);
			categoryRepository.save(category2);
			categoryRepository.save(category3);
			categoryRepository.save(category4);
			
		log.info("Fetch all Categories");
		for (Category category : categoryRepository.findAll()) {
				log.info(category.toString());
			}
		};
	}
	

}


/* 
		Book book1 = new Book("Harry Potter ja Viisasten kivi", "J.K Rowling", 1998, 978074, 25.90);
		Book book2 = new Book("Harry Potter ja Salaisuuksien kammio", "J.K Rowling", 1999, 978075, 26.90);
		Book book3 = new Book("Harry Potter ja Azkabanin vanki", "J.K Rowling", 2000, 978076, 26.50);
		Book book4 = new Book("Harry Potter ja Liekehtivä pikari", "J.K Rowling", 2001, 978077, 24.90);
		Book book5 = new Book("Harry Potter ja Feeniksin kilta", "J.K Rowling", 2004, 978078, 27.90);
		Book book6 = new Book("Harry Potter ja puoliverinen prinssi", "J.K Rowling", 2006, 978079, 28.90);
		Book book7 = new Book("Harry Potter ja kuoleman varjelukset", "J.K Rowling", 2008, 978080, 30.00);
		
		bookRepository.save(book1); //tallennetaan tietokantaan
		bookRepository.save(book2); 
		bookRepository.save(book3); 
		bookRepository.save(book4); 
		bookRepository.save(book5); 
		bookRepository.save(book6); 
		bookRepository.save(book7); 
*/