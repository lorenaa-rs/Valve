package com.valve.api.services;

import com.valve.api.dto.PlayerGameHoursDto;
import com.valve.api.entities.Game;
import com.valve.api.entities.PlayerGameHours;
import com.valve.api.repositories.GameRepository;
import com.valve.api.repositories.PlayerGameHoursRepository;
import java.util.List;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerGameHoursService {

    @Autowired
    private PlayerGameHoursRepository playerGameHoursRepository;
    @Autowired
    private GameRepository gameRepository;

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

    public List<PlayerGameHours> findByPlayerId(Long playerId) {
        return playerGameHoursRepository.findByPlayerId(playerId);
    }

    public List<PlayerGameHours> findByGameId(Long gameId) {
        return playerGameHoursRepository.findByGameId(gameId);
    }

    @Transactional
    public List<PlayerGameHoursDto> getTop10PlayersByGame(String gameName) {
        Game game = gameRepository.findByName(gameName);
        List<PlayerGameHours> playerGameHoursList = playerGameHoursRepository.findTop10ByGameOrderByHoursDesc(game);
        return playerGameHoursList.stream().map(PlayerGameHoursDto::new).collect(Collectors.toList());
    }

}
