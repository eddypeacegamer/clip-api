package com.business.clip.services;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.business.clip.mappers.DisbursementMapper;
import com.business.clip.mappers.TransactionMapper;
import com.business.clip.models.dto.DisbursementDto;
import com.business.clip.models.dto.TransactionDto;
import com.business.clip.models.entities.Disbursement;
import com.business.clip.models.entities.Transaction;
import com.business.clip.repositories.DisbursementRepository;
import com.business.clip.repositories.TransactionRepository;

/**
 * @author Eddy
 */
@Service
public class TransactionService {

	@Autowired
	private UserService userService;

	@Autowired
	private TransactionRepository repository;

	@Autowired
	private DisbursementRepository disbursementRepository;

	@Autowired
	private TransactionMapper mapper;

	@Autowired
	private DisbursementMapper disbursementMapper;

	public List<TransactionDto> getTransactionsByUser(Integer clipUSer) {
		return mapper.getDtosFromEntities(repository.findTransactionByClipUser(clipUSer));
	}

	public TransactionDto postTransaction(TransactionDto dto) {
		userService.getUserById(dto.getClipUser());
		dto.setDisbursed(false);
		return mapper.getDtoFromEntity(repository.save(mapper.getEntityFromDto(dto)));
	}

	@Transactional(rollbackOn = { DataAccessException.class, SQLException.class })
	public List<DisbursementDto> disburse() {
		List<Transaction> transactions = repository.findTransactionByDisbursed(false);
		Map<Integer, List<Transaction>> map = transactions.stream()
				.collect(Collectors.groupingBy(Transaction::getClipUser));
		List<DisbursementDto> disbursements = new ArrayList<>();
		for (Integer id : map.keySet()) {
			BigDecimal amount = BigDecimal.ZERO;
			for (Transaction transaction : map.get(id)) {
				amount = amount.add(transaction.getAmount());
				transaction.setDisbursed(true);
				repository.save(transaction);
			}
			disbursements.add(
					disbursementMapper.getDtoFromEntity((disbursementRepository.save(new Disbursement(amount, id)))));
		}
		return disbursements;
	}

	public List<DisbursementDto> getDisbursements() {
		return disbursementMapper.getDtosFromEntities(disbursementRepository.findAll());
	}

}
