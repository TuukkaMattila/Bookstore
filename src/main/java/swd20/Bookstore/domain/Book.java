package swd20.Bookstore.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book {
	//attribuutit
	@Id //määrää taulun pääavaimen
	@GeneratedValue(strategy = GenerationType.AUTO) //tietokantapalvelin generoi uniikin arvon
	private long id;
	private String title;
	private String author;
	private int year;
	private int isbn;
	private double price;
	
	//konstruktorit
	
	public Book(String title, String author, int year, int isbn, double price) {
		super();
		this.title = title;
		this.author = author;
		this.year = year;
		this.isbn = isbn;
		this.price = price;
	}
	
	


	public Book() {
		super();
		this.title = null;
		this.author = null;
		this.year = 0;
		this.isbn = 0;
		this.price = 0.00;
	}









	//getterit ja setterit
	
	
	public String getTitle() {
		return title;
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	//toString
	
	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", year=" + year + ", isbn=" + isbn
				+ ", price=" + price + "]";
	}


	
	
	
	

}
