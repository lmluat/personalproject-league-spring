package com.project.vcs.service.mapper;

import com.project.vcs.dto.CasterDTO;
import com.project.vcs.dto.TeamDTO;
import com.project.vcs.entity.Caster;
import com.project.vcs.entity.Team;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TeamMapper {
    TeamMapper INSTANCE = Mappers.getMapper(TeamMapper.class);
    TeamDTO toDTO(Team team);
    List<TeamDTO> toDTOs(List<Team> teams);
}
