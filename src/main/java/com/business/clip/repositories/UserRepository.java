package com.business.clip.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.business.clip.models.entities.User;

/**
 * @author Eddy
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
