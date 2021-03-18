package com.business.clip.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.server.ResponseStatusException;

import com.business.clip.mappers.UserMapper;
import com.business.clip.models.dto.UserDto;
import com.business.clip.models.entities.User;
import com.business.clip.repositories.UserRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@RunWith(MockitoJUnitRunner.class)
public class UserServicesTest {

	@Mock
	private UserRepository repository;

	@Mock
	private UserMapper mapper;

	@InjectMocks
	private UserService service;

	private static UserDto userDto;
	private static User user;
	private static List<UserDto> userDtos;
	private static List<User> users;

	@Before
	public void beforeEach() throws IOException {
		try {
			userDto = new ObjectMapper().registerModule(new JavaTimeModule())
					.readValue(UserDto.class.getClassLoader().getResource("user.json"), UserDto.class);
			user = new ObjectMapper().registerModule(new JavaTimeModule())
					.readValue(User.class.getClassLoader().getResource("user.json"), User.class);
			userDtos = new ObjectMapper().readValue(Paths.get("src/test/resources/users.json").toFile(),
					new TypeReference<List<UserDto>>() {
					});
			users = new ObjectMapper().readValue(Paths.get("src/test/resources/users.json").toFile(),
					new TypeReference<List<User>>() {
					});

		} catch (IOException e) {
			fail();
		}
	}

	@Test
	public void getAllUsers() {
		when(repository.findAll()).thenReturn(users);
		when(mapper.getDtosFromEntities(users)).thenReturn(userDtos);
		List<UserDto> dtos = service.getAllUsers();
		assertNotNull(dtos);
		assertNotEquals(dtos.size(), 0);
		assertEquals(dtos.size(), userDtos.size());
	}
	
	@Test
	public void getUserById() {
		when(repository.findById(user.getId())).thenReturn(Optional.of(user));
		when(mapper.getDtoFromEntity(user)).thenReturn(userDto);
		UserDto dto = service.getUserById(user.getId());
		assertNotNull(dto);
		assertEquals(dto.getId(), user.getId());
		assertEquals(dto.getName(), user.getName());
	}
	
	
	@Test(expected =ResponseStatusException.class)
	public void getUserByIdError() {
		when(repository.findById(user.getId())).thenReturn(Optional.empty());
		service.getUserById(user.getId());
	}

}
