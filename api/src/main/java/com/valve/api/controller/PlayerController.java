package com.valve.api.controller;

import com.valve.api.entities.Player;
import com.valve.api.services.PlayerService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PlayerController {

    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("/players")
    public List<Player> getAllPlayers() {
        return playerService.getAllPlayers();
    }

    @GetMapping("/players/{id}")
    public Player getPlayerById(@PathVariable Long id) {
        return playerService.getPlayerById(id);
    }

    @PostMapping("/players")
    public Player createPlayer(@RequestBody Player player) {
        return playerService.createPlayer(player);
    }

}
