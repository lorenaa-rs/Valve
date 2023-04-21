package com.valve.api.services;

import com.valve.api.entities.Game;
import com.valve.api.repositories.GameRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    public List<Game> getAllGames() {
        return gameRepository.findAll();
    }

    public Game getGameById(Long id) {
        return gameRepository.findById(id).orElse(null);
    }

       public String createGame(Game game) {
        if (gameRepository.existsByName(game.getName())) {
            return ("Nombre de juego ya existente.");
        }
        Game gameAnswer = gameRepository.save(game);
        if (gameAnswer != null) {
            return "Juego registrado correctamente";
        }
        return "Error al registrar juego";
    }
     
 

    public Game updateGame(Long id, Game game) {
        Game existingGame = gameRepository.findById(id).orElse(null);
        if (existingGame != null) {
            existingGame.setName(game.getName());
            existingGame.setDescription(game.getDescription());
            existingGame.setReleaseDate(game.getReleaseDate());
            existingGame.setRating(game.getRating());
            return gameRepository.save(existingGame);
        }
        return null;
    }

    public boolean deleteGame(Long id) {
        gameRepository.deleteById(id);
        return true;
    }

}
