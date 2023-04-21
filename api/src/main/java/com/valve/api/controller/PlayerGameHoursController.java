package com.valve.api.controller;

import com.valve.api.dto.PlayerGameHoursDto;
import com.valve.api.dto.*;
import com.valve.api.entities.*;
import com.valve.api.services.*;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/player-game-hours")
public class PlayerGameHoursController {

    private final PlayerGameHoursService playerGameHourService;
    private final PlayerService playerService;
    private final GameService gameService;

    public PlayerGameHoursController(PlayerGameHoursService playerGameHourService, PlayerService playerService, GameService gameService) {
        this.playerGameHourService = playerGameHourService;
        this.playerService = playerService;
        this.gameService = gameService;
    }

    @PostMapping("/create")
    public String addPlayerGameHours(@RequestBody PlayerGameHoursDto playerGameHoursDTO) {
        PlayerGameHours playerGameHours = new PlayerGameHours();
        playerGameHours.setHours(playerGameHoursDTO.getHours());
        playerGameHours.setPlayer(playerService.getPlayerById(playerGameHoursDTO.getPlayerId()));
        playerGameHours.setGame(gameService.getGameById(playerGameHoursDTO.getGameId()));
        playerGameHourService.createPlayerGameHours(playerGameHours.getPlayer(), playerGameHours.getGame(), playerGameHours.getHours());
        return playerGameHours.getHours() +" horas agregadas al jugador: " + playerGameHours.getPlayer().getUsername()+
                "del juego: " + playerGameHours.getGame().getName();
    }

    @DeleteMapping("/deleteHours")
    public ResponseEntity<Integer> deletePlayerGameHours(@RequestBody PlayerGameHoursDto playerGameHoursDTO) {

        Player player = playerService.getPlayerById(playerGameHoursDTO.getPlayerId());
        Game game = gameService.getGameById(playerGameHoursDTO.getGameId());
        Integer totalHours = playerGameHourService.deletePlayerGameHours(player, game, playerGameHoursDTO.getHours());
        return ResponseEntity.ok(totalHours);
    }

    
    @PutMapping("/updateHours")
    public ResponseEntity<Integer> updateHours(@RequestBody PlayerGameHoursDto playerGameHoursDTO) {

        Player player = playerService.getPlayerById(playerGameHoursDTO.getPlayerId());
        Game game = gameService.getGameById(playerGameHoursDTO.getGameId());
        Integer totalHours = playerGameHourService.updateHours(player, game, playerGameHoursDTO.getHours());
        return ResponseEntity.ok(totalHours);
    }

    @GetMapping("/top10players/{gameName}")
    public ResponseEntity<List<TopPlayerForGameDto>> getTop10PlayersByGame(@PathVariable String gameName) {
        List<TopPlayerForGameDto> topPlayersList = playerGameHourService.getTop10PlayersByGame(gameName);
        return ResponseEntity.ok(topPlayersList);
    }

    @GetMapping("/top10games/{userName}")
    public ResponseEntity<List<TopGameForPlayerDto>> getTop10GamesByPlayerId(@PathVariable String userName) {
        List<TopGameForPlayerDto> topGameList = playerGameHourService.getTop10GamesByPlayerId(userName);
        return ResponseEntity.ok(topGameList);
    }

    @GetMapping("/top10games")
    public ResponseEntity<List<TopGamesDto>> getTop10Games() {
        List<TopGamesDto> topGameList = playerGameHourService.getTop10Games();
        return ResponseEntity.ok(topGameList);
    }

    @GetMapping("/top10players")
    public ResponseEntity<List<TopPlayersDto>> getTop10Players() {
        List<TopPlayersDto> topPlayersList = playerGameHourService.getTop10players();
        return ResponseEntity.ok(topPlayersList);
    }

}
