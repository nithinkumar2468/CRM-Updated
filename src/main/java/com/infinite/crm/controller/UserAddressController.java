package com.infinite.crm.controller;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infinite.crm.model.UserAddress;
import com.infinite.crm.model.UserAddressDTO;
import com.infinite.crm.service.UserAddressService;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("api/n1")
public class UserAddressController {

	@Autowired
	private UserAddressService service;

	@PostMapping("/{useremail}/address")
	Observable<UserAddress> newUserAddress(@PathVariable String useremail, @RequestBody UserAddressDTO newUser) {
		return Observable.fromCallable(()->service.saveAddress(useremail, newUser));
	}

	@GetMapping("/{useremail}/addresses")
	Observable<UserAddressDTO> getAllUserAddresses(@PathVariable String useremail) {
		return Observable.fromIterable(service.findAllAddresses(useremail));

	}
	
	@DeleteMapping("/address/{id}")
	Observable<String> deleteUserAddress(@PathVariable Long id) {
		service.deleteAddress(id);
		return Observable.fromCallable(()->"User with Address " + id + " has been deleted success.");
	}
	
}