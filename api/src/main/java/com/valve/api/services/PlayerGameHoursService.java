package com.valve.api.services;

import com.valve.api.entities.PlayerGameHours;
import com.valve.api.repositories.PlayerGameHoursRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerGameHoursService {

    @Autowired
    private PlayerGameHoursRepository playerGameHoursRepository;

    public List<PlayerGameHours> getAllPlayerGameHours() {
        return playerGameHoursRepository.findAll();
    }

    public List<PlayerGameHours> getPlayerGameHoursByPlayerId(Long playerId) {
        return playerGameHoursRepository.findByPlayerId(playerId);
    }

    public List<PlayerGameHours> getPlayerGameHoursByGameId(Long gameId) {
        return playerGameHoursRepository.findByGameId(gameId);
    }

    public PlayerGameHours createPlayerGameHours(PlayerGameHours playerGameHours) {
        return playerGameHoursRepository.save(playerGameHours);
    }

    public PlayerGameHours updatePlayerGameHours(Long id, PlayerGameHours playerGameHours) {
        PlayerGameHours existingPlayerGameHours = playerGameHoursRepository.findById(id).orElse(null);
        if (existingPlayerGameHours != null) {
            existingPlayerGameHours.setHours(playerGameHours.getHours());
            existingPlayerGameHours.setPlayer(playerGameHours.getPlayer());
            existingPlayerGameHours.setGame(playerGameHours.getGame());
            return playerGameHoursRepository.save(existingPlayerGameHours);
        }
        return null;
    }

    public boolean deletePlayerGameHours(Long id) {
        playerGameHoursRepository.deleteById(id);
        return true;
    }

}
