package swd20.Bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import swd20.Bookstore.domain.Book;
import swd20.Bookstore.domain.Category;
import swd20.Bookstore.domain.CategoryRepository;

@Controller
public class CategoryController {
	
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	//Palauttaa kategorialistauksen
	@RequestMapping(value = "/categorylist", method = RequestMethod.GET)
	public String getCategories(Model model) {
		model.addAttribute("categories", categoryRepository.findAll());
		
		return "categorylist"; //palauttaa categorylist.html
	}
	
	
	//Kategorian lisäys
	@RequestMapping(value = "/addcat") //lisää tyhjän categoriaobjektin
	public String addCategory(Model model) {
		model.addAttribute("category", new Category());
		return "addcategory";
	}
	
		//Kategorian tallennus
		@RequestMapping(value = "/savecat")
		public String save(Category category) {
			categoryRepository.save(category);
			return "redirect:categorylist";
		}
	

}
