package com.project.vcs.service.mapper;

import com.project.vcs.dto.PlayerDetailDTO;
import com.project.vcs.entity.PlayerDetail;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PlayerDetailMapper {
    PlayerDetailMapper INSTANCE = Mappers.getMapper(PlayerDetailMapper.class);

    @Mapping(target="ingameName",source="player.ingameName")
    @Mapping(target="teamName",source="teamDetail.team.teamName")
    @Mapping(target="tournamentName",source="teamDetail.tournament.tournamentName")
    PlayerDetailDTO toDTO(PlayerDetail playerDetail);

    List<PlayerDetailDTO> toDTOs(List<PlayerDetail> playerDetailList);
}
