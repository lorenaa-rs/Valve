package com.valve.api.repositories;

import com.valve.api.entities.Game;
import com.valve.api.entities.Player;
import com.valve.api.entities.PlayerGameHours;
import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PlayerGameHoursRepository extends JpaRepository<PlayerGameHours, Long> {

    List<PlayerGameHours> findByPlayerId(Long playerId);
    
    List<PlayerGameHours> findByGameId(Long gameId);
    
    List<PlayerGameHours> findTop10ByGameOrderByHoursDesc(Game game);
    
//      // Obtener el top 10 de jugadores con más horas en determinado juego "x"
//    @Query("SELECT pgh.player, SUM(pgh.hours) FROM PlayerGameHours pgh WHERE pgh.game = :game GROUP BY pgh.player ORDER BY SUM(pgh.hours) DESC")
//    List<Object[]> findTopPlayersByGame(@Param("game") Game game, Pageable pageable);
//
//    // Obtener el top 10 de juegos con más horas para el jugador "y"
//    @Query("SELECT pgh.game, SUM(pgh.hours) FROM PlayerGameHours pgh WHERE pgh.player = :player GROUP BY pgh.game ORDER BY SUM(pgh.hours) DESC")
//    List<Object[]> findTopGamesByPlayer(@Param("player") Player player, Pageable pageable);
//
//    // Obtener el top 10 general, es decir, los jugadores con más horas acumuladas entre todos los juegos
//    @Query("SELECT pgh.player, SUM(pgh.hours) FROM PlayerGameHours pgh GROUP BY pgh.player ORDER BY SUM(pgh.hours) DESC")
//    List<Object[]> findTopPlayers(Pageable pageable);
//
//    // Obtener las horas de juego de un jugador para determinado juego
//    Optional<PlayerGameHours> findByPlayerAndGame(Player player, Game game);


}

