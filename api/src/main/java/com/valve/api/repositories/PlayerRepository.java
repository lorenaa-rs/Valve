package com.valve.api.repositories;

import com.valve.api.entities.Player;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {

    List<Player> findByUsername(String username);

}
