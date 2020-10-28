package swd20.Bookstore;

import static org.junit.Assert.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;

import swd20.Bookstore.web.BookController;
import swd20.Bookstore.web.CategoryController;

@RunWith(SpringRunner.class) //JUnit 4
@ExtendWith(SpringExtension.class)   // JUnit5 eli Jupiter
@SpringBootTest
public class BookstoreApplicationTests {

	@Autowired
	private BookController bookController;
	@Autowired
	private CategoryController categoryController;
	
	@Test
	public void contextLoads() throws Exception {
	assertThat(bookController).isNotNull();
	assertThat(categoryController).isNotNull();
	
	}
	

}
