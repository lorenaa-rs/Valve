package com.valve.api.repositories;

import com.valve.api.dto.PlayerGameHoursDto;
import com.valve.api.entities.Game;
import com.valve.api.entities.Player;
import com.valve.api.entities.PlayerGameHours;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PlayerGameHoursRepository extends JpaRepository<PlayerGameHours, Long> {

    List<PlayerGameHours> findByPlayerId(Long playerId);

    List<PlayerGameHours> findByGameId(Long gameId);

    @Query("SELECT NEW com.valve.api.dto.PlayerGameHoursDto(p.player.firstName, CAST(SUM(p.hours) AS int))\n"
            + "FROM com.valve.api.entities.PlayerGameHours p \n"
            + "WHERE p.game.id = :game \n"
            + "GROUP BY p.player \n"
            + "ORDER BY SUM(p.hours) DESC")
    List<PlayerGameHoursDto> findTop10PlayersSumHoursByGameOrderByHoursDesc(@Param("game") Long game);

}
