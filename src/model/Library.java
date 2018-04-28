package model;


import java.time.LocalDate;
import java.util.ArrayList;

import utils.Output;


public class Library {
	
	String name;
	ArrayList<Book> books;
	ArrayList<Customer> customers;
	ArrayList<Borrowing> borrowings;

	
	
	public Library(String name) {
		super();
		setName(name);
		books=new ArrayList<Book>();
		customers= new ArrayList<Customer>();
		borrowings= new ArrayList<Borrowing>();
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<Book> getBooks() {
		return books;
	}
	public void addBook(Book book) {
		this.books.add(book);
	}
	public ArrayList<Customer> getCustomers() {
		return customers;
	}
	public void addCustomer(Customer customer) {
		this.customers.add(customer);
	}
	public ArrayList<Borrowing> getBorrowings() {
		return borrowings;
	}
	public void addBorrowing(Borrowing borrowing) {
		if (books.containsAll(borrowing.getBooks())){
			this.borrowings.add(borrowing);
			for (int i = 0; i < borrowing.getBooks().size(); i++) {
				Book book=borrowing.getBooks().get(i);
				book.copiesAvailable--;
			}
			Output.printLine("OK: Borrowing added");
		}else{
			Output.printLine("ERROR: Some books are not in library");
		}
	}
	
	
	@Override
	public String toString() {
		return "Library [name=" + name + ", books=" + books + ", customers="
				+ customers + ", borrowings=" + borrowings + "]";
	} 
	
	

}
