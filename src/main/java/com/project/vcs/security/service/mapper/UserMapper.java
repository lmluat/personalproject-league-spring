package com.project.vcs.security.service.mapper;

import com.project.vcs.security.entity.User;
import com.project.vcs.security.service.dto.UserDTO;
import com.project.vcs.security.service.dto.custom.UserCustomDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDTO mapToDto(User user);
    UserCustomDTO mapToCustomDTO(User user);

    List<UserDTO> mapToDtos(List<User> users);
}
