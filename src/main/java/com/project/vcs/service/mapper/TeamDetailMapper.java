package com.project.vcs.service.mapper;

//import com.project.vcs.dto.CasterDTO;
//import com.project.vcs.dto.TeamDetailDTO;
//import com.project.vcs.dto.custom.TeamDetailCustomDTO;
//import com.project.vcs.entity.Caster;
//import com.project.vcs.entity.TeamDetail;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TeamDetailMapper {
    TeamDetailMapper INSTANCE = Mappers.getMapper(TeamDetailMapper.class);
//    @Mapping(target = "tournamentName", source = "tournament.tournamentName")
//    @Mapping(target = "teamName", source = "team.teamName")
//    @Mapping(target = "coachName", source = "coach.firstName")
////    TeamDetailCustomDTO toDTO(TeamDetail teamDetail);
////    List<TeamDetailCustomDTO> toDTOs(List<TeamDetail> teamDetails);
}
