package com.project.vcs.service.mapper;

import com.project.vcs.dto.CasterDTO;
import com.project.vcs.dto.TeamDetailDTO;
import com.project.vcs.entity.Caster;
import com.project.vcs.entity.TeamDetail;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TeamDetailMapper {
    TeamDetailMapper INSTANCE = Mappers.getMapper(TeamDetailMapper.class);
    TeamDetailDTO toDTO(TeamDetail teamDetail);
    List<TeamDetailDTO> toDTOs(List<TeamDetail> teamDetails);
}
