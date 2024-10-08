package com.kosta.service;

import java.util.List;
import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.kosta.domain.UserDTO;
import com.kosta.entity.User;
import com.kosta.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
	private final UserRepository userRepository;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public User save(User user) {
		
		return userRepository.save(user);
	}

	@Override
	public Optional<User> getUser(int id) {
		
		return userRepository.findById(id);
	}

	@Override
	public List<User> getAllUser() {
		
		return userRepository.findAll();
	}

	@Override
	public void deleteUser(int id) {
		userRepository.deleteById(id);
		
	}

	@Override
	public User modifyUser(User user) {
	
		return null;
	}

	@Override
	public void modifyUser(int id) {
		
		
	}

	@Override
	public void join(UserDTO userDTO) {
		String password=userDTO.getPassword();
		String encodedPassword = bCryptPasswordEncoder.encode(password);
		userDTO.setPassword(encodedPassword);
		userRepository.save(userDTO.setUser());
		
	}

	@Override
	public User findById(int leaderId) {
		Optional<User> optUser = userRepository.findById(leaderId);
		User user = optUser.orElseThrow(() -> new IllegalArgumentException("유저 없음"));
		return user;
	}

	
}
