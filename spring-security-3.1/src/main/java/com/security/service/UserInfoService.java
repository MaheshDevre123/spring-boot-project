package com.security.service;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.security.entity.AuthRequest;
import com.security.entity.AuthResponse;
import com.security.entity.UserInfo;
import com.security.entity.UserInfoDetails;
import com.security.entity.UserInfoDto;
import com.security.repo.UserInfoRepository;
import com.security.security.PasswordHash;
import com.security.utils.JwtUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UserInfoService  {
	
	@Autowired
    private UserInfoRepository repository;
  
    @Autowired
    private PasswordEncoder encoder;
    
    @Autowired
	private ModelMapper modelMapper;
    
    @Autowired
	private AuthenticationManager authenticationManager;
    
    @Autowired
	private UserDetailsServiceImpl userDetailsService;
    
    @Autowired
	private JwtUtil jwtTokenUtil;

   
  
    public UserInfoDto addUser(UserInfo userInfoDto) {
    	userInfoDto.setPassword(PasswordHash.createHash(userInfoDto.getPassword()));
        repository.save(userInfoDto);
        UserInfo userInfo = modelMapper.map(userInfoDto, UserInfo.class);
//      user.setRoles("ROLE_USER");
        //userInfo.setActive(true);
		return modelMapper.map(repository.save(userInfo), UserInfoDto.class);
    }
    
    public AuthResponse createAuthenticationToken(AuthRequest authRequest) throws Exception {
		Optional<UserInfo> userInfo = repository.findByEmail(authRequest.getUsername());
		boolean password = PasswordHash.validatePassword(authRequest.getPassword(), userInfo.get().getPassword());
		if (!password) {
			throw new Exception("Incorrect credentials");
		}
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					authRequest.getUsername(), userInfo.get().getPassword()));
		} catch (BadCredentialsException e) {
			throw new Exception("Incorrect credentials", e);
		}
		final UserDetails userDetails = userDetailsService.loadUserByUsername(authRequest.getUsername());
		final String jwt = jwtTokenUtil.generateToken(userDetails);
		UserInfoDto userInfoDto = modelMapper.map(userInfo.get(), UserInfoDto.class);

		return new AuthResponse(jwt, userInfoDto);


	}
    
    
    public List<UserInfoDto> findAll() {
		List<UserInfo> UsersList = repository.findAll();
		if (!(UsersList == null)) {
			List<UserInfoDto> usersDtoList = new ArrayList<UserInfoDto>();
			for (UserInfo users : UsersList) {
				UserInfoDto usersDto = modelMapper.map(users, UserInfoDto.class);
				
				
				usersDtoList.add(usersDto);
			}
			Collections.reverse(usersDtoList);
			return usersDtoList;

		} else
			return null;

	}


}
