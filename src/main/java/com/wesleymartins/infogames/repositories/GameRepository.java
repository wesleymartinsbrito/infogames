package com.wesleymartins.infogames.repositories;

import com.wesleymartins.infogames.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {

}
