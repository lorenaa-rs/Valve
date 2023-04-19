package com.valve.api.repositories;

import com.valve.api.entities.Game;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {

    List<Game> findByName(String name);

}
