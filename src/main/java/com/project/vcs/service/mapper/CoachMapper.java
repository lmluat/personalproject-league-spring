package com.project.vcs.service.mapper;

import com.project.vcs.dto.CasterDTO;
import com.project.vcs.dto.CoachDTO;
import com.project.vcs.entity.Caster;
import com.project.vcs.entity.Coach;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CoachMapper {
    CoachMapper INSTANCE = Mappers.getMapper(CoachMapper.class);
    CoachDTO toDTO(Coach coach);
    List<CoachDTO> toDTOs(List<Coach> coaches);
}
