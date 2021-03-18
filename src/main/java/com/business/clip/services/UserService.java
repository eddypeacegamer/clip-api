package com.business.clip.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.business.clip.mappers.UserMapper;
import com.business.clip.models.dto.UserDto;
import com.business.clip.repositories.UserRepository;

/**
 * @author Eddy
 */
@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	@Autowired
	private UserMapper mapper;
	
	public List<UserDto> getAllUsers() {
		return mapper.getDtosFromEntities(repository.findAll());
	}

	public UserDto getUserById(int id) {
		return mapper.getDtoFromEntity(
				repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
						String.format("User with the id  %d does not exists", id))));
	}


}
