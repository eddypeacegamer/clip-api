package com.business.clip.controllers;

import static org.junit.Assert.fail;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.business.clip.models.dto.UserDto;
import com.business.clip.services.UserService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {

	@MockBean
	private UserService service;

	@Autowired
	private MockMvc mockMvc;

	private static UserDto userDto;
	private static List<UserDto> userDtos;
	private static final String GET_USER_BY_ID_ENDPOINT = "/api/v1/users/{id}";
	private static final String GET_USERS_ENDPOINT = "/api/v1/users";

	@BeforeClass
	public static void init() {
		try {
			userDto = new ObjectMapper().registerModule(new JavaTimeModule())
					.readValue(UserDto.class.getClassLoader().getResource("user.json"), UserDto.class);
			userDtos = new ObjectMapper().readValue(Paths.get("src/test/resources/users.json").toFile(),
					new TypeReference<List<UserDto>>() {
					});

		} catch (IOException e) {
			fail();
		}
	}

	@Test
	public void getUserById() throws Exception {
		doReturn(userDto).when(service).getUserById(ArgumentMatchers.eq(userDto.getId()));

		this.mockMvc.perform(get(GET_USER_BY_ID_ENDPOINT, userDto.getId()).accept(MediaType.APPLICATION_JSON))
				.andDo(print()).andExpect(status().isOk()).andExpect(jsonPath("$.name").exists());
	}

	@Test
	public void getAllUsers() throws Exception {
		doReturn(userDtos).when(service).getAllUsers();
		this.mockMvc.perform(get(GET_USERS_ENDPOINT).accept(MediaType.APPLICATION_JSON)).andDo(print())
				.andExpect(status().isOk());
	}

}
