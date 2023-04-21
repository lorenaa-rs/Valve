package com.valve.api.controller;

import com.valve.api.entities.Game;
import com.valve.api.services.GameService;
import java.util.List;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping("/games")
    public List<Game> getAllGames() {
        return gameService.getAllGames();
    }

    @GetMapping("/games/{id}")
    public Game getGameById(@PathVariable Long id) {
        return gameService.getGameById(id);
    }

    @PostMapping("/game")
    public Game createGame(@RequestBody Game game) {
        return gameService.createGame(game);
    }

}
