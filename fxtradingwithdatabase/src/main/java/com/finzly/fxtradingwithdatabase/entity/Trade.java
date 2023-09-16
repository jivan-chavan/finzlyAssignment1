package com.finzly.fxtradingwithdatabase.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Trade {
	  @Id    
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long tradeNo;

	private String currencyPair;
	
	private String customerName;
	
	private double amount;

	public Trade() {

	}
	
	public Trade(long tradeNo, String currencyPair, String customerName, double amount) {
		super();
		this.tradeNo = tradeNo;
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

	@Override
	public String toString() {
		return "Trade [tradeNo=" + tradeNo + ", " + (currencyPair != null ? "currencyPair=" + currencyPair + ", " : "")
				+ (customerName != null ? "customerName=" + customerName + ", " : "") + "amount=" + amount + "]";
	}

	

}


	
	

