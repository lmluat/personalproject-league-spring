package com.project.vcs.service;

import com.project.vcs.dto.PlayerDTO;
import com.project.vcs.entity.Player;
import com.project.vcs.repository.PlayerRepository;
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
    public void deletePlayer(Long id){
        playerRepository.deleteById(id);
    }
}
