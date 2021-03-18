package com.business.clip.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.business.clip.models.dto.DisbursementDto;
import com.business.clip.models.dto.TransactionDto;
import com.business.clip.services.TransactionService;

/**
 * @author Eddy
 */
@RestController
@RequestMapping("/api/v1")
public class TransactionController {

	@Autowired
	private TransactionService service;
	
	@GetMapping("/transactions")
	public ResponseEntity<List<TransactionDto>> getTransactionsByUser(@RequestParam(name = "clip_user", required = true) Integer clipUser) {
		return new ResponseEntity<>(service.getTransactionsByUser(clipUser), HttpStatus.OK);
	}
	
	@PostMapping("/transactions")
	public ResponseEntity<TransactionDto> postTransaction(@RequestBody @Valid TransactionDto transactionDto) {
		return new ResponseEntity<>(service.postTransaction(transactionDto), HttpStatus.CREATED);
	}
	
	@PostMapping("/disbursement")
	public ResponseEntity<List<DisbursementDto>> disburse() {
		return new ResponseEntity<>(service.disburse(), HttpStatus.CREATED);
	}

	@GetMapping("/disbursement")
	public ResponseEntity<List<DisbursementDto>> getDisbursements() {
		return new ResponseEntity<>(service.getDisbursements(), HttpStatus.OK);
	}
	
}
