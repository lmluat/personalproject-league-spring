package com.project.vcs.service.mapper;

import com.project.vcs.dto.CasterDTO;
import com.project.vcs.dto.TournamentDTO;
import com.project.vcs.entity.Caster;
import com.project.vcs.entity.Tournament;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TournamentMapper {
    TournamentMapper INSTANCE = Mappers.getMapper(TournamentMapper.class);
    TournamentDTO toDTO(Tournament tournament);
    List<TournamentDTO> toDTOs(List<Tournament> tournaments);
}
