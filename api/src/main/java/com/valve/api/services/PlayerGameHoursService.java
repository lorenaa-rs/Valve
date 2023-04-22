package com.valve.api.services;

import com.valve.api.dto.*;
import com.valve.api.entities.*;
import com.valve.api.repositories.*;
import java.util.Collections;
import java.util.List;
import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
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

    public void createPlayerGameHours(Player player, Game game, Integer hours) {
        PlayerGameHours existingRecord = getPlayerGameHours(player, game);
        if (existingRecord == null) {
            PlayerGameHours newRecord = new PlayerGameHours();
            newRecord.setPlayer(player);
            newRecord.setGame(game);
            newRecord.setHours(hours);
            playerGameHoursRepository.save(newRecord);
        } else {
            existingRecord.setHours(existingRecord.getHours() + hours);
            playerGameHoursRepository.save(existingRecord);
        }
    }

    private PlayerGameHours getPlayerGameHours(Player player, Game game) {
        return playerGameHoursRepository.findByPlayerAndGame(player, game);
    }

    public PlayerGameHours savePlayerGameHours(PlayerGameHours playerGameHours) {
        return playerGameHoursRepository.save(playerGameHours);
    }

    public Integer updateHours(Player player, Game game, Integer hoursUpdate) {
        PlayerGameHours playerGameHoursList = playerGameHoursRepository.findByPlayerAndGame(player, game);
        playerGameHoursList.setHours(hoursUpdate);
        playerGameHoursRepository.save(playerGameHoursList);
        return hoursUpdate;
    }

    public Integer deletePlayerGameHours(Player player, Game game, Integer hoursToDelete) {
        PlayerGameHours playerGameHoursList = playerGameHoursRepository.findByPlayerAndGame(player, game);
        if (playerGameHoursList == null) {
            return 0;
        }
        Integer totalHours = playerGameHoursList.getHours();
        if (totalHours <= hoursToDelete) {
            playerGameHoursRepository.delete(playerGameHoursList);
            return 0;
        } else {
            totalHours -= hoursToDelete;
            playerGameHoursList.setHours(totalHours);
            playerGameHoursRepository.save(playerGameHoursList);
            return totalHours;
        }
    }

    public List<PlayerGameHours> findByPlayerId(Long playerId) {
        return playerGameHoursRepository.findByPlayerId(playerId);
    }

    public List<PlayerGameHours> findByGameId(Long gameId) {
        return playerGameHoursRepository.findByGameId(gameId);
    }

    public PlayerGameHours findById(Long id) {
        return playerGameHoursRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("PlayerGameHours not found with id: " + id));
    }

    @Transactional
    public List<TopPlayerForGameDto> getTop10PlayersByGame(String gameName) {
        Game game = gameRepository.findByName(gameName);
        List<TopPlayerForGameDto> playerGameHoursList = playerGameHoursRepository
                .findTop10PlayersSumHoursByGameOrderByHoursDesc(game.getId());
       if (playerGameHoursList.isEmpty()) {
            return Collections.emptyList();
        } else if (playerGameHoursList.size() < 10) {
            return playerGameHoursList;
        }
        return playerGameHoursList.subList(0, 10);
    
    }

    @Transactional
    public List<TopGameForPlayerDto> getTop10GamesByPlayerId(String playerId) {
        Player player = playerRepository.getByUsername(playerId);
        List<TopGameForPlayerDto> playerGameHoursList = playerGameHoursRepository
                .findTop10GamesByPlayerIdOrderByHoursDesc(player.getId());
       if (playerGameHoursList.isEmpty()) {
            return Collections.emptyList();
        } else if (playerGameHoursList.size() < 10) {
            return playerGameHoursList;
        }
        return playerGameHoursList.subList(0, 10);
    }
    @Transactional
    public List<TopGamesDto> getTop10Games() {
        List<TopGamesDto> playerGameHoursList = playerGameHoursRepository.findTop10GamesByHoursDesc();
        if (playerGameHoursList.isEmpty()) {
            return Collections.emptyList();
        } else if (playerGameHoursList.size() < 10) {
            return playerGameHoursList;
        }
        return playerGameHoursList.subList(0, 10);
    }

    @Transactional
    public List<TopPlayersDto> getTop10players() {
        List<TopPlayersDto> playerGameHoursList = playerGameHoursRepository.findTop10PlayersByHoursDesc();
        if (playerGameHoursList.isEmpty()) {
            return Collections.emptyList();
        } else if (playerGameHoursList.size() < 10) {
            return playerGameHoursList;
        }
        return playerGameHoursList.subList(0, 10);
    }


}
