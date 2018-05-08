package model;


import java.util.ArrayList;

public class Library {
	
	private String name;
	private ArrayList<Book> books;
	private ArrayList<Customer> customers;
	private ArrayList<Borrowing> borrowings;

	
	
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
	
	public void addBorrowing(Borrowing borrowing) throws Exception {
		if (books.containsAll(borrowing.getBooks())){
			ArrayList<String> unavailable=new ArrayList<String>();
			for (int i = 0; i < borrowing.getBooks().size(); i++) {
				Book book=borrowing.getBooks().get(i);
				if (book.getCopiesAvailable()==0){
					unavailable.add(book.getTitle());
				}
				if (unavailable.size()>0){
					throw new Exception("Some books are not available ("+unavailable.toString()+")");
				}
			}
			for (int i = 0; i < borrowing.getBooks().size(); i++) {
				Book book=borrowing.getBooks().get(i);
				book.setCopiesAvailable(book.getCopiesAvailable()-1);
			}
			this.borrowings.add(borrowing);
		}else{
			throw new Exception("ERROR: Some books are not in library");
		}
	}
	
	
	@Override
	public String toString() {
		return "Library [name=" + name + ", books=" + books.size() + ", customers="
				+ customers.size() + ", borrowings=" + borrowings.size() + "]";
	}

	public void returnBorrowing(Borrowing borrowing) {
		borrowing.setFinished(true);
		for (int i = 0; i < borrowing.getBooks().size(); i++) {
			Book book=borrowing.getBooks().get(i);
			book.setCopiesAvailable(book.getCopiesAvailable()+1);
		}
		this.borrowings.remove(borrowing);		
	} 
	
	

}
