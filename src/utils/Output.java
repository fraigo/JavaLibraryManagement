package utils;

import java.util.ArrayList;

public class Output {
	
	public static final int LINE_SIZE = 40;
	
	public static void printLine(String line){
		System.out.println(line);
	}
	
	public static void print(String line){
		System.out.print(line);
	}
	
	public static void printBar(){
		for (int i = 0; i < LINE_SIZE; i++) {
			print("=");	
		}
		printLine("");
	}
	
	public static void printTitle(String title){
		printLine(String.format("***  %-30s  ***", title));
	}
	
	public static void printHeader(String header){
		printBar();
		printTitle(header);
		printBar();
	}
	
	public static void printListWithNumbers(ArrayList list){
		for (int i = 0; i < list.size(); i++) {
			print(String.format("%2d. ", i+1));
			printLine(list.get(i).toString());
		}
	}
	
	public static void printListWithTitle(String header,ArrayList list){
		Output.printBar();
		Output.printListHeader(header,true);
		Output.printListWithNumbers(list);
		Output.printBar();
		Output.printTitle(list.size()+" element(s)");
	}
	
	public static void printListWithNumbers(Object[] list){
		for (int i = 0; i < list.length; i++) {
			print(String.format("%2d. ", i+1));
			printLine(list[i].toString());
		}
	}
	
	public static void printListHeader(String header,boolean numbers){
		if (numbers){
			Output.print("    ");
		}
		Output.printLine(header);
	}

}
