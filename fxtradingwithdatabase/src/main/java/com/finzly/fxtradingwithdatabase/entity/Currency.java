package com.finzly.fxtradingwithdatabase.entity;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Currency {
	@Id    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long currencyPairId;
	private String currencyCode;
	private double rate;
	 
	  
	public Currency() {
		// TODO Auto-generated constructor stub
	}


	public Currency(long currencyPairId, String currencyCode, double rate) {
		super();
		this.currencyPairId = currencyPairId;
		this.currencyCode = currencyCode;
		this.rate = rate;
	}


	public long getCurrencyPairId() {
		return currencyPairId;
	}


	public void setCurrencyPairId(long currencyPairId) {
		this.currencyPairId = currencyPairId;
	}


	public String getCurrencyCode() {
		return currencyCode;
	}


	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}


	public double getRate() {
		return rate;
	}


	public void setRate(double rate) {
		this.rate = rate;
	}


	@Override
	public String toString() {
		return "Currency [currencyPairId=" + currencyPairId + ", "
				+ (currencyCode != null ? "currencyCode=" + currencyCode + ", " : "") + "rate=" + rate + "]";
	}

	

		
}
