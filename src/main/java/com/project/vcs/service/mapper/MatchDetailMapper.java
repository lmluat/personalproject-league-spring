package com.project.vcs.service.mapper;

import com.project.vcs.dto.MatchDetailDTO;
import com.project.vcs.entity.MatchDetail;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MatchDetailMapper {
    MatchDetailMapper INSTANCE = Mappers.getMapper(MatchDetailMapper.class);
    @Mapping(target = "teamOne",source="teamOne.team.teamName")
    @Mapping(target = "teamTwo",source="teamTwo.team.teamName")
    @Mapping(target = "mostValuablePlayer",source="mostValuablePlayer.player.ingameName")
    @Mapping(target = "matchId",source="match.id")
    MatchDetailDTO toDTO(MatchDetail matchDetail);
    List<MatchDetailDTO> toDTOs(List<MatchDetail> matchDetailList);
}
