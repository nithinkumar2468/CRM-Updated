package com.infinite.crm.config;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
public class JwtResponse {
	private String jwttoken;
	private String username;
	public String getJwttoken() {
		return jwttoken;
	}
	public void setJwttoken(String jwttoken) {
		this.jwttoken = jwttoken;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public JwtResponse(String jwttoken, String username) {
		super();
		this.jwttoken = jwttoken;
		this.username = username;
	}
	public JwtResponse() {
		super();
	}
	@Override
	public String toString() {
		return "JwtResponse [jwttoken=" + jwttoken + ", username=" + username + "]";
	}
	
	

}
