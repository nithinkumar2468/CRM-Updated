package com.infinite.crm.controller;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infinite.crm.exceptions.UserNotFoundException;
import com.infinite.crm.model.LoginFront;
import com.infinite.crm.model.LoginMessage;
import com.infinite.crm.model.User;
import com.infinite.crm.service.UserService;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("api/n1")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/user")
	Observable<User> newUser(@RequestBody User newUser) {
		return Observable.fromCallable(()->userService.save(newUser));
	}

	@PostMapping(path = "/users/login")
	LoginMessage loginuser(@RequestBody LoginFront loginFront) {
		User email = userService.findByEmail(loginFront.getEmail());
		if (email != null) {
			String password = loginFront.getPassword();
			String userpass = email.getPassword();
			if (password.matches(userpass)) {
				return new LoginMessage("Login Success", true);
			} else {
				return new LoginMessage("Incorrect emailId or Password", false);
			}
		} else {
			return new LoginMessage("emailId not exist", false);
		}
	}

	@GetMapping("/users")
	Observable<User> getAllUsers() {
		return Observable.fromIterable(userService.findAll());
	}

	@GetMapping("/user/{id}")
	Observable<User> getUserById(@PathVariable Long id) {
		return Observable.fromCallable(()->userService.findById1(id));
	}

	/*
	 * @PutMapping("/user/{id}") User updateUser(@RequestBody User
	 * newUser, @PathVariable Long id) { return userService.findById2(id,newUser); }
	 */

	@PatchMapping("/user/{id}")
	Observable<User> updateUserMobileno(@RequestBody User newUser, @PathVariable Long id) {
		return Observable.fromCallable(()->userService.findById3(id, newUser));
	}

	@DeleteMapping("/user/{id}")
	Observable<String> deleteUser(@PathVariable Long id) {
		if (!userService.existsById(id)) {
			throw new UserNotFoundException(id);
		}
		userService.deleteById(id);
		return Observable.fromCallable(()->"User with id " + id + " has been deleted success.");
	}
}
