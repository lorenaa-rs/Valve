package com.valve.api.controller;

import com.valve.api.dto.*;
import com.valve.api.entities.*;
import com.valve.api.services.*;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/player-game-hours")
public class PlayerGameHoursController {

    private final PlayerGameHoursService playerGameHourService;

    public PlayerGameHoursController(PlayerGameHoursService playerGameHourService) {
        this.playerGameHourService = playerGameHourService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> addPlayerGameHours(@RequestBody PlayerGameHours playerGameHours) {
        playerGameHourService.createPlayerGameHours(playerGameHours);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/update/{id}")
    public PlayerGameHours updatePlayerGameHours(@PathVariable Long id, @RequestBody PlayerGameHours playergameHours) {
        return playerGameHourService.updatePlayerGameHours(id, playergameHours);
    }

    @DeleteMapping("/{id}")
    public void deletePlayerGameHours(@PathVariable Long id) {
        playerGameHourService.deletePlayerGameHours(id);
    }

    @GetMapping("/top10players/{gameName}")
    public ResponseEntity<List<TopPlayerForGameDto>> getTop10PlayersByGame(@PathVariable String gameName) {
        List<TopPlayerForGameDto> topPlayersList = playerGameHourService.getTop10PlayersByGame(gameName);
        return ResponseEntity.ok(topPlayersList);
    }

    @GetMapping("/top10games/{playerId}")
   public ResponseEntity<List<TopGameForPlayerDto>> getTop10GamesByPlayerId(@PathVariable Long playerId){
        List<TopGameForPlayerDto> topGameList = playerGameHourService.getTop10GamesByPlayerId(playerId);
        return ResponseEntity.ok(topGameList);
   }
   
    @GetMapping("/top10games")
   public ResponseEntity<List<TopGamesDto>> getTop10Games(){
        List<TopGamesDto> topGameList = playerGameHourService.getTop10Games();
        return ResponseEntity.ok(topGameList);
   }
   
   @GetMapping("/top10players")
   public ResponseEntity<List<TopPlayersDto>> getTop10Players(){
        List<TopPlayersDto> topPlayersList = playerGameHourService.getTop10players();
        return ResponseEntity.ok(topPlayersList);
   }

}
