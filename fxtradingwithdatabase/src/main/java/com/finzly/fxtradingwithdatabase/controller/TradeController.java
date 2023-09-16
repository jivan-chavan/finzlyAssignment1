package com.finzly.fxtradingwithdatabase.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finzly.fxtradingwithdatabase.entity.Trade;
import com.finzly.fxtradingwithdatabase.service.TradeService;


@RestController
@RequestMapping("/trade")
public class TradeController {


	@Autowired 
	private TradeService tradeService;
	
	@PostMapping("/exchange")
	public String exchange(@RequestBody Trade newtrade) {
		
		return tradeService.exchange(newtrade);
	    
	}
	
	@GetMapping("/getalltrade")
	public List<Trade> getAllTradeList(){
		return tradeService.getAllTradeList();
	}
	

	
}
