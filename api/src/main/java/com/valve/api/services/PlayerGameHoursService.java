package com.valve.api.services;

import com.valve.api.dto.TopGameForPlayerDto;
import com.valve.api.dto.TopPlayerForGameDto;
import com.valve.api.entities.Game;
import com.valve.api.entities.Player;
import com.valve.api.entities.PlayerGameHours;
import com.valve.api.repositories.GameRepository;
import com.valve.api.repositories.PlayerGameHoursRepository;
import com.valve.api.repositories.PlayerRepository;
import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class PlayerGameHoursService {

    @Autowired
    private PlayerGameHoursRepository playerGameHoursRepository;
    @Autowired
    private GameRepository gameRepository;
    @Autowired
    private PlayerRepository playerRepository;

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
    public List<TopPlayerForGameDto> getTop10PlayersByGame(String gameName) {
        Game game = gameRepository.findByName(gameName);
        List<TopPlayerForGameDto> playerGameHoursList = playerGameHoursRepository.findTop10PlayersSumHoursByGameOrderByHoursDesc(game.getId())
                .subList(0, 10);
        return playerGameHoursList;
    }
    
    @Transactional
    public List<TopGameForPlayerDto> getTop10GamesByPlayerId(Long playerId) {
        Player player = playerRepository.getPlayerById(playerId);
        List<TopGameForPlayerDto> playerGameHoursList = playerGameHoursRepository
                .findTop10GamesByPlayerIdOrderByHoursDesc(player.getId());
        int numGames = playerGameHoursList.size();
        if (numGames < 10) {
            for (int i = numGames; i < 10; i++) {
                playerGameHoursList.add(new TopGameForPlayerDto("", 0));
            }
        }
        return playerGameHoursList.subList(0, 10);
    }


}
