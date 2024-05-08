package com.infinite.crm.service;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infinite.crm.model.OrdersTestingClass;
import com.infinite.crm.repository.OrderTestingRepository;

@Service
public class OrdersTestingService {
	
	@Autowired
	private OrderTestingRepository Repo;

	public Observable<OrdersTestingClass> addOrders(OrdersTestingClass newOrder) {
		return Observable.fromCallable(()->Repo.save(newOrder));
	}

	public Observable<OrdersTestingClass> findOrders() {
		return Observable.fromIterable(Repo.findAll());
	}

	public Observable<OrdersTestingClass> findOrderbyId(int id)
	{
		return Observable.fromCallable(()->Repo.findById(id).get());
	}

	public Observable<OrdersTestingClass> updateOrder(int id, OrdersTestingClass newOrder) {
		return Observable.fromCallable(()->Repo.findById(id).map(order->{
			order.setPname(newOrder.getPname());
			order.setAddress(newOrder.getAddress());
			order.setUsername(newOrder.getUsername());
			order.setEmail(newOrder.getEmail());
			order.setOrderdate(newOrder.getOrderdate());
			order.setTotalprice(newOrder.getTotalprice());
			return Repo.save(order);
		}).get());
				
		}
}
