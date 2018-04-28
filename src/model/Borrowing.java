package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import utils.Output;

public class Borrowing {
	
	public static final int MAXIMUM_BOOKS = 5;
	ArrayList<Book> books;
	Customer customer;
	boolean finished;
	LocalDate borrowedDate;
	LocalDate returnDate;
	
	public Borrowing(Customer customer, LocalDate borrowedDate, Book book) {
		super();
		setCustomer(customer);
		setBorrowedDate(borrowedDate);
		setFinished(finished);
		this.books = new ArrayList<Book>();
		addBook(book);
		
	}

	@Override
	public String toString() {
		String result;
		result = String.format("Customer: %20s | Date: %10s | Books: %2d \n", customer.getFullname(), getBorrowedDate().format(DateTimeFormatter.ofPattern("dd-LLL-yyyy")), books.size());
		for (int i = 0; i < books.size(); i++) {
			result += String.format("    [Book %2d] %s\n",i+1,books.get(i));
		}
		return result;
	}

	public ArrayList<Book> getBooks() {
		return books;
	}

	public void addBook(Book book) {
		if (this.books.size()==MAXIMUM_BOOKS){
			Output.printLine(String.format("Maximum books reached (%d)",MAXIMUM_BOOKS));
		}else{
			this.books.add(book);
		}
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public boolean isFinished() {
		return finished;
	}

	public void setFinished(boolean finished) {
		this.finished = finished;
	}

	public LocalDate getBorrowedDate() {
		return borrowedDate;
	}

	public void setBorrowedDate(LocalDate borrowedDate) {
		this.borrowedDate = borrowedDate;
	}

	public LocalDate getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(LocalDate returnDate) {
		this.returnDate = returnDate;
	}
	
	
 
}
