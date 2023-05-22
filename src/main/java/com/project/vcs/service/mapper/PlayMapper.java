package com.project.vcs.service.mapper;

import com.project.vcs.dto.PlayerDTO;
import com.project.vcs.entity.Play;
import com.project.vcs.entity.Player;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PlayMapper {
    PlayerMapper INSTANCE = Mappers.getMapper(PlayerMapper.class);
    PlayerDTO toDTO(Player player);
    List<PlayerDTO> toDTOs(List<Player> playerList);
}
