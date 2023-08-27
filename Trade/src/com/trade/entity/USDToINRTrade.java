package com.trade.entity;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class USDToINRTrade extends Trade {

	private double rate = 66.00;
	private ArrayList<Trade> list = new ArrayList<Trade>();

	private static Scanner scanner = new Scanner(System.in);

	private static int count = 1;

	public USDToINRTrade() {
		super();
	}

	public USDToINRTrade(double rate) {
		super();
		this.rate = rate;
	}

	public USDToINRTrade(int tradeNo, String currencyPair, String customerName, double amount) {
		super(tradeNo, currencyPair, customerName, amount);
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	@Override
	public void bookTrade() {

		Trade trade = null;

		// data-1
		System.out.println("Enter Customer Name");
		String customerName = scanner.next();

		// data-2
		String currencyPair = null;
		do {
			System.out.println("Enter Currency Pair");
			currencyPair = scanner.next().toUpperCase();
		} while (!currencyPair.equals("USDINR"));

		// data-3
		double amount = 0;
		do {
			try {
				System.out.println("Enter amount to transfer:");
				amount = scanner.nextDouble();

				if (amount <= 0) {
					System.out.println("Please enter a valid positive amount.");
				} else {
					break;
				}
			} catch (InputMismatchException e) {
				System.out.println("Please enter a valid numeric amount.");
				scanner.next();
			}
		} while (true);

		String getRateChoice = null;
		do {
			System.out.println("Do you want to get Rate");
			getRateChoice = scanner.next().toLowerCase();
		} while (!getRateChoice.equals("yes") && !getRateChoice.equals("no"));

		if (getRateChoice.equals("yes")) {

			System.out.println("1USD is equal to " + getRate() + "INR ");
		}

		System.out.println(" You are transferring INR" + amount * getRate() + "to " + customerName + "\n"
				+ "Book/Cancel this trade?");

		String bookOrCancelOption = scanner.next().toLowerCase();

		if (bookOrCancelOption.equals("book")) {
			trade = new USDToINRTrade(count, currencyPair, customerName, amount);
			list.add(trade);
			count++;
			System.out.println("Trade booked...!!!");
			System.out.println("Trade for USDINR has been booked with rate " + getRate() + ". The amount of INR "
					+ amount * getRate() + " will  be transferred in 2 working days to " + customerName + " .");
		} else if (bookOrCancelOption == "cancel") {
			System.out.println("Trade is Canceled. ");
		}

		System.out.println("***********************************");

	}

	@Override
	public void printTrades() {

		if (list.isEmpty()) {
			System.out.println("You have not done any transaction yet.");
		} else {
			System.out.println("Print statements");
			System.out.println("TradeNo CurrencyPair CustomerName Amount Rate");
			for (Trade trade : list) {

				System.out.println(trade.getTradeNo() + "       " + trade.getCurrencyPair() + "        "
						+ trade.getCustomerName() + "     INR" + trade.getAmount() + "    " + this.rate);

			}
		}
		System.out.println("***********************************");
	}


}
