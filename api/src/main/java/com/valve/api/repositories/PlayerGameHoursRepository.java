package com.valve.api.repositories;

import com.valve.api.entities.PlayerGameHours;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerGameHoursRepository extends JpaRepository<PlayerGameHours, Long> {

    List<PlayerGameHours> findByPlayerId(Long playerId);
    
    List<PlayerGameHours> findByGameId(Long gameId);

}

