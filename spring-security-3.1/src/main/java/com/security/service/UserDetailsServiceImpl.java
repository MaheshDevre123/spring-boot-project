package com.security.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.security.entity.UserInfo;
import com.security.entity.UserInfoDetails;
import com.security.repo.UserInfoRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	UserInfoRepository infoRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Optional<UserInfo> userDetail = infoRepository.findByEmail(username);

		// Converting userDetail to UserDetails
		return userDetail.map(UserInfoDetails::new)
				.orElseThrow(() -> new UsernameNotFoundException("User not found " + username));
	}

}
