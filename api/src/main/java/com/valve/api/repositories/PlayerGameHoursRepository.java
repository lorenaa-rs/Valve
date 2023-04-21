package com.valve.api.repositories;

import com.valve.api.dto.*;
import com.valve.api.entities.PlayerGameHours;
import java.util.List;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

public interface PlayerGameHoursRepository extends JpaRepository<PlayerGameHours, Long> {

    List<PlayerGameHours> findByPlayerId(Long playerId);

    List<PlayerGameHours> findByGameId(Long gameId);

    @Query("SELECT NEW com.valve.api.dto.TopPlayerForGameDto(p.player.firstName, CAST(SUM(p.hours) AS int))\n"
            + "FROM com.valve.api.entities.PlayerGameHours p \n"
            + "WHERE p.game.id = :game \n"
            + "GROUP BY p.player \n"
            + "ORDER BY SUM(p.hours) DESC")
    List<TopPlayerForGameDto> findTop10PlayersSumHoursByGameOrderByHoursDesc(@Param("game") Long game);

    @Query("SELECT NEW com.valve.api.dto.TopGameForPlayerDto(g.name, CAST(SUM(p.hours) AS int)) "
            + "FROM PlayerGameHours p "
            + "JOIN p.game g "
            + "WHERE p.player.id = :playerId "
            + "GROUP BY g.id, g.name "
            + "ORDER BY SUM(p.hours) DESC")
    List<TopGameForPlayerDto> findTop10GamesByPlayerIdOrderByHoursDesc(@Param("playerId") Long playerId);

    @Query("SELECT NEW com.valve.api.dto.TopGamesDto(g.name, CAST(SUM(p.hours) AS int)) "
        + "FROM PlayerGameHours p "
        + "JOIN p.game g "
        + "GROUP BY g.id, g.name "
        + "ORDER BY SUM(p.hours) DESC")
    List<TopGamesDto> findTop10GamesByHoursDesc();
    
    @Query("SELECT NEW com.valve.api.dto.TopPlayersDto(p.player.username, CAST(SUM(p.hours) AS int)) "
            + "FROM PlayerGameHours p "
            + "GROUP BY p.player.id, p.player.username "
            + "ORDER BY SUM(p.hours) DESC")
    List<TopPlayersDto> findTop10PlayersByHoursDesc();





}
