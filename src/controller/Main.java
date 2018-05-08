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
			if (option.equals(Menu.OPTION_ADD_CUSTOMER)){
				addCustomer();
			}
			if (option.equals(Menu.OPTION_VIEW_CUSTOMERS)){
				viewCustomers();
			}
			Input.getString("Press [ENTER] to return to the main menu");
		} while(!option.equals(Menu.OPTION_EXIT));

	}
	
	
	private static void returnBorrowing() {
		Output.printLine("Select a borrowing to return: ");
		Borrowing b= (Borrowing)Input.selectObjectFromList(Borrowing.getListHeader(),lib.getBorrowings());
		lib.returnBorrowing(b);
	}

	private static void addCustomer(){
		Customer cust=createCustomer();
		lib.addCustomer(cust);
		Output.printLine("Customer created");
		Output.printLine(Customer.getListHeader());
		Output.printLine(cust.toString());
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
		
		try {
			lib.addBorrowing(borrowing);			
		} catch (Exception e) {
			Output.printLine("ERROR: "+e.getMessage());
		}
		Output.printLine("Borrowing created");
		Output.printLine(Borrowing.getListHeader());
		Output.printLine(borrowing.toString());
	}






	private static void viewCatalogue(){
		Output.printListWithTitle(Book.getListHeader(),lib.getBooks());
	}
	
	private static void viewBorrowings(){
		Output.printListWithTitle(Borrowing.getListHeader(),lib.getBorrowings());
	}

	private static void viewCustomers(){
		Output.printLine("Customer list");
		Output.printListWithTitle(Customer.getListHeader(),lib.getCustomers());
	}
	
	private static void addBook(){
		Book book=createBook();
		lib.addBook(book);
		Output.printLine("Book added ");
		Output.printLine(Book.getListHeader());
		Output.printLine(book.toString());
	}
	
	

	private static Customer selectCustomer(String message) {
		Output.printLine(message);
		
		return (Customer)Input.selectObjectFromList(Customer.getListHeader(),lib.getCustomers());
	}

	public static Genre selectGenre(String message) {
		return (Genre)Input.selectObjectFromList(message,Genre.values());
	}
	
	public static Book selectBook(String message, boolean checkAvailability) {
		Book book;
		do{
			Output.printLine(message);
			book=(Book)Input.selectObjectFromList(Book.getListHeader(),lib.getBooks());
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
	
	public static Customer createCustomer() {
		String firstname = Input.getString("First name of customer: ");
		String lastName = Input.getString("Last name of customer: ");
		LocalDate dateOfBirth = Input.getDate("Date of birth of customer: ");
		String customerId = null;
		while(true){
			 customerId = Input.getString("Customer Id: ");
			 try {
				 Customer.checkCustomerId(customerId);
				 break;
			} catch (Exception e) {
				Output.printLine("Error: "+e.getMessage());
			}
		}
		boolean active = Input.getString("Is customer active (Y/N)?: ").toLowerCase().equals("y");
		Customer c;
		try {
			c=new Customer(firstname, lastName, dateOfBirth, customerId, active);
			return c;
		} catch (Exception e) {
			Output.printLine("ERROR: "+e.getMessage());
		}
		return null;
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
		
		Customer customer = null;
		try{
			customer=new Customer(
					"Client", 
					"Reader1", 
					LocalDate.parse("2001-10-22"), 
					"CC463", 
					true);
			lib.addCustomer(customer);
			
		}catch(Exception ex){
			Output.printLine("ERROR:" + ex.getMessage());
		}
		
		Borrowing borrowing = new Borrowing(customer, LocalDate.now(), book1);
		try {
			lib.addBorrowing(borrowing);			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}
