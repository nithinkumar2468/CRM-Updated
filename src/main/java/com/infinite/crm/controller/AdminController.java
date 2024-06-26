package com.infinite.crm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infinite.crm.model.Admin;
import com.infinite.crm.model.LoginMessage;
import com.infinite.crm.service.AdminService;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("api/n2")
public class AdminController {
	
	@Autowired
	private AdminService adminService;

	@PostMapping(path = "/admin/login")
	public LoginMessage loginadmin(@RequestBody Admin admin) {
		Admin email = adminService.findByEmail(admin.getEmail());
		if (email != null) {
			String password = admin.getPassword();
			String userpass = email.getPassword();
			if (password.matches(userpass)) {
				return new LoginMessage("Login Success", true);
			} else 
			{
				return new LoginMessage("Incorrect admin email or Password", false);
			}
		} else {
			return new LoginMessage("adminname not exist", false);
		}
	}
	
	/*
	 * @PostMapping("/register") public Admin createUser(@RequestBody AdminDTO
	 * admin) { return adminService.saveAdmin(admin); }
	 * 
	 * @PostMapping("/login") public ResponseEntity<JWTAuthResponse>
	 * loginUser(@RequestBody LoginDTO loginDto){ Authentication authentication=
	 * authenticationManager.authenticate( new
	 * UsernamePasswordAuthenticationToken(loginDto.getEmail(),loginDto.getPassword(
	 * ))); System.out.println(authentication);
	 * SecurityContextHolder.getContext().setAuthentication(authentication);
	 * 
	 * String token=provider.generateToken(authentication);
	 * 
	 * return ResponseEntity.ok(new JWTAuthResponse(token)); }
	 */

}
