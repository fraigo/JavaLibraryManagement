package model;

/**
 * Book class
 * @author Francisco Igor
 *
 */
public class Book implements Comparable<Book> {
	
	/**
	 * Title of the book
	 */
	private String title;
	/**
	 * Author of the book 
	 */
	private Author author;
	/**
	 * Year published
	 */
	private int yearPublished;
	/**
	 * Number of edition
	 */
	private int edition;
	/**
	 * ISBN code of the book
	 */
	private String ISBN;
	/**
	 * Genre of the book
	 */
	private Genre genre;
	/**
	 * Number of copies total
	 */
	private int numberOfCopies;
	/**
	 * Number of copies available
	 */
	private int copiesAvailable;
	
	
	public Book(String title, Author author, int yearPublished, int edition,
			String isbn, Genre genre, int numberOfCopies) {
		super();
		setTitle(title);
		setAuthor(author);
		setYearPublished(yearPublished);
		setEdition(edition);
		setISBN(isbn);
		setGenre(genre);
		setNumberOfCopies(numberOfCopies);
		setCopiesAvailable(numberOfCopies);
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
	public int getYearPublished() {
		return yearPublished;
	}
	public void setYearPublished(int yearPublished) {
		this.yearPublished = yearPublished;
	}
	public int getEdition() {
		return edition;
	}
	public void setEdition(int edition) {
		this.edition = edition;
	}
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public Genre getGenre() {
		return genre;
	}
	public void setGenre(Genre genre) {
		this.genre = genre;
	}
	public int getNumberOfCopies() {
		return numberOfCopies;
	}
	public void setNumberOfCopies(int numberOfCopies) {
		this.numberOfCopies = numberOfCopies;
	}
	public int getCopiesAvailable() {
		return copiesAvailable;
	}
	public void setCopiesAvailable(int copiesAvailable) {
		this.copiesAvailable = copiesAvailable;
	}

	public static String getListHeader() {
		return String.format("%-30s|%-20s|%4s|%7s|%5s|%9s|%8s", "Title", "Author", "Year", "Edition", "Total", "Available", "Borrowed");
	}
	
	@Override
	public String toString() {
		return String.format("%-30s|%-20s|%4d|%7d|%5d|%9d|%8d", 
				title, 
				author.getPseudonym(), 
				yearPublished, 
				edition, 
				numberOfCopies, 
				copiesAvailable, 
				numberOfCopies-copiesAvailable);
	}

	@Override
	public int compareTo(Book otherBook) {
		if (this.getEdition()>otherBook.getEdition()){
			return 1;
		}
		if (this.getEdition()<otherBook.getEdition()){
			return -1;
		}
		return 0;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + edition;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Book other = (Book) obj;
		if (author == null) {
			if (other.author != null) {
				return false;
			}
		} else if (!author.equals(other.author)) {
			return false;
		}
		if (edition != other.edition) {
			return false;
		}
		return true;
	}
	
	

}
