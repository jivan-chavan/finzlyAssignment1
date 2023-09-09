package com.fxtrading.fxtrading.entity;

public class Trade {

	private long tradeNo;

	private String currencyPair;
	
	private String customerName;
	
	private double amount;
	
	private double rate;

	public Trade() {
		
	}
	
	public Trade( String currencyPair, String customerName, double amount) {
		this.currencyPair = currencyPair;
		this.customerName = customerName;
		this.amount = amount;
	}
	
	public long getTradeNo() {
		return tradeNo;
	}
	public void setTradeNo(long tradeNo) {
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
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	
	
	
	
}
