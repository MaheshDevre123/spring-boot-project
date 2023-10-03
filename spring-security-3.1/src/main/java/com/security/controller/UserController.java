package com.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.security.entity.AuthRequest;
import com.security.entity.AuthResponse;
import com.security.entity.UserInfo;
import com.security.entity.UserInfoDto;
import com.security.service.JwtService;
import com.security.service.UserInfoService;

@RestController
@RequestMapping("/auth")
public class UserController {
	
	@Autowired
    private UserInfoService service;
  
    @Autowired
    private JwtService jwtService;
  
    @Autowired
    private AuthenticationManager authenticationManager;
  
    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome this endpoint is not secure";
    }
  
    @PostMapping("/addNewUser")
    public ResponseEntity<?> addNewUser(@RequestBody UserInfo userInfo) {
        return ResponseEntity.ok(service.addUser(userInfo));
    }
    
    @GetMapping("/getAll")
    public ResponseEntity<List<UserInfoDto>> getAll(){
    	return new ResponseEntity<List<UserInfoDto>>(service.findAll(), HttpStatus.OK);
    }
    

  
    @GetMapping("/userProfile")
   // @PreAuthorize("hasAuthority('super Admin')")
    public String userProfile() {
        return "Welcome to User Profile";
    }
  
    @GetMapping("/adminProfile")
   // @PreAuthorize("hasAuthority('ADMIN')")
    public String adminProfile() {
        return "Welcome to Admin Profile";
    }
  
//    @PostMapping("/generateToken")
//    public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
//        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
//        if (authentication.isAuthenticated()) {
//            return jwtService.generateToken(authRequest.getUsername());
//        } else {
//            throw new UsernameNotFoundException("invalid user request !");
//        }
//    }
    
    @PostMapping("/generateToken")
    public ResponseEntity<?> authenticateAndGetToken(@RequestBody AuthRequest authRequest) throws Exception {
        AuthResponse authResponse = service.createAuthenticationToken(authRequest);
        return new ResponseEntity<AuthResponse>(authResponse, HttpStatus.OK);
       
    }
    
//    @RequestMapping(
//            value = RequestMappingConst.LOGIN,
//            method = RequestMethod.POST)
//    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
//    	 AuthenticationResponse authResp =userService.createAuthenticationToken(authenticationRequest, false);
//    	return new ResponseEntity<AuthenticationResponse>(authResp, HttpStatus.OK);
//
////        return ResponseEntity.ok(userService.createAuthenticationToken(authenticationRequest));
//    }

}
