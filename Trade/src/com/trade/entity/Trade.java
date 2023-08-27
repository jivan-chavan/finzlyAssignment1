package com.trade.entity;


public abstract class Trade {
	private int tradeNo=0;
	private String currencyPair;
	private String customerName;
	private double amount;
	
	
	public Trade() {
		super();

	}
	
	public Trade(int tradeNo, String currencyPair, String customerName, double amount) {
		super();
		this.tradeNo = tradeNo;
		this.currencyPair = currencyPair;
		this.customerName = customerName;
		this.amount = amount;
	}

	public int getTradeNo() {
		return tradeNo;
	}
	public void setTradeNo(int tradeNo) {
		this.tradeNo = tradeNo;
	}
	public String getCurrencyPair() {
		return currencyPair;
	}
	public void setCurrencyPair(String currencyPair) {
		this.currencyPair = currencyPair;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public abstract void bookTrade();
	
	public abstract void printTrades();

	
}
