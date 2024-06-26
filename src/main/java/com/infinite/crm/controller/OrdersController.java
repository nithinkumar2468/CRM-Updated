package com.infinite.crm.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infinite.crm.dto.OrdersDTO;
import com.infinite.crm.model.Orders;
import com.infinite.crm.service.OrdersService;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("api/n1")
public class OrdersController {
	
	@Autowired
	private OrdersService service;
	
	@PostMapping("/{useremail}/order")
	@NonNull
	Observable<Observable<Orders>> newOrders(@PathVariable String useremail, @RequestBody OrdersDTO newOrders) {
		
		LocalDateTime myDateObj = LocalDateTime.now();   
	    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd MMM yyyy HH:mm a");  
	    
	    String formattedDate = myDateObj.format(myFormatObj);  
	    
	    newOrders.setOrdereddate(formattedDate);
		return Observable.fromCallable(()->service.addOrders(useremail,newOrders));
	}
	
	@GetMapping("/{useremail}/orders")
	Observable<OrdersDTO> getAllOrdersbyemail(@PathVariable String useremail) {
		return Observable.fromIterable(service.findAllOrders(useremail));
	}

}
