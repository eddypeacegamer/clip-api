package com.business.clip.controllers;

import static org.junit.Assert.fail;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
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

import com.business.clip.models.dto.DisbursementDto;
import com.business.clip.models.dto.TransactionDto;
import com.business.clip.services.TransactionService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

/**
 * @author Eddy
 */
@RunWith(SpringRunner.class)
@WebMvcTest(TransactionController.class)
public class TransactionControllerTest {

	@MockBean
	private TransactionService service;

	@Autowired
	private MockMvc mockMvc;

	private static TransactionDto transactionDto;
	private static List<TransactionDto> transactionDtos;
	private static List<DisbursementDto> disbursementDtos;
	private static final String TRANSACTIONS_ENDPOINT = "/api/v1/transactions";
	private static final String DISBURSEMENT_ENDPOINT = "/api/v1/disbursement";

	@BeforeClass
	public static void init() {
		try {
			transactionDto = new ObjectMapper().registerModule(new JavaTimeModule()).readValue(
					TransactionDto.class.getClassLoader().getResource("transaction.json"), TransactionDto.class);
			transactionDtos = new ObjectMapper().readValue(Paths.get("src/test/resources/transactions.json").toFile(),
					new TypeReference<List<TransactionDto>>() {
					});
			disbursementDtos = new ObjectMapper().readValue(Paths.get("src/test/resources/disbursements.json").toFile(),
					new TypeReference<List<DisbursementDto>>() {
					});

		} catch (IOException e) {
			fail();
		}
	}

	@Test
	public void getTransactionsByUser() throws Exception {
		doReturn(transactionDtos).when(service).getTransactionsByUser(ArgumentMatchers.eq(1));
		this.mockMvc.perform(get(TRANSACTIONS_ENDPOINT).param("clip_user", "1").accept(MediaType.APPLICATION_JSON))
				.andDo(print()).andExpect(status().isOk());
	}

	@Test
	public void postTransaction() throws Exception {
		doReturn(transactionDto).when(service).postTransaction(transactionDto);
		this.mockMvc.perform(post(TRANSACTIONS_ENDPOINT).contentType(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(transactionDto)).accept(MediaType.APPLICATION_JSON))
				.andDo(print()).andExpect(status().isCreated());
	}

	@Test
	public void disburse() throws Exception {
		doReturn(disbursementDtos).when(service).disburse();
		this.mockMvc.perform(post(DISBURSEMENT_ENDPOINT).accept(MediaType.APPLICATION_JSON)).andDo(print())
				.andExpect(status().isCreated());
	}

	@Test
	public void getDisbursements() throws Exception {
		doReturn(disbursementDtos).when(service).getDisbursements();
		this.mockMvc.perform(get(DISBURSEMENT_ENDPOINT).accept(MediaType.APPLICATION_JSON)).andDo(print())
				.andExpect(status().isOk());
	}

}
