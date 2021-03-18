package com.business.clip.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.business.clip.models.entities.Transaction;

/**
 * @author Eddy
 */
@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

	List<Transaction> findTransactionByClipUser(Integer clipUser);
	List<Transaction> findTransactionByDisbursed(Boolean disbursed);
}
