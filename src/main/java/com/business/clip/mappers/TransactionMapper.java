package com.business.clip.mappers;

import java.util.List;


import com.business.clip.models.dto.TransactionDto;
import com.business.clip.models.entities.Transaction;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

/**
 * @author Eddy
 */
@Mapper
public interface TransactionMapper {
	TransactionDto getDtoFromEntity(Transaction entity);
	Transaction getEntityFromDto(TransactionDto dto);
	List<TransactionDto> getDtosFromEntities(List<Transaction> entity);
}
