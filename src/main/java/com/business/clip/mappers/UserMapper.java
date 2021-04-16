package com.business.clip.mappers;

import java.util.List;

import com.business.clip.models.dto.UserDto;
import com.business.clip.models.entities.User;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

/**
 * @author Eddy
 */
@Mapper
public interface UserMapper {
	UserDto getDtoFromEntity(User entity);
	List<UserDto> getDtosFromEntities(List<User> entity);
}
