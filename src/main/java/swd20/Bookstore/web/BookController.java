package swd20.Bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import swd20.Bookstore.domain.Book;
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
		
		return "booklist"; //palautetaan Books.html
	}
	//Kirjan poisto
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteBook(@PathVariable("id") Long bookId) {
		bookRepository.deleteById(bookId);
		return "redirect:../booklist";
	}
	
	//Kirjan lisäys
	@RequestMapping(value = "/add") //tekee tyhjän kirja objektin
	public String addBook(Model model) {
		model.addAttribute("book", new Book());
		return "addbook";
	}
	
	//Kirjan tallennus
	@RequestMapping(value = "/save")
	public String save(Book book) {
		bookRepository.save(book);
		return "redirect:booklist";
	}
	
	//Kirjan muokkaus
	@RequestMapping(value= "/edit/{id}")
	public String editBook(@PathVariable("id") Long bookId, Model model) {
		model.addAttribute("book", bookRepository.findById(bookId));
		return "editbook";
	}
	
	//http://localhost:8080/index
	@RequestMapping("/index")
	public String Bookstore() {
		return "booklist";
	}
	

}
