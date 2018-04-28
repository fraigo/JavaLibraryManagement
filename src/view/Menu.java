package view;


import java.util.ArrayList;
import java.util.Scanner;

import utils.Input;
import utils.Output;


public class Menu {
	
	public static final String OPTION_VIEW_CATALOGUE = "Book Catalog List";
	public static final String OPTION_ADD_BOOK = "Add Book";
	public static final String OPTION_EXIT = "Exit application";
	public static final String OPTION_VIEW_BORROWINGS = "Borrowings List";
	public static final String OPTION_ADD_BORROWING = "Add Borrowing";
	public static final String OPTION_RETURN_BORROWING = "Return Borrowing";
	public static final String OPTION_VIEW_CUSTOMERS = "Custoemr List";
	public static final String OPTION_ADD_CUSTOMER = "Add Customer";
	ArrayList<String> options;
	Scanner scanner;
	
	public Menu() {
		scanner = new Scanner(System.in);
		scanner.reset();
		options = new ArrayList<String>();
		options.add(OPTION_VIEW_CATALOGUE);
		options.add(OPTION_ADD_BOOK);
		options.add(OPTION_VIEW_BORROWINGS);
		options.add(OPTION_ADD_BORROWING);
		options.add(OPTION_RETURN_BORROWING);
		options.add(OPTION_VIEW_CUSTOMERS);
		options.add(OPTION_ADD_CUSTOMER);
		options.add(OPTION_EXIT);
	}
	
	public String getMenuSelection(String title){
		int option;
		Output.printLine("");
		Output.printBar();
		Output.printTitle("Library Management System");
		Output.printTitle(title);
		Output.printBar();
		Output.printListWithNumbers(options);
		Output.printBar();
		option=Input.getInteger("Choose an option number :");
		if (option<1 || option>options.size()){
			Output.printLine("Option invalid!");
			return getMenuSelection(title);
		}

		return options.get(option-1);
	}

}
