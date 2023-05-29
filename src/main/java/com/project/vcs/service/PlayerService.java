package com.project.vcs.service;

import com.project.vcs.dto.PlayerDTO;
import com.project.vcs.entity.Player;
import com.project.vcs.exception.DemoException;
import com.project.vcs.repository.PlayerRepository;
import com.project.vcs.service.mapper.PlayerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlayerService {
    private final PlayerRepository playerRepository;
    public List<Player> getAllPlayer(){
        return playerRepository.findAll();
    }
    public Player createPlayer(PlayerDTO playerDTO){
        Player player = Player.builder()
                .firstName(playerDTO.getFirstName())
                .middleName(playerDTO.getMiddleName())
                .lastName(playerDTO.getLastName())
                .dob(playerDTO.getDob())
                .phoneNumber(playerDTO.getPhoneNumber())
                .homeTown(playerDTO.getHometown())
                .ingameName(playerDTO.getIngameName())
                .build();
        return playerRepository.save(player);
    }
    public PlayerDTO updatePlayer(PlayerDTO playerDTO, Long playerId){
        Player player = playerRepository.findById(playerId).orElseThrow(DemoException::PlayerNotFound);

        if(playerDTO.getLastName() != null){
            player.setLastName(playerDTO.getLastName());
        }
        if(playerDTO.getMiddleName() != null){
            player.setMiddleName(playerDTO.getMiddleName());
        }
        if(playerDTO.getFirstName() != null){
            player.setFirstName(playerDTO.getFirstName());
        }
        if(playerDTO.getHometown() != null){
            player.setHomeTown(playerDTO.getHometown());
        }
        if(playerDTO.getIngameName() != null){
            player.setIngameName(playerDTO.getIngameName());
        }
        if(playerDTO.getDob() != null){
            player.setDob(playerDTO.getDob());
        }
         playerRepository.save(player);

        return PlayerMapper.INSTANCE.toDTO(player);
    }
    public void deletePlayer(Long id){
        playerRepository.deleteById(id);
    }
}
