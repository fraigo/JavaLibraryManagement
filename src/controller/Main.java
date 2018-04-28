package controller;


import java.time.LocalDate;
import utils.Input;
import utils.Output;
import view.Menu;



import model.Author;
import model.Book;
import model.Borrowing;
import model.Customer;
import model.Genre;
import model.Library;

public class Main {
	
	static Library lib;
	static Menu menu;
	
	public static void main(String[] args) {
		initializeLibrary();		
		readOption();		
	}
	
	
	
	
	public static void readOption(){
		menu=new Menu();
		String option;
		do{
			option=menu.getMenuSelection(lib.getName());
			Output.printTitle(option);
			if (option.equals(Menu.OPTION_VIEW_CATALOGUE)){
				viewCatalogue();
			}
			if (option.equals(Menu.OPTION_ADD_BOOK)){
				addBook();
			}
			if (option.equals(Menu.OPTION_VIEW_BORROWINGS)){
				viewBorrowings();
			}
			if (option.equals(Menu.OPTION_ADD_BORROWING)){
				addBorrowing();
			}
			if (option.equals(Menu.OPTION_RETURN_BORROWING)){
				returnBorrowing();
			}
			Input.getString("Press [ENTER] to return to the main menu");
		} while(!option.equals(Menu.OPTION_EXIT));

	}
	
	
	private static void returnBorrowing() {
		Borrowing b= (Borrowing)Input.selectObjectFromList("Select a borrowing to return: ",lib.getBorrowings());
		lib.getBorrowings().remove(b);
	}




	private static void addBorrowing() {
		Customer customer = selectCustomer("Select the customer: ");
		String answer;
		Book book;
		book = selectBook("Select a book to borrow: ",true);
		Borrowing borrowing=new Borrowing(customer, LocalDate.now(), book);
		answer = Input.getString("Add more books (Y/N) ? ").toLowerCase();

		while(answer.equals("y") && borrowing.getBooks().size()<Borrowing.MAXIMUM_BOOKS){
			book = selectBook("Select a book to add to borrowing: ",true);
			borrowing.addBook(book);
			answer = Input.getString("Add more books (Y/N) ? ").toLowerCase();
		}
			
		lib.addBorrowing(borrowing);
		
		Output.printLine(borrowing.toString());
	}






	private static void viewCatalogue(){
		Output.printListWithTitle("    "+Book.stringHeader(),lib.getBooks());
	}
	
	private static void viewBorrowings(){
		Output.printListWithTitle("Active borrowings",lib.getBorrowings());
	}

	private static void addBook(){
		Book book=createBook();
		lib.addBook(book);
	}
	
	

	private static Customer selectCustomer(String message) {
		return (Customer)Input.selectObjectFromList(message,lib.getCustomers());
	}

	public static Genre selectGenre(String message) {
		return (Genre)Input.selectObjectFromList(message,Genre.values());
	}
	
	public static Book selectBook(String message, boolean checkAvailability) {
		Book book;
		do{
			book=(Book)Input.selectObjectFromList(message,lib.getBooks());
			if (checkAvailability && book.getCopiesAvailable()==0){
				Output.printLine("Book not available");
			}
		} while(checkAvailability && book.getCopiesAvailable()==0);
		return book;
	}
	
	
	public static Book createBook(){
		String title = Input.getString("Book Title: ");
		Author author = createAuthor();
		int yearPublished = Input.getInteger("Year published: "); 
		int edition = Input.getInteger("Edition number: ");
		String ISBN = Input.getString("ISBN code: ");
		Genre genre = selectGenre("Genre of the book: ");
		int numberOfCopies = Input.getInteger("Number of copies: ");
		
		return new Book(title, author, yearPublished, edition, ISBN, genre, numberOfCopies);
	}

	public static Author createAuthor() {
		String firstname = Input.getString("First name of author: ");
		String lastName = Input.getString("Last name of author: ");
		LocalDate dateOfBirth = Input.getDate("Date of birth of author: ");
		String pseudonym = Input.getString("Pseudonym of author: "); 
		Genre specialty = selectGenre("Speciality of author (Genre): ");
		return new Author(firstname, lastName, dateOfBirth, pseudonym, specialty);
	}
	
	private static void initializeLibrary(){
		lib = new Library("CICC Library");
		Author jrrTolkien=new Author(
				"John Ronald Reuel", 
				"Tolkien", 
				LocalDate.parse("1892-01-03"), 
				"JRR Tolkien", 
				Genre.FICTION);
		
		Book book1=new Book(
				"The Lord of the Rings", 
				jrrTolkien, 
				1954, 
				1, 
				"TLLR345634", 
				Genre.FICTION, 
				5);
		lib.addBook(book1);

		Book book2=new Book(
				"The Hobbit", 
				jrrTolkien, 
				1997, 
				2, 
				"THBT45636", 
				Genre.FICTION, 
				3);
		lib.addBook(book2);

		
		Author miguelDeCervantes=new Author(
				"Miguel de", 
				"Cervantes", 
				LocalDate.parse("1547-09-29"), 
				"Cervantes", 
				Genre.FICTION);
		Book book3=new Book(
				"Don Quixote", 
				miguelDeCervantes, 
				1605, 
				3, 
				"DQXT363464", 
				Genre.FICTION, 
				2);
		lib.addBook(book3);
		
		Customer customer=new Customer(
				"Client", 
				"Reader1", 
				LocalDate.parse("2001-10-22"), 
				"F34634363", 
				true);
		lib.addCustomer(customer);
		
		Borrowing borrowing = new Borrowing(customer, LocalDate.now(), book1);
		lib.addBorrowing(borrowing);
		
	}
}
