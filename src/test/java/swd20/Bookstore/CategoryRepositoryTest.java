package swd20.Bookstore;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import swd20.Bookstore.domain.Book;
import swd20.Bookstore.domain.Category;
import swd20.Bookstore.domain.CategoryRepository;

import static org.assertj.core.api.Assertions.assertThat;


@ExtendWith(SpringExtension.class)  
@DataJpaTest
public class CategoryRepositoryTest {

	@Autowired
	private CategoryRepository repository;
	
	@Test //Testataan CategoryRepositoryn findByName()-metodin toimivuutta
	public void findByNameShouldReturnCategory() {
		List <Category> categories = repository.findByName("Fantasy");
		
		assertThat(categories).hasSize(1);
		assertThat(categories.get(0).getName()).isEqualTo("Fantasy");
		
	}
	
	@Test //testataan CategoryRepositoryn save()-medodin toimivuutta
	public void createNewCategory() {
		Category category = new Category("Scifi");
		repository.save(category);
		assertThat(category.getName()).isNotNull();
	}
	
	
	@Test //Testataan CategoryRepositoryn delete()-metodin toimivuutta
	public void deleteCategory() {
		Category category = new Category("Scifi");
		repository.save(category);
		
		List <Category> categories = repository.findByName("Scifi");
		assertThat(categories).hasSize(1);
		
		repository.deleteById(categories.get(0).getCategoryid());
		
		
		categories = repository.findByName("Scifi");
		assertThat(categories).hasSize(0);
		
	}
	
}
