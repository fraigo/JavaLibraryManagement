package utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import model.Genre;

public class Input {
	
	static Scanner scanner = new Scanner(System.in);
	
	public static int getInteger(String message){
		int result;
		do {
			Output.print(message);
			try {
				result = scanner.nextInt();			
			} catch (Exception e) {
				Output.printLine("Invalid number!");
				result = Integer.MIN_VALUE;
			}
			scanner.nextLine();
			
		} while (result==Integer.MIN_VALUE);
		return result;
	}
	
	public static String getString(String message){
		Output.print(message);
		String result=scanner.nextLine();
		return result;
	}

	public static LocalDate getDate(String message) {
		LocalDate date;
		do{
			String strDate=getString(message);
			try {
				date=LocalDate.parse(strDate);
			} catch (Exception e) {
				Output.printLine("Invalid date! (use YYYY-MM-DD format)");
				date = null;
			}
		}while(date == null);
		return date;
	}
	
	public static Object selectObjectFromList(String message, Object[] list) {
		int option;
		do{
			Output.printLine(message);
			Output.printListWithNumbers(list);
			Output.printBar();
			
			option=Input.getInteger("Select an option: ");
			if (option<1 || option>list.length){
				Output.printLine("Invalid option!");
				option=-1;
			}
		}while(option==-1);
		option-=1;
		Output.printLine("Selected "+list[option]);
		return list[option];
	}
	
	public static Object selectObjectFromList(String message, ArrayList list) {
		return selectObjectFromList(message, list.toArray());
	}

}
