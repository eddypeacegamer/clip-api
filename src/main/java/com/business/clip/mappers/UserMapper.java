package com.business.clip.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import com.business.clip.models.dto.UserDto;
import com.business.clip.models.entities.User;

/**
 * @author Eddy
 */
@Mapper
public interface UserMapper {
	UserDto getDtoFromEntity(User entity);
	List<UserDto> getDtosFromEntities(List<User> entity);
}
