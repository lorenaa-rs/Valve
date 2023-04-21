package com.valve.api.services;

import com.valve.api.entities.Player;
import com.valve.api.repositories.PlayerRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    public Player getPlayerById(Long id) {
        return playerRepository.findById(id).orElse(null);
    }

    public String createPlayer(Player player) {
        if (playerRepository.existsByUsername(player.getUsername())) {
            return ("Nombre de usuario ya existente.");
        }
        if (playerRepository.existsByEmail(player.getEmail())) {
            return ("Correo electrónico ya existente.");
        }
        Player playerAnswer = playerRepository.save(player);
        if (playerAnswer != null) {
            return "Usuario registrado correctamente";
        }
        return "Error al registrar usuario";
    }

    public Player updatePlayer(Long id, Player player) {
        Player existingPlayer = playerRepository.findById(id).orElse(null);
        if (existingPlayer != null) {
            existingPlayer.setEmail(player.getEmail());
            existingPlayer.setFirstName(player.getFirstName());
            existingPlayer.setLastName(player.getLastName());
            existingPlayer.setUsername(player.getUsername());
            existingPlayer.setAge(player.getAge());
            existingPlayer.setGender(player.getGender());
            return playerRepository.save(existingPlayer);
        }
        return null;
    }

    public boolean deletePlayer(Long id) {
        playerRepository.deleteById(id);
        return true;
    }

}
