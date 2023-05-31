package com.project.vcs.service.mapper;

import com.project.vcs.dto.UserDTO;
import com.project.vcs.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDTO mapToDto(User user);

    List<UserDTO> mapToDtos(List<User> users);
}
