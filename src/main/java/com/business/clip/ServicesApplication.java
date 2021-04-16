package com.business.clip;

import com.business.clip.mappers.DisbursementMapper;
import com.business.clip.mappers.TransactionMapper;
import com.business.clip.mappers.UserMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


/**
 * @author Eddy
 */
@SpringBootApplication
public class ServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicesApplication.class, args);
	}

}
