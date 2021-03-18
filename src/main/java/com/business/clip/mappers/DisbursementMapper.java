package com.business.clip.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import com.business.clip.models.dto.DisbursementDto;
import com.business.clip.models.entities.Disbursement;

/**
 * @author Eddy
 */
@Mapper
public interface DisbursementMapper {
	DisbursementDto getDtoFromEntity(Disbursement entity);
	Disbursement getEntityFromDto(DisbursementDto dto);
	List<DisbursementDto> getDtosFromEntities(List<Disbursement> entity);
}
