package com.security.entity;

public class AuthResponse {
	
	    private final String jwt;
	 //private String loginStatus;
	    private UserInfoDto userDto;
		
		public AuthResponse(String jwt, UserInfoDto userDto) {
			super();
			this.jwt = jwt;
			this.userDto = userDto;
		}
		public UserInfoDto getUserDto() {
			return userDto;
		}
		public void setUserDto(UserInfoDto userDto) {
			this.userDto = userDto;
		}
		public String getJwt() {
			return jwt;
		}
	    
	    
	    

}
