package com.project.vcs.service.mapper;

import com.project.vcs.dto.MatchDTO;
import com.project.vcs.dto.custom.MatchScheduleTournamentDTO;
import com.project.vcs.dto.custom.MatchUpdateDTO;
import com.project.vcs.entity.Match;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MatchMapper {
    MatchMapper INSTANCE = Mappers.getMapper(MatchMapper.class);

    @Mapping(target="casterName",source="caster.firstName")
    @Mapping(target="tournamentName",source="tournament.tournamentName")
    @Mapping(target="id",source="id")
    MatchDTO toDTO(Match match);

    List<MatchDTO> toDTOs(List<Match> matchList);
    @Mapping(target="location",source="location")
    @Mapping(target="date",source="date")
    MatchUpdateDTO toUpdateDTO(Match match);

    List<MatchUpdateDTO> toUpdateDTOs(List<Match> matchList);
}
