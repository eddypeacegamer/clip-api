package com.business.clip.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.business.clip.models.entities.Disbursement;

/**
 * @author Eddy
 */
@Repository
public interface DisbursementRepository  extends JpaRepository<Disbursement, Integer> {

}
