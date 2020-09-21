package swd20.Bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import swd20.Bookstore.domain.BookRepository;

@Controller
public class BookController {
	
	@Autowired
	private BookRepository bookRepository;
	
	//palauttaa kirjalistauksen
	@RequestMapping(value = "/booklist", method = RequestMethod.GET)
	public String getBooks(Model model) {
		
		//lisätään autolista model-olion mappiin avainarvolla templatea varten
		model.addAttribute("books", bookRepository.findAll());
		
		return "Books"; //palautetaan Books.html
	}
	
	//http://localhost:8080/index
	@RequestMapping("/index")
	public String Bookstore() {
		return "books";
	}
	

}
