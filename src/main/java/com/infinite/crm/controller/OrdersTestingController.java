package com.infinite.crm.controller;

import java.time.LocalDate;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infinite.crm.model.OrdersTestingClass;
import com.infinite.crm.service.OrdersTestingService;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("api/n1")
public class OrdersTestingController {
	
	@Autowired
	private OrdersTestingService service;
	
	
	@PostMapping("/orderstesting")
	@NonNull
	Observable<Observable<OrdersTestingClass>> newOrders(@RequestBody OrdersTestingClass newOrder) {
		LocalDate date = LocalDate.now();
		newOrder.setOrderdate(date);
		return Observable.fromCallable(()->service.addOrders(newOrder));
	}

	@GetMapping("/orderstesting")
	Observable<OrdersTestingClass> getAllOrders() {
		return Observable.fromIterable((Iterable<? extends OrdersTestingClass>) service.findOrders());
	}

	@GetMapping("/ordertesting/{id}")
	@NonNull
	Observable<Observable<OrdersTestingClass>> getOrdersById(@PathVariable int id) {
		return Observable.fromCallable(()->service.findOrderbyId(id));
	}

	@PutMapping("/ordertesting/{id}")
	@NonNull
	Observable<Observable<OrdersTestingClass>> updateOrders(@RequestBody OrdersTestingClass newOrder, @PathVariable int id) {
		return Observable.fromCallable(()->service.updateOrder(id,newOrder));
	}

}
