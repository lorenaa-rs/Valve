package com.valve.api.controller;

import com.valve.api.entities.PlayerGameHours;
import com.valve.api.services.PlayerGameHoursService;
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
}