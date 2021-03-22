package com.business.clip.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.business.clip.mappers.DisbursementMapper;
import com.business.clip.mappers.TransactionMapper;
import com.business.clip.models.dto.DisbursementDto;
import com.business.clip.models.dto.TransactionDto;
import com.business.clip.models.dto.UserDto;
import com.business.clip.models.entities.Disbursement;
import com.business.clip.models.entities.Transaction;
import com.business.clip.repositories.DisbursementRepository;
import com.business.clip.repositories.TransactionRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@RunWith(MockitoJUnitRunner.class)
public class TransactionServiceTest {

	@Mock
	private UserService userService;

	@Mock
	private TransactionRepository repository;

	@Mock
	private DisbursementRepository disbursementRepository;

	@Mock
	private TransactionMapper mapper;

	@Mock
	private DisbursementMapper disbursementMapper;

	@InjectMocks
	private TransactionService service;

	private static List<DisbursementDto> disbursementDtos;
	private static List<Disbursement> disbursements;
	private static List<TransactionDto> transactionDtos;
	private static List<Transaction> transactions;
	private static Transaction transaction;
	private static TransactionDto transactionDto;
	private static UserDto userDto;

	@Before
	public void beforeEach() throws IOException {
		try {
			disbursementDtos = new ObjectMapper().readValue(Paths.get("src/test/resources/disbursements.json").toFile(),
					new TypeReference<List<DisbursementDto>>() {
					});
			disbursements = new ObjectMapper().readValue(Paths.get("src/test/resources/disbursements.json").toFile(),
					new TypeReference<List<Disbursement>>() {
					});
			transactionDtos = new ObjectMapper().readValue(Paths.get("src/test/resources/transactions.json").toFile(),
					new TypeReference<List<TransactionDto>>() {
					});
			transactions = new ObjectMapper().readValue(Paths.get("src/test/resources/transactions.json").toFile(),
					new TypeReference<List<Transaction>>() {
					});
			userDto = new ObjectMapper().registerModule(new JavaTimeModule())
					.readValue(UserDto.class.getClassLoader().getResource("user.json"), UserDto.class);
			transaction = new ObjectMapper().registerModule(new JavaTimeModule())
					.readValue(Transaction.class.getClassLoader().getResource("transaction.json"), Transaction.class);
			transactionDto = new ObjectMapper().registerModule(new JavaTimeModule()).readValue(
					TransactionDto.class.getClassLoader().getResource("transaction.json"), TransactionDto.class);

		} catch (IOException e) {
			fail();
		}
	}

	@Test
	public void getTransactionsByUser() {
		when(repository.findTransactionByClipUser(userDto.getId())).thenReturn(transactions);
		when(mapper.getDtosFromEntities(transactions)).thenReturn(transactionDtos);
		List<TransactionDto> dtos = service.getTransactionsByUser(userDto.getId());
		assertNotNull(dtos);
		assertNotEquals(dtos.size(), 0);
		assertEquals(dtos.size(), transactionDtos.size());
	}

	@Test
	public void postTransaction() {
		when(userService.getUserById(userDto.getId())).thenReturn(userDto);
		when(mapper.getEntityFromDto(transactionDto)).thenReturn(transaction);
		when(repository.save(transaction)).thenReturn(transaction);
		when(mapper.getDtoFromEntity(transaction)).thenReturn(transactionDto);
		TransactionDto dto = service.postTransaction(transactionDto);
		assertNotNull(dto);
		assertEquals(dto.getClipUser(), transactionDto.getClipUser());
	}

	@Test(expected = ResponseStatusException.class)
	public void postTransaction_userNotFound() {
		when(userService.getUserById(userDto.getId())).thenThrow(new ResponseStatusException(HttpStatus.NOT_FOUND));
		service.postTransaction(transactionDto);
	}
	
	@Test
	public void getDisbursements() {
		when(disbursementRepository.findAll()).thenReturn(disbursements);
		when(disbursementMapper.getDtosFromEntities(disbursements)).thenReturn(disbursementDtos);
		List<DisbursementDto> dtos=service.getDisbursements();
		assertNotNull(dtos);
		assertNotEquals(dtos.size(), 0);
		assertEquals(dtos.size(), disbursementDtos.size());
	}
	
}
