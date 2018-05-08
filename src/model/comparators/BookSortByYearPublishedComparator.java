package model.comparators;

import java.util.Comparator;

import model.Book;


public class BookSortByYearPublishedComparator implements Comparator<Book> {

	@Override
	public int compare(Book book1, Book book2) {
		// 2 Points
		// TODO Write your code here
		if(book1.getYearPublished()>book2.getYearPublished()){
			return 1;
		}
		if(book1.getYearPublished()<book2.getYearPublished()){
			return -1;
		}
		return 0;
	}
}
