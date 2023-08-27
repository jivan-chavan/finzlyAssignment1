package com.trade.entity;

import java.util.Scanner;


public class TradingMain {
	
	private static Scanner scanner = new Scanner(System.in);

public static void main(String[] args) {		
	
	int option=0;
	USDToINRTrade trading = new USDToINRTrade ();
	
	do {
		
		System.out.println("************* Welcome to Trading...!!!!! *************");
		System.out.println("for following Operation, Please Select Number");
		System.out.println("Book Trade - 1");
		System.out.println("Print Trades - 2");
		System.out.println("Exit - 3");
		 option = scanner.nextInt();
		if (option == 1) {
			
			// Book Trade -operation
			trading.bookTrade();
		
		
		} else if (option == 2) {
			//Print Trades -operation
			trading.printTrades();
			 				
							 			
		} else if (option == 3) {
			// Exit -operation
			System.out.println("Do you really want to exit (y/n)");
			String exitChoice=scanner.next().toUpperCase();
			if(exitChoice.equals("Y")) {
				System.out.println("Bye-have a good day");
				break;
			}
		}else {
			// Invalid Option selection-operation
			System.out.println("!!!! ....Invalid Option Selected. Please choose correct option.");
			option=4;
		}
	} while (option>0&&option<5);
	
	
}}
